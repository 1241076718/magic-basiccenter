package com.magic.basiccenter.dto;

import com.magic.application.infrastructure.service.dto.SelectPageDTO;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 公告查询列表
 * 传入的数据
 * @author ：wzr
 * @date ：Created in 2020/7/20 15:45
 * @description：查询账户信息
 * @modified By：
 * @version: $
 */


@Data
public class QueryNoticeInfoInDTO  extends SelectPageDTO implements Serializable {


    private static final long serialVersionUID = -1095173736782363598L;

    private String niNtcId;

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
