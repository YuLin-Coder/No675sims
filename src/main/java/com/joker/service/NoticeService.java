package com.joker.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.joker.mapper.NoticeMapper;
import com.joker.pojo.Notice;

@Service
public class NoticeService {

	@Autowired
	NoticeMapper noticeMapper;
	
//	添加通知信息
	public Integer addNotice(String user_id,String notice_content,String notice_time) {
		return noticeMapper.addNotice(user_id, notice_content, notice_time);
	}

	
//	全部通知为已读
	public Integer setAllRead(String user_id) {
		return noticeMapper.setAllRead(user_id);
	}
	

//	通过用户id分页获取该用户下的所有通知
	public List<Notice> getIdAllNotice(String user_id,Integer start,Integer count) {
		return noticeMapper.getIdAllNotice(user_id, start, count);
	}
	
//	通过用户id分页获取该用户下的所有通知数量
	public Integer getIdAllNoticeCount(String user_id) {
		return noticeMapper.getIdAllNoticeCount(user_id);
	}
	
//	获取是否有未读通知
	@RequestMapping("/noReadNoticeCount")
	@ResponseBody
	public Integer noReadNoticeCount(String user_id) {
		return noticeMapper.noReadNoticeCount(user_id);
	}
	
}
