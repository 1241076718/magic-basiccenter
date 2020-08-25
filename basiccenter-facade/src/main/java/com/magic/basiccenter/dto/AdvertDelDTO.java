package com.magic.basiccenter.dto;

import java.io.Serializable;

import lombok.Data;

/**
 * <p>广告配置删除入参</P>
 *
 * @author tangw@belink.com
 * @version 0.0.1
 * @className AdvertDelDTO
 * @sine 2020/8/19 16:18
 */
@Data
public class AdvertDelDTO implements Serializable {
	private static final long serialVersionUID = -7222602642770314417L;

	/**
	 * 广告编号
	 */
	private String aiAdvId;
}
