package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Motobike;
import service.MotobikeService;




@WebServlet("/home")
public class HomeServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	private MotobikeService motobikeService;
	private List<Motobike> listMotobikes;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		findAll(req, resp);
		req.getRequestDispatcher("/views/index.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		findAll(req, resp);
		req.getRequestDispatcher("/views/index.jsp").forward(req, resp);
	}
	
	protected void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			listMotobikes = motobikeService.getAllMotobike();
			req.setAttribute("listXe", listMotobikes);
		} catch (Exception e) {
			e.printStackTrace();
		};
	}
	
}
