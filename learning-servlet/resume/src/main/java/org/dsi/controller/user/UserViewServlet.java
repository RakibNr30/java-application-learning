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

public class UserViewServlet extends HttpServlet {

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

        String[] parts = request.getPathInfo().split("/");
        int id = Integer.parseInt(parts[1]);

        User user = userRepository.getById(id);

        if (user == null) {
            request.getSession().setAttribute("status", "User not found");
            response.sendRedirect("/user");
            return;
        }

        request.setAttribute("user", user);

        request.getRequestDispatcher("/views/front/user/userView.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] parts = request.getPathInfo().split("/");

        User user = userRepository.getById(Integer.parseInt(parts[1]));

        HttpSession session = request.getSession();

        String redirectTo = "/user";

        if (user == null) {
            request.getSession().setAttribute("status", "User not found");
            response.sendRedirect(redirectTo);
            return;
        }

        try {
            this.userRepository.delete(user);
            session.setAttribute("status", "User deleted successfully...");
        } catch (Exception e) {
            session.setAttribute("status", "User can not be deleted...");
        }

        response.sendRedirect(redirectTo);
    }
}
