package com.controller.home;

import com.entity.User;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class HomeServlet extends HttpServlet {
    private static int visitCounter;
    @Override
    public void init() throws ServletException {
        visitCounter = 0;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.updateVisitCounter();

        ServletConfig servletConfig = getServletConfig();
        String servletName = servletConfig.getInitParameter("servletName");
        int servletIndex = Integer.parseInt(servletConfig.getInitParameter("servletIndex"));
        System.out.println(servletName + " - " + servletIndex);

        User user1 = new User(1, "Abdur Rakib", "abdur.rakib@dsinnovators.com", "01710115566");
        User user2 = new User(2, "Mr. Kamal", "kamal@example.com", "01XXXXXXXX0");
        User user3 = new User(3, "Mr. Jamal", "jamal@example.com", "01XXXXXXXX1");

        List<User> users = List.of(user1, user2, user3);

        request.setAttribute("servletName", servletName);
        request.setAttribute("visitCounter", visitCounter);
        request.setAttribute("users", users);

        request.getRequestDispatcher("views/home.jsp").forward(request, response);
    }

    private void updateVisitCounter() {
        visitCounter++;
    }

    @Override
    public void destroy() {}
}
