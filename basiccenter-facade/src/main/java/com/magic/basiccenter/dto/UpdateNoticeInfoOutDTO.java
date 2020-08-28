package com.magic.basiccenter.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;


/**

 * @author ：liubing1@belink.com
 * @date ：
 * @description* 公告修改返回数据
 * @modified By：
 * @version: $
 */

@Data
@Accessors(chain=true)
public class UpdateNoticeInfoOutDTO implements Serializable{
	private static final long serialVersionUID = -7679344017046727787L;
	/**
	 *公告名字
	 */
	private String niNtcName;
	/**
	 * 公告具体内容
	 */
	private String niNtcText;
	/**
	 * 提醒状态（是否提醒）（0：否 1:是）
	 */
	private Integer niNtcRemindStatus;
	/**
	 * 提醒次数
	 */
	private Integer niNtcCount;
	/**
	 * 公告强制提醒开始时间
	 */
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date niNtcStartTime;
	/**
	 * 公告强制提醒结束时间
	 */
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date niNtcEndTime;
}
