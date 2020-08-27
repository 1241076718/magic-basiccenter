package com.magic.basiccenter.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 节假日对应表DTO
 * @Author Lei
 */
@Data
@TableName(value="bs_festival_inf")
public class BsFestivalInf {
	/**
	 * 节假日Id
	 */
	@TableId(value="FESTIVAL_ID")
	private String festivalId;
	/**
	 * 节假日年份
	 */
	@TableField(value="FESTIVAL_YEAR",exist=true)
	private String festivalYear;
	/**
	 * 节假日名称
	 */
	@TableField(value="FESTIVAL_NAME",exist=true)
	private String festivalName;
	/**
	 * 节假日类型
	 */
	@TableField(value="FESTIVAL_TYPE",exist=true)
	private String festivalType;
	/**
	 * 节假日配置
	 */
	@TableField(value="FESTIVAL_DEPLOY",exist=true)
	private String festivalDeploy;
	/**
	 * 节假日起始时间
	 */
	@TableField(value="FESTIVAL_START_TIME",exist=true)
	private Date festivalStartTime;
	/**
	 * 节假日结束时间
	 */
	@TableField(value="FESTIVAL_END_TIME",exist=true)
	private Date festivalEndTime;
	/**
	 * 发布时间
	 */
	@TableField(value="FESTIVAL_PUT_TIME",exist=true)
	private Date festivalPutTime;
	/**
	 * 发布人
	 */
	@TableField(value="FESTIVAL_PUT_PERSON",exist=true)
	private String festivalPutPerson;
	/**
	 * 修改时间
	 */
	@TableField(value="FESTIVAL_UPDATE_TIME",exist=true)
	private Date festivalUpdateTime;
	/**
	 * 修改人
	 */
	@TableField(value="FESTIVAL_UPDATE_PERSON",exist=true)
	private String festivalUpdatePerson;
	/**
	 * 状态码
	 */
	@TableField(value="FESTIVAL_VALID",exist=true)
	private String festivalValid;
	/**
	 * 数据存在码
	 */
	@TableField(value="FESTIVAL_EXIST",exist=true)
	private String festivalExist;
}
