package org.dsi.controller.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.dsi.entity.User;
import org.dsi.repository.UserRepositoryImpl;

import java.io.IOException;
import java.sql.Date;

public class UserAddServlet extends HttpServlet {

    private UserRepositoryImpl userRepository;

    @Override
    public void init() throws ServletException {
        userRepository = new UserRepositoryImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        synchronized (this) {
            getServletContext().setAttribute("siteVisitCounter", Integer.parseInt(getServletContext().getAttribute("siteVisitCounter").toString()) + 1);
        }

        request.getRequestDispatcher("/views/front/user/userAdd.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        user.setName(request.getParameter("name"));
        user.setEmail(request.getParameter("email"));
        user.setMobile(request.getParameter("mobile"));
        user.setDob(Date.valueOf(request.getParameter("dob")).toLocalDate());

        HttpSession session = request.getSession();

        String redirectTo = "/user";

        try {
            this.userRepository.save(user);
            session.setAttribute("status", "User added successfully...");
        } catch (Exception e) {
            session.setAttribute("status", "User can not be added...");
            redirectTo = "/user/add";
        }

        response.sendRedirect(redirectTo);
    }
}
