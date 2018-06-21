package com.finsoft.standaloneJaxRs;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;

@Path("/")
public class JaxRsEndpoint {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getdata(@Context Request request) {
		return "Hello world";
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String postMovieEvent(@Context Request request, String json) {
		return "Received data " + json;
	}

}