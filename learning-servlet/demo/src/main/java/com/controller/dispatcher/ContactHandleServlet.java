package com.controller.dispatcher;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

public class ContactHandleServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");

        String dispatchedFrom = (String) request.getAttribute("dispatchedFrom");

        /*PrintWriter printWriter = response.getWriter();
        printWriter.println("Dispatched from " + dispatchedFrom + " - " + name + ", " + email + ", " + mobile);*/

        /* set session */
        HttpSession httpSession = request.getSession();
        /* set session attribute */
        httpSession.setAttribute("redirectFrom", "HandleServlet");

        /* cookie */
        Cookie firstName = new Cookie("firstName", name.split(" ")[0]);
        response.addCookie(firstName);
        Cookie lastName = new Cookie("lastName", name.split(" ")[1]);
        response.addCookie(lastName);

        response.sendRedirect("contact-redirect?dispatched_from=" + dispatchedFrom);
    }
}
