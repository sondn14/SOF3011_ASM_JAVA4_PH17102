package servlet;

import model.Motobike;
import service.MotobikeService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "MotobikeDetailServlet", value = "/motobike-detail")
public class MotobikeDetailServlet extends HttpServlet {

    private MotobikeService motobikeService;
    private List<Motobike> listMotobikes;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        findById(req,resp);
        findAll(req,resp);
        req.getRequestDispatcher("/views/detail.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        findById(req,resp);
        findAll(req,resp);
        req.getRequestDispatcher("/views/detail.jsp").forward(req,resp);
    }

    protected void findById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String paramId = req.getParameter("id");
        int id = Integer.parseInt(paramId);
        Motobike motobike = motobikeService.findById(id);
        req.setAttribute("motobike",motobike);
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
