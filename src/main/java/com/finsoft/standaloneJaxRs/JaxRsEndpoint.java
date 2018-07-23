package com.finsoft.standaloneJaxRs;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;

@Path("/")
public class JaxRsEndpoint {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getData(@Context Request request) {
		System.out.println("getData");
		return "Hello world";
	}

	@POST
	// @Consumes(MediaType.APPLICATION_JSON) not supported!
	@Produces(MediaType.TEXT_PLAIN)
	@Path("echo")
	public String postData(String body) {
		System.out.println("postData body=" + body);
		return "received: " + body;
	}


	@POST
	// @Consumes(MediaType.APPLICATION_JSON) not supported!
	@Produces(MediaType.TEXT_PLAIN)
	@Path("echo")
	public Response postDataError(String body) {
		System.out.println("postData throwing exception");
		return Response.serverError().build();
	}
}