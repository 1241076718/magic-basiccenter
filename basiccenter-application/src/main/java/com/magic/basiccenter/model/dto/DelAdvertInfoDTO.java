package com.magic.basiccenter.model.dto;

import java.io.Serializable;

import lombok.Data;
@Data
public class DelAdvertInfoDTO implements Serializable {

	/**
	 * 删除广告的输入对象
	 */
	private static final long serialVersionUID = 2565567300742690327L;

	
	/**
	 * 广告编号
	 */
	private Integer aiAdvId;
	
	
}
