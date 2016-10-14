package br.com.original.restclient;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;

import br.com.original.CONFIG;
import br.com.original.database.FakeDatabase;

public class MyRestClient {

	private static Client c;

	static {
		c = Client.create();
	}

	/**
	 * 
	 * @param url
	 * @return
	 * @throws IllegalStateException
	 */
	public static Builder createClientWithAuthentication(String url) throws IllegalStateException {
		if (FakeDatabase.attributes.size() == 0){
			throw new IllegalStateException();
		}

		WebResource r = c.resource(url);
		Builder accept = r.accept(MediaType.APPLICATION_JSON_TYPE);
		accept = accept.type(MediaType.APPLICATION_JSON_TYPE);
		accept = accept.header("Authorization", FakeDatabase.attributes.get("ACCESSTOKEN"));
		accept = accept.header("developer-key", CONFIG.DEV_APP_KEY.getValue());
		return accept;
	}

	public static Builder createClient(String url) throws IllegalStateException {
		WebResource r = c.resource(url);

		Builder accept = r.accept(MediaType.APPLICATION_JSON_TYPE);
		accept = accept.type(MediaType.APPLICATION_JSON_TYPE);
		accept = accept.header("developer-key", CONFIG.DEV_APP_KEY.getValue());
		return accept;
	}

}
