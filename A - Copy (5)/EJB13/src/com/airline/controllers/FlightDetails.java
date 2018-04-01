package com.airline.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Random;

import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.ws.util.StringUtils;

import app.airline.service.FlightLocal_ejb13;

/**
 * Servlet implementation class FlightDetails
 */
@WebServlet("/flightDetails")
public class FlightDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	FlightLocal_ejb13 fStateless = null;
	FlightLocal_ejb13 fStateless2 = null;
	FlightLocal_ejb13 fStateless3 = null;
	FlightLocal_ejb13 fStateless4 = null;
	
	FlightLocal_ejb13 fStateful = null;
	FlightLocal_ejb13 fStateful2 = null;
	FlightLocal_ejb13 fStateful3 = null;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FlightDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();  		
		
		try {
			Context context = new InitialContext();
			
			this.fStateless   = (FlightLocal_ejb13)context.lookup("java:global/EJB10/flightStateless!app.airline.service.FlightLocal_ejb10");
			this.fStateless2  = (FlightLocal_ejb13)context.lookup("java:global/EJB10/flightStateless!app.airline.service.FlightLocal_ejb10");
			this.fStateless3  = (FlightLocal_ejb13)context.lookup("java:global/EJB10/flightStateless!app.airline.service.FlightLocal_ejb10");
			this.fStateless4  = (FlightLocal_ejb13)context.lookup("java:global/EJB10/flightStateless!app.airline.service.FlightLocal_ejb10");
			
			this.fStateful  = (FlightLocal_ejb13)context.lookup("java:global/EJB10/flightStateful!app.airline.service.FlightLocal_ejb10");
			this.fStateful2 = (FlightLocal_ejb13)context.lookup("java:global/EJB10/flightStateful!app.airline.service.FlightLocal_ejb10");
			this.fStateful3 = (FlightLocal_ejb13)context.lookup("java:global/EJB10/flightStateful!app.airline.service.FlightLocal_ejb10");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		if (fStateless.getFrom() == null) {
			fStateless.setFrom("From fStateless : " + System.currentTimeMillis());
		}
		if (fStateless.getTo() == null) {
			fStateless.setFrom("To fStateless : " + System.currentTimeMillis());
		}		
		out.println("<br>FS Stateless0, From/To : " + fStateless.getFrom() + " >> " + fStateless.getTo());
		
		out.println("<br>FS fStateless0 : " + fStateless.toStringAll());		
		out.println("<br>FS fStateless2 : " + fStateless2.toStringAll());
		out.println("<br>FS fStateless3 : " + fStateless3.toStringAll());
		out.println("<br>FS fStateless4 : " + fStateless4.toStringAll());
		
		
		if (fStateful.getFrom() == null) {
			fStateful.setFrom("From Stateful : " + System.currentTimeMillis());
		}
		if (fStateful.getTo() == null) {
			fStateful.setTo("To Stateful : " + System.currentTimeMillis());
		}
		
		fStateful2.setFrom("From fStateful2");
		fStateful2.setTo("To fStateful2");
		out.println("<br>");
		out.println("<br>FS Stateful : " + fStateful.toStringAll());
		out.println("<br>FS Stateful2 : " + fStateful2.toStringAll());
		out.println("<br>FS Stateful3 : " + fStateful3.toStringAll());

		
	}
}
