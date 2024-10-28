package com.joker.mapper;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.joker.pojo.Notice;

public interface NoticeMapper {

//	添加通知信息
	public Integer addNotice(@Param("user_id")String user_id,@Param("notice_content")String notice_content,@Param("notice_time")String notice_time );
	
//	全部通知为已读
	public Integer setAllRead(@Param("user_id")String user_id);
	
//	通过用户id分页获取该用户下的所有通知
	public List<Notice> getIdAllNotice(@Param("user_id")String user_id,@Param("start")Integer start,@Param("count")Integer count);
	
//	通过用户id分页获取该用户下的所有通知数量
	public Integer getIdAllNoticeCount(@Param("user_id")String user_id);
	
//	获取是否有未读通知
	public Integer noReadNoticeCount(@Param("user_id")String user_id);
	
}
