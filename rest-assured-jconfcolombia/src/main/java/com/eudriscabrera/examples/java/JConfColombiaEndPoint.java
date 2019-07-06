package com.eudriscabrera.examples.java;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

/**
 * @author ecabrerar
 *
 */
@Path("/jconfcolombia")
public class JConfColombiaEndPoint {

	@GET
	@Path("/sessions")
	@Produces("application/json")
	public Response desconferencias(@DefaultValue("") @QueryParam("time") String time) {
		
		if(time.isBlank()) {
			return Response.ok(new SessionResource().getSessions()).build();			
		}
		
		return Response.ok(new SessionResource().getSessions().stream().filter(session -> session.getTime().equals(time)).map(session->session).collect(Collectors.toList())).build(); 

	}

	@GET
	@Path("/speakers")
	@Produces("application/json")
	public Response desconferencistas() {
		return Response.ok(new SessionResource().getSessions().stream().map(session -> session.getSpeaker())
				.collect(Collectors.toList())).build();
	}
	
	@POST
	@Path("/sessions")
	@Consumes("application/json")
	@Produces("application/json")
	public Response guardar(Session seccion) {
		return Response.ok(seccion).build();		
	}

	@GET
	@Path("/sessions/{sessionId}")
	@Produces("application/json")
	public Response getSpeaker(@PathParam("sessionId") String sessionId) {
		return Response.ok(new SessionResource().getSessions().stream().filter(session -> session.getId() == Integer.parseInt(sessionId))
				.map(session->session)
				.peek(session->System.out.println(session))
				.collect(Collectors.toList())).build();
	}

	static class SessionResource {

		private List<Session> getSessions() {

			List<Session> sessions = new ArrayList<Session>();
			sessions.add(new Session(101, "Modern Identity Management (en la Era de Serverless y Microservices)","Mercedes Wyss", "8:30"));
			sessions.add(new Session(102, "The Reactive Revolution", "Josh Long", "10:00"));
			sessions.add(new Session(103, "Keynote", "Venkat Subramaniam", "11:00"));
			sessions.add(new Session(104, "Arquitecturas híbridas",
					"Ubaldo Villaseca", "13:00"));
			sessions.add(
					new Session(105, "Mitos y realidades de los microservicios, JakartaEE, Microprofile y su ecosistema", "Jorge Vargas", "13:00"));
			sessions.add(new Session(106, "Pruebas de Integración para Servicios REST usando REST Assured",
					"Eudris Cabrera", "13:00"));
			
			sessions.add(new Session(107, "Despliegue de aplicaciones en Kubernetes con Azure Devops en multinubee",
					"Jose Diaz", "13:00"));
			
			sessions.add(
					new Session(108, "From Functional to Reactive Programming (Part I)", "Venkat Subramaniam", "13:40"));
			
			sessions.add(new Session(109, "Implementando Paginas Web Modernas en Java","Alejandro Duarte", "13:40"));
			sessions.add(new Session(110, "Consumer Driven Contract Testing con Spring Cloud Contract","Eddú Meléndez", "13:40"));
			sessions.add(new Session(111, "Serverless Java Beyond Lambda: What every Developer Must Know","Frank Munz", "13:40"));
			
			sessions.add(
					new Session(112, "From Functional to Reactive Programming (Part II)", "Venkat Subramaniam", "14:30"));
			
			sessions.add(new Session(113,
					"Bebiendo del Stream: Como usar las plataformas de mensajería para escalamiento y rendimiento",
					"Mark Heckler", "14:30"));
			
			sessions.add(new Session(114, "Despliegue de Microservicios con SpringBoot en Kubernetes", "Isaias Lopez", "14:30"));
			
			sessions.add(new Session(115, "Java & AWS: Son una pareja bonita", "Julian Castellanos", "14:30"));
			
			sessions.add(new Session(116, "How Microsoft Learned to Love Java","Reza Rahman", "15:30"));
			
			sessions.add(new Session(117, "¿Java EE? ¿Jakarta EE? ¿MicroProfile? ¿O tal vez, todos ellos?",
					"Sebastian Daschner", "15:30"));
			
			sessions.add(new Session(118, "Hoy en día las tendencias en arquitectura, de monoliticos a microservicios y Serverless",
					"Alberto Salazar", "15:30"));
			sessions.add(new Session(119, "Oracle APEX como frontend para tu Java backend", "Mónica Godoy / Alexis López", "15:30"));
			
			sessions.add(new Session(120, "FullStack reactive with Spring and Angular", "Loiane Groner", "16:10"));
			sessions.add(new Session(121, "Diversión con Kubernetes y Payara Micro 5", "Fabio Turizo", "16:10"));			
			sessions.add(new Session(122, "Serverless con Openfaas y Java", " Carlos Camacho", "16:10"));			
			sessions.add(new Session(123, "Arquitectura de microservicios reactivos con Reactive Commons", "Daniel Bustamante", "16:10"));
			
			sessions.add(new Session(124, "Quarkus: Fast, small, innovative, and native?!",
					"Rafael Benevides", "16:50"));
			sessions.add(new Session(125, "Bootiful Testing", "Josh Long", "16:50"));
			sessions.add(new Session(126, "CI/CD con AWS(CodePipeline + EB), GitHub y SpringBoot",
					"Hans Ospina", "16:50"));
			sessions.add(new Session(127, "Jakarta EE Meets NoSQL in the Cloud Age",
					"Otavio Santana", "16:50"));
			

			return sessions;
		}
	}
}
