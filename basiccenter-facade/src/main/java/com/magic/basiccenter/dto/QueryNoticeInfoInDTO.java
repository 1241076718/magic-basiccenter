package com.magic.basiccenter.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 公告查询列表
 * 返回数据
 * @author ：wzr
 * @date ：Created in 2020/7/20 15:45
 * @description：查询账户信息
 * @modified By：
 * @version: $
 */


@Data
public class QueryNoticeInfoInDTO implements Serializable {

    private Integer niNtcId;

    private String niNtcName;

    private Integer niNtcStatus;

    private Date niNtcIdReleaseTime;

    private String niNtcCreator;

    private String niNtcText;

    private String niNtcStartTime;

    private String niNtcEndTime;

    private Integer niNtcCount;

    private Integer niNtcRemindStatus;

    private Date niNtcGmtCreate;

    private Date niNtcGmtModified;

    private String niNtcGmtModifier;

    private Integer nowsPage;//当前页数

    private Integer pageSize;//页面显示条数


}
