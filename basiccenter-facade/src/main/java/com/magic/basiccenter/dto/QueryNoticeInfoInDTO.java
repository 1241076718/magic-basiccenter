package com.magic.basiccenter.dto;

import lombok.Data;

import java.io.Serializable;

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

    private Integer ni_ntc_id;

    private String ni_ntc_name;

    private Integer ni_ntc_status;

    private java.sql.Timestamp ni_ntc_id_release_time;

    private String ni_ntc_creator;

    private String ni_ntc_text;

    private java.sql.Timestamp ni_ntc_start_time;

    private java.sql.Timestamp ni_ntc_end_time;

    private Integer ni_ntc_count;

    private Integer ni_ntc_remind_status;

    private java.sql.Timestamp ni_ntc_gmt_create;

    private java.sql.Timestamp ni_ntc_gmt_modified;

    private String ni_ntc_gmt_modifier;


}
