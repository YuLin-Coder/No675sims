package com.joker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joker.mapper.AdminMapper;

@Service
public class AdminService {

	@Autowired
	AdminMapper adminMapper;
	
//	登录管理员
	public Integer loginAdmin(String admin_name,String admin_password) {
		return adminMapper.loginAdmin(admin_name, admin_password);
	}
	
//	更改管理员密码
	public Integer updateAdminPassword(String admin_name,String admin_password) {
		return adminMapper.updateAdminPassword(admin_name, admin_password);
	}
	
}
