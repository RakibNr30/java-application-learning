package com.controller.redirect;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class ContactRedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");

        String dispatchedFrom = (String) request.getAttribute("dispatched_from");
        */

        /* get url param */
        String dispatchedFrom = request.getParameter("dispatched_from");

        /* get session */
        HttpSession httpSession = request.getSession();
        /* get session attribute */
        String redirectFrom = (String) httpSession.getAttribute("redirectFrom");
        /* remove session attribute */
        httpSession.removeAttribute("redirectFrom");

        /* get cookies */
        Cookie[] cookies = request.getCookies();

        for (Cookie cookie: cookies) {
            System.out.println(cookie.getName() + " - " + cookie.getValue());
        }

        PrintWriter printWriter = response.getWriter();

        printWriter.println("Redirect from " + redirectFrom + " and dispatched from " + dispatchedFrom);
    }
}
