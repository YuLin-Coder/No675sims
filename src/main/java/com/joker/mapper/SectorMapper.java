package com.joker.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.joker.pojo.Sector;

public interface SectorMapper {

//	获取全部信息
	public List<Sector> getAllSector();
	
//	添加信息
	public Integer addSector(@Param("sector_name")String sector_name);
	
//	删除信息
	public Integer deleteSector(@Param("sector_name")String sector_name);
	
}
