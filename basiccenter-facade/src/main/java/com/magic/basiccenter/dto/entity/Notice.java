package com.magic.basiccenter.dto.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Notice implements Serializable{


  private Long notice_id;
  private String notice_name;
  private Long notice_status;
  private java.sql.Timestamp notice_release_time;
  private String notice_creater;
  private String notice_text;
  private java.sql.Timestamp remind_start_time;
  private java.sql.Timestamp remind_end_time;
  private Long remind_count;
  private Long remind_status;


}
