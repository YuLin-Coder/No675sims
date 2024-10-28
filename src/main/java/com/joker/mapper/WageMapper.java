package com.joker.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.joker.pojo.Wage;

public interface WageMapper {

//	通过id获取信息
	public List<Wage> getIdWage(@Param("user_id")String user_id);
	
//	添加信息
	public Integer addWage(Wage wage);
	
}
