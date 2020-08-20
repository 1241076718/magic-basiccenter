package com.magic.basiccenter.model.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName(value = "bs_notice_inf")
public class CuNoticeInf implements Serializable{

  @TableId("NI_NTC_ID") //niNtcId
  private Integer niNtcId;

  @TableField("NI_NTC_NAME")
  private String niNtcName;

  @TableField("NI_NTC_STATUS")
  private Integer niNtcStatus;

  @TableField("NI_NTC_ID_RELEASE_TIME")
  private java.sql.Timestamp niNtcIdReleaseTime;

  @TableField("NI_NTC_CREATOR")
  private String niNtcCreator;

  @TableField("NI_NTC_TEXT")
  private String niNtcText;

  @TableField("NI_NTC_START_TIME")
  private java.sql.Timestamp niNtcStartTime;

  @TableField("NI_NTC_END_TIME")
  private java.sql.Timestamp niNtcEndTime;

  @TableField("NI_NTC_COUNT")
  private Integer niNtcCount;

  @TableField("NI_NTC_REMIND_STATUS")
  private Integer niNtcRemindStatus;

  @TableField("NI_NTC_GMT_CREATE")
  private java.sql.Timestamp niNtcGmtCreate;

  @TableField("NI_NTC_GMT_MODIFIED")
  private java.sql.Timestamp niNtcGmtModified;

  @TableField("NI_NTC_GMT_MODIFIER")
  private String niNtcGmtModifier;


}
