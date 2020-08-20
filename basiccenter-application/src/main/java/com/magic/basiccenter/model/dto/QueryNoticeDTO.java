package com.magic.basiccenter.model.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class QueryNoticeDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7279657644945871746L;

	private Integer niNtcId;

	private String niNtcName;

	private Integer niNtcStatus;

	private java.sql.Timestamp niNtcIdReleaseTime;

	private String niNtcCreator;

	private String niNtcText;

	private java.sql.Timestamp niNtcStartTime;

	private java.sql.Timestamp niNtcEndTime;

	private Integer niNtcCount;

	private Integer niNtcRemindStatus;

	private java.sql.Timestamp niNtcGmtCreate;

	private java.sql.Timestamp niNtcGmtModified;

	private String niNtcGmtModifier;

	private Integer nowsPage;//当前页数

	private Integer pageSize;//页面显示条数
}
