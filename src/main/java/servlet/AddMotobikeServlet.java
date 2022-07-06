package servlet;

import model.Motobike;
import model.MotobikeColor;
import model.MotobikeCompany;
import model.MotobikeType;
import org.apache.commons.beanutils.BeanUtils;
import service.MotobikeColorService;
import service.MotobikeCompanyService;
import service.MotobikeService;
import service.MotobikeTpyeService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@WebServlet({"/motobike/create","/motobike/add"})
public class AddMotobikeServlet extends HttpServlet {

    private MotobikeCompanyService motobikeCompanyService;
    private MotobikeColorService motobikeColorService;
    private MotobikeTpyeService motobikeTpyeService;

    private MotobikeService motobikeService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURL().toString();
        if(url.contains("create")){
            List<MotobikeCompany> motobikeCompany = motobikeCompanyService.getAllMotobikeCompany();
            req.setAttribute("motobikeCompany",motobikeCompany);
            List<MotobikeColor> motobikeColor = motobikeColorService.getAllMotobikeColor();
            req.setAttribute("motobikeColor",motobikeColor);
            List<MotobikeType> motobikeType = motobikeTpyeService.getAllMotobikeType();
            req.setAttribute("motobikeType",motobikeType);
            req.getRequestDispatcher("/views/add.jsp").forward(req,resp);

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURL().toString();
        if(url.contains("add")){
            addMotobike(req,resp);
            resp.sendRedirect("/cuahangxemay/motobike/index");
        }
    }

    protected void addMotobike(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Motobike motobike = new Motobike();
        try {
            BeanUtils.populate(motobike,req.getParameterMap());
            int maColor = Integer.parseInt(req.getParameter("id-color"));
            motobike.setMotobikeColor(new MotobikeColor(maColor,getServletName(),null));
            int maCompany = Integer.parseInt(req.getParameter("id-company"));
            motobike.setMotobikeCompany(new MotobikeCompany(maCompany,getServletName(),null));
            int maType = Integer.parseInt(req.getParameter("id-type"));
            motobike.setMotobikeType(new MotobikeType(maType,getServletName(),null));
            Calendar cal = Calendar.getInstance();
            Date date = cal.getTime();
            motobike.setCreatedate(date);
            motobikeService.addMotobike(motobike);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
