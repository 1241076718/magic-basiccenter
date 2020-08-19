package com.magic.basiccenter.dto;

import java.io.Serializable;

import lombok.Data;
/**
 * 节假日修改输入类
 * @author LEI
 *
 */
@Data
public class FestivalModifyDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 节假日id
	 */
	private Integer festivalId;
	/**
	 * 节假日名称
	 */
	private String festivalName;
	/**
	 * 节假日类型
	 */
	private String festivalType;
	/**
	 * 节假日日期
	 */
	private String festivalDeploy;

}
