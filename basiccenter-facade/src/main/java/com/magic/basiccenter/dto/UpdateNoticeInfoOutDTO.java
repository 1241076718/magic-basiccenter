package com.magic.basiccenter.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain=true)
public class UpdateNoticeInfoOutDTO implements Serializable{
	private static final long serialVersionUID = 431130515358930868L;
	private String niNtcName;
	private String niNtcText;
	private Integer niNtcCount;
	private Date niNtcStartTime;
	private Date niNtcEndTime;
	private Integer niNtcRemindStatus;
}