package com.magic.basiccenter.model.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName(value = "bs_notice_inf")
public class BsNoticeInf implements Serializable{


	/**
	 * 公告id
	 */
	@TableId("NI_NTC_ID")
	private String niNtcId;
	/**
	 * 公告名称
	 */
	@TableField("NI_NTC_NAME")
	private String niNtcName;
	/**
	 * 公告状态（1：已删除 2：新建 3:已发布 4：已上架 5：已下架 6：已驳回 ）
	 */
	@TableField("NI_NTC_STATUS")
	private Integer niNtcStatus;
	/**
	 * 公告发布时间
	 */
	@TableField("NI_NTC_ID_RELEASE_TIME")
	private Date niNtcIdReleaseTime;
	/**
	 * 公告创建者
	 */
	@TableField("NI_NTC_CREATOR")
	private String niNtcCreator;
	/**
	 * 公告具体内容
	 */
	@TableField("NI_NTC_TEXT")
	private String niNtcText;
	/**
	 * 公告强制提醒开始时间	
	 */
	@TableField("NI_NTC_START_TIME")
	private Date niNtcStartTime;
	/**
	 * 公告强制提醒结束时间
	 */
	@TableField("NI_NTC_END_TIME")
	private Date niNtcEndTime;
	/**
	 * 提醒次数
	 */
	@TableField("NI_NTC_COUNT")
	private Integer niNtcCount;
	/**
	 * 提醒状态（0：否 1:是）
	 */
	@TableField("NI_NTC_REMIND_STATUS")
	private Integer niNtcRemindStatus;
	/**
	 * 创建时间
	 */
	@TableField("NI_NTC_GMT_CREATE")
	private Date niNtcGmtCreate;
	/**
	 * 修改时间
	 */
	@TableField("NI_NTC_GMT_MODIFIED")
	private Date niNtcGmtModified;
	/**
	 * 修改人	
	 */
	@TableField("NI_NTC_GMT_MODIFIER")
	private String niNtcGmtModifier;


}
