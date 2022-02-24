package com.example.servlet;

import java.io.*;
import java.util.List;

import com.example.entity.Book;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
/**
 * @author mingle
 * @date 2022/2/24 14:12
 * @description 拦截/index请求，获取所有图书数据，并通过服务器端转发跳转到主页
 */
@WebServlet(urlPatterns = "/index")
public class IndexServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获得各个Servlet共享的对象
        ServletContext sc = this.getServletContext();
        //取得全局应用对象中的变量
        List<Book> bookList = (List<Book>) sc.getAttribute("bookList");
        //存入request
        req.setAttribute("bookList", bookList);
        //通过服务器端转发，将数据带过去，并保持地址栏不变
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

}