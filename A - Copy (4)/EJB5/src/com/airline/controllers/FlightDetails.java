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

import app.airline.service.FlightService;

/**
 * Servlet implementation class FlightDetails
 */
@WebServlet("/flightDetails")
public class FlightDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// Set default null value for getting @EJB later
	FlightService fs = null;

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
			Object fObj = context.lookup("java:global/EJB5/FlightService!app.airline.service.FlightService");
			fs = (FlightService)fObj;
			
		} catch (NamingException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		if (fs != null) {
			out.println("FS content : " + fs);
		}
	}
}
