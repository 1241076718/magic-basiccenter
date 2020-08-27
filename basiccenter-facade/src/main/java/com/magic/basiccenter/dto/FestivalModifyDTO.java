package com.magic.basiccenter.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 节假日修改输入类
 * @author LEI
 *
 */
@Data
public class FestivalModifyDTO implements Serializable {

	private static final long serialVersionUID = -3695293506487343349L;
	/**
	 * 节假日id
	 */
	private String festivalId;
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
