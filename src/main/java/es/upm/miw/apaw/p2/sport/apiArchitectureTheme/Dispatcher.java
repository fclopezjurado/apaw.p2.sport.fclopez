package es.upm.miw.apaw.p2.sport.apiArchitectureTheme;

import es.upm.miw.apaw.p2.sport.api.UserResource;
import es.upm.miw.apaw.p2.sport.api.SportResource;
import es.upm.miw.apaw.p2.sport.exceptions.InvalidRequestException;
import es.upm.miw.apaw.p2.sport.exceptions.InvalidNumberOfQueryParametersInRequestException;
import es.upm.miw.apaw.p2.sport.exceptions.InvalidQueryParametersInRequestException;
import es.upm.miw.apaw.p2.sport.exceptions.InvalidRequestBodyException;
import es.upm.miw.web.http.HttpRequest;
import es.upm.miw.web.http.HttpResponse;
import es.upm.miw.web.http.HttpStatus;

public class Dispatcher {
	private UserResource userResource = new UserResource();
	private SportResource sportResource = new SportResource();

	private void responseError(HttpResponse response, Exception e) {
		response.setBody("{\"error\":\"" + e + "\"}");
		response.setStatus(HttpStatus.BAD_REQUEST);
	}

	public void doGet(HttpRequest request, HttpResponse response) {
		// GET **/users
		if ("users".equals(request.getPath()))
			response.setBody(userResource.userList().toString());
		// GET **/users/search?sport=*
		else if (("users".equals(request.paths()[0])) && ("search".equals(request.paths()[1]))) {
			if (request.getParams().size() == 1) {
				if (request.getParams().get("sport") == null)
					responseError(response, new InvalidQueryParametersInRequestException(request.getParams()));
				else {
					try {
						response.setBody(userResource.searchUser(request.getParams().get("sport")).toString());
					} catch (Exception e) {
						responseError(response, e);
					}
				}
			} else
				responseError(response, new InvalidNumberOfQueryParametersInRequestException(request.getParams()));
		} else
			responseError(response, new InvalidRequestException(request.getPath()));
	}

	public void doPost(HttpRequest request, HttpResponse response) {
		switch (request.getPath()) {
		// POST **/users body="nick:email"
		case "users":
			String[] splitBody = request.getBody().split(":");

			if (splitBody.length != 2)
				responseError(response, new InvalidRequestBodyException(request.getBody()));
			else {
				// Injectar parámetros...
				try {
					userResource.createUser(splitBody[0], splitBody[1]);
					response.setStatus(HttpStatus.CREATED);
				} catch (Exception e) {
					this.responseError(response, e);
				}
			}
			break;
		// POST **/sports body="themeName"
		case "sports":
			// Injectar parámetros...
			try {
				sportResource.createSport(request.getBody());
				response.setStatus(HttpStatus.CREATED);
			} catch (Exception e) {
				this.responseError(response, e);
			}
			break;
		default:
			responseError(response, new InvalidRequestException(request.getPath()));
			break;
		}
	}

	public void doPut(HttpRequest request, HttpResponse response) {
		// PUT **/users/{nick}/sport body="sportName"
		if ("users".equals(request.paths()[0]) && "sport".equals(request.paths()[2])) {
			try {
				userResource.addSport(request.paths()[1], request.getBody());
			} catch (Exception e) {
				responseError(response, e);
			}
		} else
			responseError(response, new InvalidRequestException(request.getPath()));
	}

}
