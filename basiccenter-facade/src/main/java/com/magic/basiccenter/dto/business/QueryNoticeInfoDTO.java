package com.magic.basiccenter.dto.business;

import lombok.Data;

import java.io.Serializable;

/**
 * @author ：wzr
 * @date ：Created in 2020/7/20 15:45
 * @description：查询账户信息
 * @modified By：
 * @version: $
 */


@Data
public class QueryNoticeInfoDTO implements Serializable {

    private Integer notice_id;
    private String notice_name;
    private Integer notice_status;
    private java.sql.Timestamp notice_release_time;
    private String notice_creater;
    private String notice_text;
    private java.sql.Timestamp remind_start_time;
    private java.sql.Timestamp remind_end_time;
    private Integer remind_count;
    private Integer remind_status;
}
