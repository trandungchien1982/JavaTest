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
@WebServlet("/addOne2")
public class AddOne2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@EJB
	CounterBean counter;
	
	CounterStatefulBean counterStateful;	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddOne2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		
		out.println("22 - Current counter value : " + counter.getCount());		
		counter.addOneToCount();		
		out.println("22 - The counter value after ++ : " + counter.getCount());		

		out.println("");
		this.counterStateful = (CounterStatefulBean)request.getSession().getAttribute("statefulBean");
		
		out.println("22 - Current counterStateful value : " + counterStateful.getCount());		
		counterStateful.addOneToCount();		
		out.println("22 - The counterStateful value after ++ : " + counterStateful.getCount());		
	
	}

}
