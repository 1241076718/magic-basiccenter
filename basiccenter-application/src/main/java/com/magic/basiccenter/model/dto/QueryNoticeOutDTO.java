package com.magic.basiccenter.model.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain=true)
public class QueryNoticeOutDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5253003295671746450L;

	private String niNtcId;

	private String niNtcName;

	private Integer niNtcStatus;
	@JsonFormat(
			pattern = "yyyy-MM-dd",
			timezone = "GMT+8"
	)
	private Date niNtcIdReleaseTime;

	private String niNtcCreator;

	private String niNtcText;
	@JsonFormat(
			pattern = "yyyy-MM-dd",
			timezone = "GMT+8"
	)
	private Date niNtcStartTime;
	@JsonFormat(
			pattern = "yyyy-MM-dd",
			timezone = "GMT+8"
	)
	private Date niNtcEndTime;

	private Integer niNtcCount;

	private Integer niNtcRemindStatus;
	@JsonFormat(
			pattern = "yyyy-MM-dd",
			timezone = "GMT+8"
	)
	private Date niNtcGmtCreate;
	@JsonFormat(
			pattern = "yyyy-MM-dd",
			timezone = "GMT+8"
	)
	private Date niNtcGmtModified;

	private String niNtcGmtModifier;

//	private Integer nowsPage;//当前页数
//
//	private Integer pageSize;//页面显示条数
	
}
