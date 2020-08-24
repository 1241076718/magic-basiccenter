package com.magic.basiccenter.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain=true)
public class UpdateNoticeInfoOutDTO implements Serializable{


	private static final long serialVersionUID = -7679344017046727787L;


	/**
	 * 公告强制提醒开始时间
	 */
	@JsonFormat(
			pattern = "yyyy-MM-dd",
			timezone = "GMT+8"
	)
	private Date niNtcStartTime;
	/**
	 * 公告强制提醒结束时间
	 */
	@JsonFormat(
			pattern = "yyyy-MM-dd",
			timezone = "GMT+8"
	)
	private Date niNtcEndTime;
	/**
	 * 提醒次数
	 */
	private Integer niNtcCount;
	/**
	 * 提醒状态（是否提醒）（0：否 1:是）
	 */
	private Integer niNtcRemindStatus;
	/**
	 *公告名字
	 */
	private String niNtcName;
	/**

	 * 公告状态（1：已删除 2：新建 3:已发布 4：已上架 5：已下架 6：已驳回 ）
	 */

	private Integer niNtcStatus;

	/**
	 * 公告发布时间
	 */
	@JsonFormat(
			pattern = "yyyy-MM-dd",
			timezone = "GMT+8"
	)
	private Date niNtcIdReleaseTime;
	/**
	 * 公告创建者
	 */
	private String niNtcCreator;
	/**
	 * 公告具体内容
	 */
	private String niNtcText;
}
