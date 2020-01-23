package filter;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import bo.LoginVerification;
import utils.AppSession;

public class LoginFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;

		User user = AppSession.getLoginedUser(req.getSession());
		try {
			if (!LoginVerification.checkAdminUser(user) && req.getRequestURI().endsWith("admin")
					&& !req.getRequestURI().endsWith("login")) {
				resp.sendRedirect("login?adminerror=1");
				return;
			} else if (!LoginVerification.checkUser(user) && req.getRequestURI().endsWith("vehicule")
					&& !req.getRequestURI().endsWith("login")) {
				resp.sendRedirect("login");
				return;
			}
			else {
				chain.doFilter(request, response);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}
	
	@Override
	public void destroy() {
		
	}

}
