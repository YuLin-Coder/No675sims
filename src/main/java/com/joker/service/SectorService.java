package com.joker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joker.mapper.SectorMapper;
import com.joker.pojo.Sector;

@Service
public class SectorService {

	@Autowired
	SectorMapper sectorMapper;

//	获取全部信息
	public List<Sector> getAllSector(){
		return sectorMapper.getAllSector();
	}
	
//	添加信息
	public Integer addSector(String sector_name) {
		return sectorMapper.addSector(sector_name);
	}
	
//	删除信息
	public Integer deleteSector(String sector_name) {
		return sectorMapper.deleteSector(sector_name);
	}
	
}
