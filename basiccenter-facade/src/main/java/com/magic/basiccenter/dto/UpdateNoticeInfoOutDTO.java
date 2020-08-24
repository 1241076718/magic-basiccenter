package com.magic.basiccenter.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 
 * @author lb
 * @date ：Created in 2020/08/24 12:34
 * @description：查询账户信息
 * @modified By：
 * @version: $
 */
@Data
@Accessors(chain=true)
public class UpdateNoticeInfoOutDTO implements Serializable{
	private static final long serialVersionUID = -7679344017046727787L;
	/**
	 * 公告状态（1：已删除 2：新建 3:已发布 4：已上架 5：已下架 6：已驳回 ）
	 */
	private String niNtcName;
	/**
	 * 公告具体内容
	 */
	private String niNtcText;
	/**
	 * 提醒次数
	 */
	private Integer niNtcCount;
	/**
	 * 公告强制提醒开始时间
	 */
	private Date niNtcStartTime;
	/**
	 * 公告强制提醒结束时间
	 */
	private Date niNtcEndTime;
	/**
	 * 提醒状态（是否提醒）（0：否 1:是）
	 */
	private Integer niNtcRemindStatus;
}
