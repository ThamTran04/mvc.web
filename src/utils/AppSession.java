package utils;



import java.sql.SQLException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.User;
import bo.LoginVerification;

public class AppSession {


	public static void storeLoginedUser(HttpSession session, User loginedUser) {
		session.setAttribute("loginUser", loginedUser);
	}


	public static User getLoginedUser(HttpSession session) {
		User loginedUser = (User) session.getAttribute("loginUser");
		return loginedUser;
	}
	
	public static void setCookieUser(HttpServletResponse response, String username, String pwd) {
		Cookie userCookie = new Cookie("username", username);
		Cookie passwordCookie = new Cookie("pwd", pwd);
		// how many seconds a given cookie should be valid for:
		userCookie.setMaxAge(60 * 60 * 24); // one day
		passwordCookie.setMaxAge(60 * 60 * 24); // one day
		response.addCookie(userCookie);
		response.addCookie(passwordCookie);
	}
	
	public static  void removeCookies(HttpServletRequest req, HttpServletResponse resp) {
	    Cookie[] cookies = req.getCookies();
	    if (cookies != null)
	        for (Cookie cookie : cookies) {	        	
	            cookie.setValue("");
	            cookie.setPath("/");
	            cookie.setMaxAge(0);
	            resp.addCookie(cookie);
	        }
	}
	
	public static boolean needLogin(HttpServletRequest resquest) {
		User user = getCookieUser(resquest);
		if(user == null)
			return true;
		
		try {
			return !LoginVerification.checkUser(user);
		} catch (SQLException e) {			
			e.printStackTrace();
		}		
		return true;
	}
	
	public static User getCookieUser(HttpServletRequest resquest) {
		Cookie[] cookies = resquest.getCookies();
		if(cookies == null)
			return null;
		
		 Cookie nameCookie = getCookieByName(cookies, "username");
		 if(nameCookie == null)
			 return null;
		 Cookie pwdCookie = getCookieByName(cookies, "pwd");
		 if(pwdCookie == null)
			 return null;
		 return new User(nameCookie.getValue(), pwdCookie.getValue());
	}
	
	private static Cookie getCookieByName(Cookie[] cookies, String name) {
		for (Cookie cookie : cookies) {
			if(name.equals(cookie.getName())) {
				return cookie;
			}
		}
		
		return null;
	}

}
