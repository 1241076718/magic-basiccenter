package com.magic.basiccenter.model.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain=true)
public class UpdateNoticeOutDTO implements Serializable{
	private static final long serialVersionUID = 7327707915195430142L;
	//标题 必填项
	private String noticeName;
	//公告具体内容 必填项
	private String noticeText;
	//提醒状态（0：否 1:是） 必填项
	private String remindStatus;
	//提醒次数
	private String remindCount;
	//公告强制提醒开始时间
	private Date remindStartTime;
	//公告强制提醒结束时间
	private Date remindEndTime;

}
