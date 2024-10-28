package com.joker.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.joker.pojo.User;

public interface UserMapper {
	
//	登录用户
	public Integer login(@Param("user_id")String user_id,@Param("user_password")String user_password);
	
//	添加用户
	public Integer addUser(User user);
	
//	删除用户
	public Integer deleteUser(@Param("user_id")String user_id);
	
//	更新用户信息
	public Integer updateUser(User user);
	
//	分页查询所有用户信息
	public List<User> getAllUser(@Param("start")Integer start,@Param("count")Integer count);
	
//	分页查询所有用户信息个数
	public Integer getAllUserCount();
	
//	通过id得到用户信息
	public List<User> getIdUser(@Param("user_id")String user_id);

//	模糊搜索用户信息
	public List<User> getSearchUser(@Param("search")String search,@Param("start")Integer start,@Param("count")Integer count);
	
//	模糊搜索用户信息数量
	public Integer getSearchUserCount(@Param("search")String search);
	
}
