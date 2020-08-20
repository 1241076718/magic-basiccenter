package com.magic.basiccenter.dto;

import java.io.Serializable;

import lombok.Data;
@Data
public class DelAdvertDTO implements Serializable {
	/**
	 * 通过广告id删除广告
	 */
	private static final long serialVersionUID = 17301896388451911L;
	
	
	/**
	 * 广告编号
	 */
	private Integer aiAdvId;
	

}
