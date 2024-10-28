package com.joker.controller;



import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.joker.pojo.Wage;
import com.joker.service.WageService;

@Controller
@RequestMapping("")
public class WageController {

	@Autowired
	WageService wageService;
	
//	通过id获取信息
	@RequestMapping("/getIdWage")
	@ResponseBody
	public List<Wage> getIdWage(String user_id){
		return wageService.getIdWage(user_id);
	}
	
//	获取当前登录账户信息
	@RequestMapping("/getIdWageNow")
	@ResponseBody
	public List<Wage> getIdWageNow(HttpServletRequest httpServletRequest){
		return wageService.getIdWage(httpServletRequest.getSession().getAttribute("USER_TOKEN").toString().split("---")[0]);
	}
	
//	添加信息
	@RequestMapping("/addWage")
	@ResponseBody
	public Integer addWage(Wage wage) {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String wage_time = sf.format(new Date());
		wage.setWage_time(wage_time);
		return wageService.addWage(wage);
	}
	
	
}
