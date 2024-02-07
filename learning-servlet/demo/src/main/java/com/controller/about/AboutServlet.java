package com.controller.about;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class AboutServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {}

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();
        String name = servletContext.getInitParameter("name");
        String university = servletContext.getInitParameter("university");

        System.out.println("I'm " + name + " from " + university);

        request.getRequestDispatcher("views/about.jsp").forward(request, response);
    }

    @Override
    public void destroy() {}
}
