package servlet;

import model.Motobike;
import model.MotobikeColor;
import model.MotobikeCompany;
import model.MotobikeType;
import service.MotobikeColorService;
import service.MotobikeCompanyService;
import service.MotobikeService;
import service.MotobikeTpyeService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet({"/motobike/edit","/motobike/update"})
public class UpdateMotobikeServlet extends HttpServlet {

    private MotobikeService motobikeService;
    private MotobikeCompanyService motobikeCompanyService;
    private MotobikeColorService motobikeColorService;
    private MotobikeTpyeService motobikeTpyeService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURL().toString();
        if(url.contains("edit")){
            List<MotobikeCompany> motobikeCompany = motobikeCompanyService.getAllMotobikeCompany();
            req.setAttribute("motobikeCompany",motobikeCompany);
            List<MotobikeColor> motobikeColor = motobikeColorService.getAllMotobikeColor();
            req.setAttribute("motobikeColor",motobikeColor);
            List<MotobikeType> motobikeType = motobikeTpyeService.getAllMotobikeType();
            req.setAttribute("motobikeType",motobikeType);
            editMotobike(req,resp);
            req.getRequestDispatcher("/views/update.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    protected void editMotobike(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            Motobike motobike = new Motobike();
            motobike = motobikeService.findById(id);
            req.setAttribute("motobike",motobike);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
