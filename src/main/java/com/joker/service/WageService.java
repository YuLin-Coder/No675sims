package com.joker.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joker.mapper.WageMapper;
import com.joker.pojo.Wage;

@Service
public class WageService {

	@Autowired
	WageMapper wageMapper;
	
//	通过id获取信息
	public List<Wage> getIdWage(@Param("user_id")String user_id){
		return wageMapper.getIdWage(user_id);
	}
	
//	添加信息
	public Integer addWage(Wage wage) {
		return wageMapper.addWage(wage);
	}
	
}
