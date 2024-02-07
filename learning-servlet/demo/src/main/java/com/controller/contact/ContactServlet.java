package com.controller.contact;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/*@WebServlet(urlPatterns = "/contact")*/
@WebServlet("/contact")
public class ContactServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {}

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* jstl sql */
        request.getRequestDispatcher("views/contact.jsp").forward(request, response);
    }

    @Override
    public void destroy() {}
}
