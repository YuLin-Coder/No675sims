package com.joker.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.joker.pojo.User;
import com.joker.service.UserService;

@Controller
@RequestMapping("")
public class UserController {

	@Autowired
	UserService userService;

//	登录用户
	@RequestMapping("/loginUser")
	@ResponseBody
	public Integer loginUser(HttpServletRequest httpServletRequest,String user_id,String user_password) {
		HttpSession session = httpServletRequest.getSession();
		if(userService.login(user_id, user_password) > 0) {
			session.setAttribute("USER_TOKEN", user_id+"---"+user_password);
			return 1;
		}else {
			return 0;
		}
	}
	
//	判断是否登录用户
	@RequestMapping("/isLoginUser")
	@ResponseBody
	public Integer isLoginAdmin(HttpServletRequest httpServletRequest) {
		HttpSession session = httpServletRequest.getSession();
		if(session.getAttribute("USER_TOKEN") == null) {
			return 0;
		}else {
			return 1;
		}
	}
	
//	退出用户登录
	@RequestMapping("/quitLoginUser")
	@ResponseBody
	public Integer quitLoginAdmin(HttpServletRequest httpServletRequest) {
		HttpSession session = httpServletRequest.getSession();
		session.removeAttribute("USER_TOKEN");
		return 1;
	}

//	添加用户
	@RequestMapping("/addUser")
	@ResponseBody
	public Integer addUser(User user) {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = sf.format(new Date());
		user.setUser_time(time);
		return userService.addUser(user);
	}

//	删除用户
	@RequestMapping("/deleteUser")
	@ResponseBody
	public Integer deleteUser(String user_id) {
		return userService.deleteUser(user_id);
	}

//	更新用户信息
	@RequestMapping("/updateUser")
	@ResponseBody
	public Integer updateUser(User user) {
		return userService.updateUser(user);
	}
	
//	分页查询所有用户信息
	@RequestMapping("/getAllUser")
	@ResponseBody
	public List<User> getAllUser(Integer start,Integer count) {
		return userService.getAllUser(start, count);
	}
	
//	分页查询所有用户信息个数
	@RequestMapping("/getAllUserCount")
	@ResponseBody
	public Integer getAllUserCount() {
		return userService.getAllListCount();
	}

//	通过id得到用户信息
	@RequestMapping("/getIdUser")
	@ResponseBody
	public List<User> getIdUser(String user_id) {
		return userService.getIdUser(user_id);
	}
	
//	获取当前登录用户信息
	@RequestMapping("/getIdUserNow")
	@ResponseBody
	public List<User> getIdUserNow(HttpServletRequest httpServletRequest) {
		return userService.getIdUser(httpServletRequest.getSession().getAttribute("USER_TOKEN").toString().split("---")[0]);
	}

	
//	模糊搜索用户信息
	@RequestMapping("/getSearchUser")
	@ResponseBody
	public List<User> getSearchUser(String search,Integer start,Integer count) {
		return userService.getSearchUser(search,start,count);
	}
	
//	模糊搜索用户信息数量
	@RequestMapping("/getSearchUserCount")
	@ResponseBody
	public Integer getSearchUserCount(String search) {
		return userService.getSearchUserCount(search);
	}
	
//	更改用户密码
	@RequestMapping("/updateUserPassword")
	@ResponseBody
	public Integer updateUserPassword(HttpServletRequest httpServletRequest,String oldPassword,String newPassword) {
		HttpSession session = httpServletRequest.getSession();
		if(oldPassword.equals(session.getAttribute("USER_TOKEN").toString().split("---")[1])) {
			User user = getIdUser(session.getAttribute("USER_TOKEN").toString().split("---")[0]).get(0);
			user.setUser_password(newPassword);
			return updateUser(user);
		}else {
			return 0;
		}
	}
	
//	用户更改个人信息
	@RequestMapping("/updateUserPart")
	@ResponseBody
	public Integer updateUserPart(HttpServletRequest httpServletRequest,String phone,String sex) {
		HttpSession session = httpServletRequest.getSession();
		User user = getIdUser(session.getAttribute("USER_TOKEN").toString().split("---")[0]).get(0);
		user.setUser_phone(phone);
		user.setUser_sex(sex);
		return updateUser(user);
	}
	
}
