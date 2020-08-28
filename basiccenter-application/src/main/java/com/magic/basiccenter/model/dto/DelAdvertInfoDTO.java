package com.magic.basiccenter.model.dto;

import java.io.Serializable;

import lombok.Data;

/**
 * <p>广告配置删除入参</P>
 *
 * @author tangw@belink.com
 * @version 0.0.1
 * @className DelAdvertInfoDTO
 * @sine 2020/8/19 16:18
 */
@Data
public class DelAdvertInfoDTO implements Serializable {
	private static final long serialVersionUID = 2565567300742690327L;

	/**
	 * 广告编号
	 */
	private String aiAdvId;
}
