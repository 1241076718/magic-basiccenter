package com.magic.basiccenter.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 节假日修改输出类
 * @author LEI
 *
 */
@Data
public class FestivalModifyOutDTO implements Serializable {


	private static final long serialVersionUID = 7332191304156298683L;
	/**
	 * 修改信息状态
	 */
	private String status;
	/**
	 * 修改信息体
	 */
	private String inf;

}
