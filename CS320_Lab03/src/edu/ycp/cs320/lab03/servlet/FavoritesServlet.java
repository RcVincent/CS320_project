package edu.ycp.cs320.lab03.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.lab03.controller.Patron;
import edu.ycp.cs320.lab03.controller.ProjectController;

public class FavoritesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("/_view/Favorites.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		// Decode form parameters and dispatch to controller
		String errorMessage = null;
		String newFavorite = null;
		try {
			
			newFavorite = req.getParameter("newfavorite");

			if (newFavorite != null) {
//				Patron pat = null;
//				
//				pat.addTofavorites(rest);
				
			}
		} catch (NumberFormatException e) {
			errorMessage = "Invalid value";
		}
		
		// Add parameters as request attributes
		req.setAttribute("newfavorite", req.getParameter("newfavorite"));
		
		
		// Add result objects as request attributes
		req.setAttribute("errorMessage", errorMessage);
		
		
		// Forward to view to render the result HTML document
		req.getRequestDispatcher("/_view/Favorites.jsp").forward(req, resp);
	}
}
