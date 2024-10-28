package com.joker.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.joker.service.AdminService;

@Controller
@RequestMapping("")
public class AdminController {

	@Autowired
	AdminService adminService;
	
//	登录管理员
	@RequestMapping("/loginAdmin")
	@ResponseBody
	public Integer loginAdmin(HttpServletRequest httpServletRequest,String admin_name,String admin_password) {
		HttpSession session = httpServletRequest.getSession();
		if(adminService.loginAdmin(admin_name, admin_password) > 0) {
			session.setAttribute("ADMIN_TOKEN", admin_name+"---"+admin_password);
			return 1;
		}else {
			return 0;
		}
	}
	
//	判断是否登录管理员
	@RequestMapping("/isLoginAdmin")
	@ResponseBody
	public Integer isLoginAdmin(HttpServletRequest httpServletRequest) {
		HttpSession session = httpServletRequest.getSession();
		if(session.getAttribute("ADMIN_TOKEN") == null) {
			return 0;
		}else {
			return 1;
		}
	}
	
//	退出管理员登录
	@RequestMapping("/quitLoginAdmin")
	@ResponseBody
	public Integer quitLoginAdmin(HttpServletRequest httpServletRequest) {
		HttpSession session = httpServletRequest.getSession();
		session.removeAttribute("ADMIN_TOKEN");
		return 1;
	}
	
//	更改管理员密码
	@RequestMapping("/updateAdminPassword")
	@ResponseBody
	public Integer updateAdminPassword(HttpServletRequest httpServletRequest,String oldPassword,String newPassword) {
		HttpSession session = httpServletRequest.getSession();
		if(oldPassword.equals(session.getAttribute("ADMIN_TOKEN").toString().split("---")[1])) {
			return adminService.updateAdminPassword(session.getAttribute("ADMIN_TOKEN").toString().split("---")[0], newPassword);
		}else {
			return 0;
		}	
	}
	
//	得到当前登录管理员的用户名
	@RequestMapping("/getAdminName")
	@ResponseBody
	public String getAdminName(HttpServletRequest httpServletRequest) {
		HttpSession session = httpServletRequest.getSession();
		return session.getAttribute("ADMIN_TOKEN").toString().split("---")[0];
	}
	
}
