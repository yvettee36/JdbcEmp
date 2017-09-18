package com.chinasofti.web;

import com.chinasofti.service.EmpService;
import com.chinasofti.service.impl.EmpServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by yvettee on 2017/9/17.
 */
@WebServlet(name = "DeptnoServlet", urlPatterns = "/DeptnoServlet")
public class DeptnoServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EmpService empService = new EmpServiceImpl();
        List list = empService.getDeptno();
        request.setAttribute("list", list);
        request.getRequestDispatcher("/head.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
