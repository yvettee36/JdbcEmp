package com.chinasofti.web;

import com.chinasofti.domain.Emp;
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
@WebServlet(name = "EmpListServlet", urlPatterns = "/EmpListServlet")
public class EmpListServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        int deptno = Integer.parseInt(request.getParameter("deptno"));
        System.out.println(deptno);
        EmpService empService = new EmpServiceImpl();
        List<Emp> list = empService.findByDno(deptno);
        request.setAttribute("list",list);
        request.getRequestDispatcher("/listEmp.jsp").forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
