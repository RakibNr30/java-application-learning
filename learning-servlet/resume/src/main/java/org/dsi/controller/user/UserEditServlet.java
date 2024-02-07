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

public class UserEditServlet extends HttpServlet {

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
        request.getRequestDispatcher("/views/front/user/userEdit.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] parts = request.getPathInfo().split("/");

        User user = new User();
        user.setId(Integer.parseInt(parts[1]));
        user.setName(request.getParameter("name"));
        user.setEmail(request.getParameter("email"));
        user.setMobile(request.getParameter("mobile"));
        user.setDob(Date.valueOf(request.getParameter("dob")).toLocalDate());

        HttpSession session = request.getSession();

        try {
            this.userRepository.update(user);
            session.setAttribute("status", "User updated successfully...");
        } catch (Exception e) {
            session.setAttribute("status", "User can not be updated...");
        }

        response.sendRedirect("/user/edit/" + user.getId());
    }
}
