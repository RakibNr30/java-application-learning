package org.dsi.controller.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.dsi.entity.User;
import org.dsi.repository.UserRepositoryImpl;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class UserListServlet extends HttpServlet {

    private UserRepositoryImpl userRepository;

    private static AtomicInteger visitCounter = new AtomicInteger(0);

    @Override
    public void init() throws ServletException {
        userRepository = new UserRepositoryImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        synchronized (this) {
            getServletContext().setAttribute("siteVisitCounter", Integer.parseInt(getServletContext().getAttribute("siteVisitCounter").toString()) + 1);
        }

        int incrementedValueForCurrentThread = visitCounter.incrementAndGet();

        System.out.println("incrementedValueForCurrentThread = " + incrementedValueForCurrentThread);

        request.setAttribute("visitCounter", visitCounter);

        List<User> users = userRepository.getAll();

        request.setAttribute("users", users);

        request.getRequestDispatcher("/views/front/user/userList.jsp").forward(request, response);
    }
}
