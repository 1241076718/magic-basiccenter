package com.magic.basiccenter.model.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName(value = "bs_notice_inf")
//@Component
public class CuNoticeInf implements Serializable{

//  @TableId("niNtcId") //niNtcId
//  private Integer ni_ntc_id;
//
//  @TableField("NI_NTC_NAME")
//  private String ni_ntc_name;
//
//  @TableField("NI_NTC_STATUS")
//  private Integer ni_ntc_status;
//
//  @TableField("NI_NTC_ID_RELEASE_TIME")
//  private java.sql.Timestamp ni_ntc_id_release_time;
//
//  @TableField("NI_NTC_CREATOR")
//  private String ni_ntc_creator;
//
//  @TableField("NI_NTC_TEXT")
//  private String ni_ntc_text;
//
//  @TableField("NI_NTC_START_TIME")
//  private java.sql.Timestamp ni_ntc_start_time;
//
//  @TableField("NI_NTC_END_TIME")
//  private java.sql.Timestamp ni_ntc_end_time;
//
//  @TableField("NI_NTC_COUNT")
//  private Integer ni_ntc_count;
//
//  @TableField("NI_NTC_REMIND_STATUS")
//  private Integer ni_ntc_remind_status;
//
//  @TableField("NI_NTC_GMT_CREATE")
//  private java.sql.Timestamp ni_ntc_gmt_create;
//
//  @TableField("NI_NTC_GMT_MODIFIED")
//  private java.sql.Timestamp ni_ntc_gmt_modified;
//
//  @TableField("NI_NTC_GMT_MODIFIER")
//  private String ni_ntc_gmt_modifier;
//



  @TableId("NI_NTC_ID") //niNtcId
  private Integer niNtcId;

  @TableField("NI_NTC_NAME")
  private String niNtcName;

  @TableField("NI_NTC_STATUS")
  private Integer niNtcStatus;

  @TableField("NI_NTC_ID_RELEASE_TIME")
  private Date niNtcIdReleaseTime;

  @TableField("NI_NTC_CREATOR")
  private String niNtcCreator;

  @TableField("NI_NTC_TEXT")
  private String niNtcText;

  @TableField("NI_NTC_START_TIME")
  private String niNtcStartTime;

  @TableField("NI_NTC_END_TIME")
  private String niNtcEndTime;

  @TableField("NI_NTC_COUNT")
  private Integer niNtcCount;

  @TableField("NI_NTC_REMIND_STATUS")
  private Integer niNtcRemindStatus;

  @TableField("NI_NTC_GMT_CREATE")
  private Date niNtcGmtCreate;

  @TableField("NI_NTC_GMT_MODIFIED")
  private Date niNtcGmtModified;

  @TableField("NI_NTC_GMT_MODIFIER")
  private String niNtcGmtModifier;


}
