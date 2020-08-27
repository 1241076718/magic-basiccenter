package com.magic.basiccenter.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.magic.application.infrastructure.service.dto.SelectPageDTO;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ：goupc1@belink.com
 * @date ：Created in 2020/7/20 15:45
 * @description：告查询接受数据列表
 * @modified By：
 * @version: $
 */




@Data
public class QueryNoticeInfoDTO extends SelectPageDTO implements Serializable {


    private static final long serialVersionUID = -1095173736782363598L;

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

    private Date niNtcStartTime;
    /**
     * 公告强制提醒结束时间
     */

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

    private Date niNtcGmtCreate;
    /**
     * 修改时间
     */

    private Date niNtcGmtModified;
    /**
     * 修改人
     */
    private String niNtcGmtModifier;




}
