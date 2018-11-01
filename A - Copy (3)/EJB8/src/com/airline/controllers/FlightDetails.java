package com.airline.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.airline.service.FlightLocal_ejb8;
Tan61 cong nguoi moi den
/**
 * Servlet implementation class FlightDetails
 */
@WebServlet("/flightDetails")
public class FlightDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// Inject FlightServiceStatefulBean
	@EJB(beanName="flightStateful")
	FlightLocal_ejb8 fStateful = null;

	// Inject FlightServiceStatefulBean
	@EJB(beanName="flightStateful")
	FlightLocal_ejb8 fStateful1 = null;

	// Inject FlightServiceStatelessBean
	@EJB(beanName="flightStateless")
	FlightLocal_ejb8 fStateless = null;

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
			
		out.println("<br>FS Stateful   : " + fStateful.hashCode());		
		out.println("<br>FS Stateful_1 : " + fStateful1.hashCode());
		
		out.println("<br>FS Stateless : " + fStateless.hashCode());
	}
}
