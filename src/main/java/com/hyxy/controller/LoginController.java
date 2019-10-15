package com.hyxy.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hyxy.util.CookieUtil;
import com.hyxy.util.RedisStore;

@RestController
@RequestMapping("LoginController")
public class LoginController {

	public static final String USER_KEY="user_key";
	
	@Autowired
	RedisStore redisStore;
	
	@RequestMapping("getLogin")
	public void getLogin(String username,String password,HttpServletRequest request,HttpServletResponse response) {
		System.out.println(username);
		System.out.println(password);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("username", username);
		map.put("password", password);
		String coString = CookieUtil.getLoginCookie(request, response, true);
		System.out.println(coString);
		redisStore.set(coString, map);
	}
	
	@RequestMapping("getUser")
	public void getUser(HttpServletRequest request,HttpServletResponse response) {
		
		Object user = request.getSession().getAttribute(USER_KEY);
		Object object = redisStore.get(CookieUtil.getLoginCookie(request, response, false));
		System.out.println(object);
	}
}
