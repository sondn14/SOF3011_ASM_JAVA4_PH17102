package servlet;

import model.Motobike;
import model.MotobikeCompany;
import service.MotobikeCompanyService;
import service.MotobikeService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet({"/motobike/index","/motobike/delete"})
public class ManagerMotorbikeServlet extends HttpServlet {

    private MotobikeService motobikeService;
    private List<Motobike> listMotobikes;
    private MotobikeCompanyService motobikeCompanyService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURL().toString();
        if(url.contains("index")){
            findAll(req,resp);
            findAllCompany(req,resp);
            req.getRequestDispatcher("/views/table.jsp").forward(req,resp);
        }else if(url.contains("delete")){
            deleteMotobike(req,resp);
            resp.sendRedirect("/cuahangxemay/motobike/index");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    protected void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            listMotobikes = motobikeService.getAllMotobike();
            req.setAttribute("listXe", listMotobikes);
        } catch (Exception e) {
            e.printStackTrace();
        };
    }

    protected void findAllCompany(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<MotobikeCompany> listCompany = new ArrayList<>();
            listCompany = motobikeCompanyService.getAllMotobikeCompany();
            req.setAttribute("company",listCompany);
        } catch (Exception e) {
            e.printStackTrace();
        };
    }

    protected void deleteMotobike(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.valueOf(req.getParameter("id"));
            motobikeService.deleteMotobike(id);
        } catch (Exception e) {
            e.printStackTrace();
        };
    }
}
