package com.magic.basiccenter.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class QueryNoticeDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7279657644945871746L;

	private Integer niNtcId;

	private String niNtcName;

	private Integer niNtcStatus;
	@JsonFormat(
			pattern = "yyyy-MM-dd",
			timezone = "GMT+8"
	)
	private Date niNtcIdReleaseTime;

	private String niNtcCreator;

	private String niNtcText;

	private String niNtcStartTime;

	private String niNtcEndTime;

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

	private java.sql.Timestamp niNtcGmtCreate;

	private java.sql.Timestamp niNtcGmtModified;

	private String niNtcGmtModifier;

	private Integer nowsPage;//当前页数

	private Integer pageSize;//页面显示条数
}

	private String niNtcGmtModifier;

	private Integer nowsPage;//当前页数

	private Integer pageSize;//页面显示条数
}
