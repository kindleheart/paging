package com.kindleheart.servlet;

import com.kindleheart.model.PageBean;
import com.kindleheart.service.StudentService;
import com.kindleheart.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "StudentServlet", urlPatterns = "/student.do")
public class StudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //得到当前页面数
        int currentPage = Integer.parseInt(request.getParameter("currentPage"));

        //得到封装好所有数据的PageBean对象
        StudentService studentService = new StudentServiceImpl();
        PageBean pageBean = null;
        try {
            pageBean = studentService.getStudentsWithPage(currentPage, 3);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //把pageBean对象放到request域里
        request.setAttribute("pageBean", pageBean);
        request.getRequestDispatcher("jsp/stulist.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
