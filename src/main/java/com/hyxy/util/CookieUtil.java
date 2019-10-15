package com.hyxy.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {
	
	//定义一个cookie的键
	public static final String COOKIE_KEY = "LOGIN_COOKIE";
	
	public static String getLoginCookie(HttpServletRequest request,HttpServletResponse response,Boolean isCreate) {
		Cookie[] cookie = request.getCookies();
		for (Cookie cookie2 : cookie) {
			String name = cookie2.getName();
			if (COOKIE_KEY.equals(name)) {
				if (cookie2.getValue() != null) {
					return cookie2.getValue();
				}else {
					if (!isCreate) {
						return null;
					}
				}
			}
		}
		//自动生成UUID
		String UUID = java.util.UUID.randomUUID().toString();
		Cookie cookie3 = new Cookie(COOKIE_KEY, UUID);
		cookie3.setHttpOnly(true);
//		cookie3.setPath("/");
		response.addCookie(cookie3);
		return UUID;
	}
	
}
