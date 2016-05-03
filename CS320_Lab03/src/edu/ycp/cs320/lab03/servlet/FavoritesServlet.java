package edu.ycp.cs320.lab03.servlet;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import edu.ycp.cs320.lab03.controllers.AddToFavoriteRestaurants;
import edu.ycp.cs320.lab03.model.Favorites;

public class FavoritesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AddToFavoriteRestaurants add = null;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String user = (String) req.getSession().getAttribute("username");
		if (user == null) {
			// user is not logged in, or the session expired
			resp.sendRedirect(req.getContextPath() + "/Login");
			return;
		}
		//Initialize variables
		String rest = null;
		ArrayList<Favorites> favs = new ArrayList<Favorites>();
		int userId =(int) req.getSession().getAttribute("userID");
		add = new AddToFavoriteRestaurants();
		rest = req.getParameter("restaurant");
		//search restaurants by owner
		add.AddUser(rest, userId);
		favs = add.GetFavs(userId);
		if(favs!=null){
			req.setAttribute("rest", favs);
		}
		req.getRequestDispatcher("/_view/Favorites.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		
		ArrayList<Favorites> favs = new ArrayList<Favorites>();
		int userId =(int) req.getSession().getAttribute("userID");
		add = new AddToFavoriteRestaurants();
		//search restaurants by owner
		favs = add.GetFavs(userId);
		if(favs!=null){
			req.setAttribute("rest", favs);
		}
		// Forward to view to render the result HTML document
		req.getRequestDispatcher("/_view/Favorites.jsp").forward(req, resp);
	}
}