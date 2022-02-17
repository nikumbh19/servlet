package com.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.model.persistence.trainee.BranchEnum;
import com.model.persistence.trainee.Trainee;
import com.model.service.trainee.TraineeService;
import com.model.service.trainee.TraineeServiceImpl;

@WebServlet("/TraineeController.do")
public class TraineeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private TraineeService traineeService = new TraineeServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Disable cache in the browser to prevent going back in history after
		// logging out or session out. This is particular for this page only.
		response.setHeader("Cache-Control", "private,no-store,no-cache");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", -1);

		String action = request.getParameter("action");
		RequestDispatcher rd;
		
		if(action.equalsIgnoreCase("showall")) {
			List<Trainee> trainees = traineeService.getAll();
			request.setAttribute("trainees", trainees);
			rd = request.getRequestDispatcher("listAllEmployees.jsp");
			rd.forward(request, response);
		}else if(action.equalsIgnoreCase("addtrainee")) {
			rd = request.getRequestDispatcher("addTrainee.jsp");
			rd.forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			String name = request.getParameter("name");
			String branch = request.getParameter("branch").toUpperCase();
			Double percentage = Double.parseDouble(request.getParameter("percentage"));
			
			Trainee trainee = new Trainee(name,BranchEnum.valueOf(branch),percentage);
		
				traineeService.addTrainee(trainee);
			
			response.sendRedirect("TraineeController.do?action=showall");
	}

}
