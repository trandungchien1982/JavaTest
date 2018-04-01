package com.airline.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.airline.service.FlightLocal;
import app.airline.service.FlightRemote;
import app.airline.service.FlightService;

/**
 * Servlet implementation class FlightDetails
 */
@WebServlet("/flightDetails")
public class FlightDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// Enject local bean
	@EJB
	FlightLocal fs = null;
	
	@EJB
	FlightRemote fsRemote = null;

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
			
		out.println("<br>FS content inject : " + fs.hashCode());
		out.println("<br>fsRemote content inject : " + fsRemote.hashCode());
	}
}
