package servlet;

import model.Motobike;
import service.MotobikeService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ShopServlet", value = "/shop")
public class ShopServlet extends HttpServlet {

    private MotobikeService motobikeService;
    private List<Motobike> listMotobikes;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        findAll(req,resp);
        req.getRequestDispatcher("/views/shop.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        findAll(req,resp);
        req.getRequestDispatcher("/views/shop.jsp").forward(req,resp);
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
