package com.joker.mapper;

import org.apache.ibatis.annotations.Param;

public interface AdminMapper {

//	登录管理员
	public Integer loginAdmin(@Param("admin_name")String admin_name,@Param("admin_password")String admin_password);
	
//	更改管理员密码
	public Integer updateAdminPassword(@Param("admin_name")String admin_name,@Param("admin_password")String admin_password);
}
