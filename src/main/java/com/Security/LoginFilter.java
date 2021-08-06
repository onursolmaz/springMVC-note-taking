package com.Security;


import com.Controllers.HomeController;
import com.Entities.User;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Scope("session")
public class LoginFilter implements Filter {

    public static User loggedInUser=null;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest reg= (HttpServletRequest) request;
        HttpServletResponse res= (HttpServletResponse) response;
        boolean isStaticResource = reg.getRequestURI().startsWith("/asset/") || reg.getRequestURI().startsWith("/Custom/");

        if(reg.getRequestURI().contains("login") || isStaticResource ){
            chain.doFilter(request,response);
            return;
        }
        if(reg.getRequestURI().contains("register") || isStaticResource ){
            chain.doFilter(request,response);
            return;
        }
        if(reg.getRequestURI().contains("reg") || isStaticResource ){
            chain.doFilter(request,response);
            return;
        }

        User user= (User) reg.getSession().getAttribute("user");
        loggedInUser=user;
        if(user!=null){
            chain.doFilter(request,response);
            return;
        }else{
            res.sendRedirect(HomeController.url +"/login");
        }
        chain.doFilter(request,response);





    }

    @Override
    public void destroy() {

    }


}
