package com.joker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joker.mapper.UserMapper;
import com.joker.pojo.User;

@Service
public class UserService {

	@Autowired
	UserMapper userMapper;
	
//	登录用户
	public Integer login(String user_id,String user_password) {
		return userMapper.login(user_id, user_password);
	}

//	添加用户
	public Integer addUser(User user) {
		return userMapper.addUser(user);
	}

//	删除用户
	public Integer deleteUser(String user_id) {
		return userMapper.deleteUser(user_id);
	}

//	更新用户信息
	public Integer updateUser(User user) {
		return userMapper.updateUser(user);
	}

//	分页查询所有用户信息
	public List<User> getAllUser(Integer start,Integer count) {
		return userMapper.getAllUser(start, count);
	}
	
//	分页查询所有用户信息个数
	public Integer getAllListCount() {
		return userMapper.getAllUserCount();
	}

//	通过id得到用户信息
	public List<User> getIdUser(String user_id) {
		return userMapper.getIdUser(user_id);
	}
	

//	模糊搜索用户信息
	public List<User> getSearchUser(String search,Integer start,Integer count) {
		return userMapper.getSearchUser(search,start,count);
	}

//	模糊搜索用户信息数量
	public Integer getSearchUserCount(String search) {
		return userMapper.getSearchUserCount(search);
	}
	
}
