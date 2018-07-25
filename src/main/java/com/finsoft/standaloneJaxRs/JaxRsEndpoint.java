package com.finsoft.standaloneJaxRs;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
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

	/**
	 * Accept any POST request, echoes it body, write to stdout some more info.
	 * 
	 * @param body
	 * @param request
	 * @return
	 */
	@POST
	// @Consumes(MediaType.APPLICATION_JSON) not supported!
	@Produces(MediaType.TEXT_PLAIN)
	@Path("echo")
	public String postData(String body, @Context HttpServletRequest request) {
		System.out.println("postData body=" + body);

		Enumeration<String> headers = request.getHeaderNames();
		while (headers.hasMoreElements()) {
			String header = headers.nextElement();
			System.out.println("Header " + header + ": " + request.getHeader(header));
		}
		return "received: " + body;
	}

	/**
	 * Always return an HTTP 500 error
	 * 
	 * @param body
	 * @return
	 */
	@POST
	// @Consumes(MediaType.APPLICATION_JSON) not supported!
	@Produces(MediaType.TEXT_PLAIN)
	@Path("err")
	public Response postDataError(String body) {
		System.out.println("postData throwing exception");
		return Response.serverError().build();
	}
}