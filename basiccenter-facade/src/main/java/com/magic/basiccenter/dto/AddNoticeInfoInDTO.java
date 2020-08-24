package com.magic.basiccenter.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 *公告新增信息传入DTO
 */
@Data
public class AddNoticeInfoInDTO implements Serializable {
    private static final long serialVersionUID = -7046586321043892538L;


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
