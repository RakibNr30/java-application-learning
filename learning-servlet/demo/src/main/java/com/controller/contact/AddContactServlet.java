package com.controller.contact;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/add-contact")
public class AddContactServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*String name = request.getParameter("name");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");

        PrintWriter printWriter = response.getWriter();
        printWriter.write(name + " - " + email + " - " + mobile);*/

        /* request forwarding ways: 1. RequestDispatcher, 2. Redirect */

        request.setAttribute("dispatchedFrom", "ContactServlet");

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("contact-handle");
        requestDispatcher.forward(request, response);
    }
}
