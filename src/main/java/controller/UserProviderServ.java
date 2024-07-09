package controller;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.UserProviderDto;
import service.serviceimp.ServiceProvidersImp;

import java.io.IOException;

@WebServlet("/providers")
public class UserProviderServ extends HttpServlet {
    public ServiceProvidersImp servProvider  =  new ServiceProvidersImp();
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setAttribute("providers_res", servProvider.getAllUserProviders());
        System.out.println(servProvider.getAllUserProviders());
        req.getRequestDispatcher("index.jsp").forward(req, res);
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        UserProviderDto user = new UserProviderDto();
        user.setNombre(req.getParameter("name"));
        user.setRut(req.getParameter("rut"));
        user.setDireccion(req.getParameter("address"));
        user.setCorreo(req.getParameter("mail"));
        user.setTelefono(req.getParameter("phoneNumber"));
        user.setContacto(req.getParameter("contact"));
        user.setTelefono_contacto(req.getParameter("contacNumber"));
        Boolean resp = servProvider.insertUserProvider(user);

        if(!resp){
            req.setAttribute("respNewUser","El Usuario no se pudo crear");
        }

        req.setAttribute("providers_res", servProvider.getAllUserProviders());
        req.getRequestDispatcher("index.jsp").forward(req,res);
    }
}