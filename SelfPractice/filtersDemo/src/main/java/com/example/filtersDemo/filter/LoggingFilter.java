package com.example.filtersDemo.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;
@Component
public class LoggingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse= (HttpServletResponse) response;

        System.out.println(httpServletRequest.getMethod());
        System.out.println(httpServletRequest.getRequestURI());

        long arrival= System.currentTimeMillis();

        chain.doFilter(request, response);

        int responseTime= (int) (System.currentTimeMillis() - arrival);

        System.out.println("LoggingFilter: Response time: " + responseTime + " ms");

        System.out.println("LoggingFilter: Response sent");
    }
}
