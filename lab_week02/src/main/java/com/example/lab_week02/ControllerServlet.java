package com.example.lab_week02;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Employee;
import repositories.EmployeeRespository;

import java.io.IOException;

@WebServlet(urlPatterns = {"/","/Controll"})
public class ControllerServlet extends HttpServlet {
    private static EmployeeRespository emr;
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("login.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("username");
        String phone = req.getParameter("phone");
        emr = new EmployeeRespository();
        Employee employee = emr.checkLogIn(email,phone);
        if(employee != null){
            RequestDispatcher res = req.getRequestDispatcher("detail.jsp");
            res.forward(req,resp);
        }else{
            RequestDispatcher res = req.getRequestDispatcher("login.jsp");
            res.forward(req, resp);
        }

    }
}
