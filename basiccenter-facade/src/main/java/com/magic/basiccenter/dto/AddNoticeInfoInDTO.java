package com.magic.basiccenter.dto;

import lombok.Data;

import java.util.Date;

@Data
public class AddNoticeInfoInDTO {

   // private Integer niNtcId;

    private String niNtcName;

    private Integer niNtcStatus;

    private Date niNtcIdReleaseTime;

    private String niNtcCreator;

    private String niNtcText;

    private Date niNtcStartTime;

    private Date niNtcEndTime;

    private Integer niNtcCount;

    private Integer niNtcRemindStatus;

    private Date niNtcGmtCreate;

    private Date niNtcGmtModified;

    private String niNtcGmtModifier;
}
