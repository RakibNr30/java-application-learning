package com.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(urlPatterns = "/add-contact")
public class EmailFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;

        String email = request.getParameter("email");

        if (email.endsWith(".com")) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            PrintWriter out = servletResponse.getWriter();
            out.println("Invalid Email! .Email top level domain must be .com");
        }
    }

    @Override
    public void destroy() {}
}
