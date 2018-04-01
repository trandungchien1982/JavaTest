package com.airline.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.airline.service.CounterBean;
import app.airline.service.CounterStatefulBean;

/**
 * Servlet implementation class AddOne
 */
@WebServlet("/addOne")
public class AddOne extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@EJB
	CounterBean counter;
		
	CounterStatefulBean counterStateful;	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddOne() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		PrintWriter out = response.getWriter();
		
		out.println("Current counter value : " + counter.getCount());		
		counter.addOneToCount();		
		out.println("The counter value after ++ : " + counter.getCount());		

		out.println("");
		
		this.counterStateful = (CounterStatefulBean)request.getSession().getAttribute("statefulBean");
		out.println("SESSION - Current counterStateful value : " + counterStateful.toString());
		out.println("SESSION - Current counterStateful value : " + counterStateful.getCount());		
		counterStateful.addOneToCount();		
		out.println("SESSION - The counterStateful value after ++ : " + counterStateful.getCount());		
	
	}

}
