package com.controller.home;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/home")
public class IndexServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        getServletContext().setAttribute("siteVisitCounter", 0);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/front/home/index.jsp");
        requestDispatcher.forward(request, response);
    }
}
