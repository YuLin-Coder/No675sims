package com.joker.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.joker.pojo.Notice;
import com.joker.service.NoticeService;

@Controller
@RequestMapping("")
public class NoticeController {

	@Autowired
	NoticeService noticeService;

//	添加通知信息
	@RequestMapping("/addNotice")
	@ResponseBody
	public Integer addNotice(String user_id,String notice_content) {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String notice_time = sf.format(new Date());
		return noticeService.addNotice(user_id, notice_content, notice_time);
	}
	
//	全部通知为已读
	@RequestMapping("/setAllRead")
	@ResponseBody
	public Integer setAllRead(HttpServletRequest httpServletRequest) {
		HttpSession session = httpServletRequest.getSession();
		return noticeService.setAllRead(session.getAttribute("USER_TOKEN").toString().split("---")[0]);
	}

//	通过用户id分页获取该用户下的所有通知
	@RequestMapping("/getIdAllNotice")
	@ResponseBody
	public List<Notice> getIdAllNotice(HttpServletRequest httpServletRequest,Integer start,Integer count) {
		return noticeService.getIdAllNotice(httpServletRequest.getSession().getAttribute("USER_TOKEN").toString().split("---")[0], start, count);
	}
	
//	通过用户id分页获取该用户下的所有通知数量
	@RequestMapping("/getIdAllNoticeCount")
	@ResponseBody
	public Integer getIdAllNoticeCount(HttpServletRequest httpServletRequest) {
		return noticeService.getIdAllNoticeCount(httpServletRequest.getSession().getAttribute("USER_TOKEN").toString().split("---")[0]);
	}
	
//	获取是否有未读通知
	@RequestMapping("/noReadNoticeCount")
	@ResponseBody
	public Integer noReadNoticeCount(HttpServletRequest httpServletRequest) {
		return noticeService.noReadNoticeCount(httpServletRequest.getSession().getAttribute("USER_TOKEN").toString().split("---")[0]);
	}
	
	
}
