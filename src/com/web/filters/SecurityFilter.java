package com.web.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.persistence.user.User;

@WebFilter(urlPatterns = "*.do")
public class SecurityFilter implements Filter {

	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		boolean isLoggedIn = false;
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession httpSession = req.getSession(false);
		
		if(httpSession!=null) {
			User user = (User) httpSession.getAttribute("user");
			if(user!=null) {
				isLoggedIn = true;
			}
		}
		if(isLoggedIn) {
			chain.doFilter(request, response);
		}else {
			res.sendRedirect("login.jsp?status=You must be logged in first");
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
