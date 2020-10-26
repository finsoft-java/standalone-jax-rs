package com.finsoft.standaloneJaxRs;

import com.sun.net.httpserver.HttpServer;

import java.net.URI;

import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

@SuppressWarnings("restriction")
public class App {

	private final static int port = 9998;
	private final static String host = "http://localhost/";

	public static void main(String[] args) {
		URI baseUri = UriBuilder.fromUri(host).port(port).build();
		ResourceConfig config = new ResourceConfig(JaxRsEndpoint.class);
		HttpServer server = JdkHttpServerFactory.createHttpServer(baseUri, config);
		System.out.println("Web server running on port " + port + "...");
		System.out.println("Accepted paths:");
		System.out.println("GET /");
		System.out.println("POST /echo");
		System.out.println("POST /echoContext");
		System.out.println("POST /err");
	}
}