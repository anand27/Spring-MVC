package com.xebia.myapp.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class UserAuthenticationInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("-----------  COMPLETION OF HANDLE -------------");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("-----------  AFTER HANDLE -------------");
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2) throws Exception {
		if (request.getSession().getAttribute("user") != null) {
			System.out.println("-------------- USER FOUND ------------");
            return true;
        } else {
        	System.out.println("-------------- ILLEGAL ACCESS ------------");
            response.sendRedirect(request.getContextPath() + "/index.jsp");
            return false;
        }
	}

}
