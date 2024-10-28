package com.joker.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.joker.pojo.Sector;
import com.joker.service.SectorService;

@Controller
@RequestMapping("")
public class SectorController {

	@Autowired
	SectorService sectorService;
	
//	获取全部信息
	@RequestMapping("/getAllSector")
	@ResponseBody
	public List<Sector> getAllSector(){
		return sectorService.getAllSector();
	}
	
//	添加信息
	@RequestMapping("/addSector")
	@ResponseBody
	public Integer addSector(String sector_name) {
		return sectorService.addSector(sector_name);
	}
	
//	删除信息
	@RequestMapping("/deleteSector")
	@ResponseBody
	public Integer deleteSector(String sector_name) {
		return sectorService.deleteSector(sector_name);
	}
	
}
