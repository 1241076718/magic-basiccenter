package com.magic.basiccenter.model.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BsAdvertInf implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2872166807946180590L;

	
	@TableId("AI_ADV_ID")
	private Integer aiAdvId;
	
	@TableField("AI_ADV_STATUS")
	private Integer aiAdvStatus;
	
	@TableField("AI_ADV_THEME")
	private String aiAdvTheme;
	
	@TableField("AI_ADV_DESC")
	private String aiAdvDesc;
	
	@TableField("AI_ADV_COLU")
	private String aiAdvColu;
	
	@TableField("AI_ADV_COLU_ID")
	private Integer aiAdvColuId;
	
	@TableField("AI_ADV_WORD_LEFT")
	private String aiAdvWordLeft;
	
	@TableField("AI_ADV_WORD_RIGHT")
	private String aiAdvWordRight;
	
	@TableField("AI_ADV_URL")
	private String aiAdvUrl;
	
	@TableField("AI_ADV_COVER")
	private String aiAdvCover;
	
	@TableField("AI_ADV_CREATE_USER")
	private String aiAdvCreateUser;
	
	@TableField(fill=FieldFill.INSERT)
	private LocalDateTime aiAdvCreateTime;
	
	@TableField("AI_ADV_UPDATE_USER")
	private String aiAdvUpdateUser;
	
	@TableField(fill=FieldFill.INSERT_UPDATE)
	private LocalDateTime aiAdvUpdateTime;
}
