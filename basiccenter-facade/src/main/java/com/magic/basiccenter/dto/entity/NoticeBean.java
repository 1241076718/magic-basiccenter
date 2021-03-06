package com.magic.basiccenter.dto.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: goupc1@belink.com
 * @date: 2020/08/25 17:10
 * @description:
 * @modifined By:
 * @version: 1.0.0
 */


@Data
public class NoticeBean implements Serializable {

    private static final long serialVersionUID = -2577777207720933437L;

    /**
     *公告id
     */
    private String niNtcId;
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
            pattern = "yyyy-MM-dd HH:mm:ss"
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
    /**
     * 公告强制提醒开始时间
     */
    @JsonFormat(
            pattern = "yyyy-MM-dd"

    )
    private Date niNtcStartTime;
    /**
     * 公告强制提醒结束时间
     */
    @JsonFormat(
            pattern = "yyyy-MM-dd"

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
     * 创建时间
     */
    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss",
            timezone = "GMT+8"
    )
    private Date niNtcGmtCreate;
    /**
     * 修改时间
     */
    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss",
            timezone = "GMT+8"
    )
    private Date niNtcGmtModified;
    /**
     * 修改人
     */
    private String niNtcGmtModifier;



}
