package com.magic.basiccenter.model.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain=true)
public class Notice implements Serializable{
	private static final long serialVersionUID = 8873045944261438856L;
	//主键id
	@TableId("notice_id")
	private Integer noticeId;
	//标题 必填项
	@TableField("notice_name")
	private String noticeName;
	//公告具体内容 必填项
	@TableField("notice_text")
	private String noticeText;
	//提醒状态（0：否 1:是） 必填项
	@TableField("remind_status")
	private String remindStatus;
	//提醒次数
	@TableField("remind_count")
	private String remindCount;
	//公告强制提醒开始时间
	@TableField("remind_start_time")
	private Date remindStartTime;
	//公告强制提醒结束时间
	@TableField("remind_end_time")
	private Date remindEndTime;
}
