package com.glodon.controller;

import java.util.HashMap;
import java.util.Map;

import javax.jws.HandlerChain;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.support.RequestContext;
import org.springframework.web.servlet.support.RequestContextUtils;

import sun.misc.Request;

import com.glodon.model.Userinfo;

@Controller
@RequestMapping("")
public class IndexController extends BaseController {

	@RequestMapping("/index")
	public String index() {
		return "index";
	}

	@RequestMapping(value = "/index/login", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> login(Userinfo userinfo, HttpSession session) {
		userinfo = this.getUserinfoManageService().login(userinfo);
		Map<String, Object> result = new HashMap<String, Object>();
		if (userinfo == null) {
			result.put("result", false);
			result.put("message", "登录失败，请检查用户名和密码！");
		} else {
			result.put("result", true);
			result.put("message", "登录成功！");
			session.setAttribute("userinfo", userinfo);
		}
		result.put("value", userinfo);
		return result;
	}

	@RequestMapping(value="/index/logout", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> logout(Userinfo userinfo, HttpSession session) {
		boolean isOk = this.getUserinfoManageService().logout(userinfo);
		Map<String, Object> result = new HashMap<String, Object>();
		if (isOk) {
			result.put("result", true);
			result.put("message", "");
			session.invalidate();
		} else {
			result.put("result", false);
			result.put("message", "注销失败！");
		}
		result.put("value", null);
		return result;
	}

}
