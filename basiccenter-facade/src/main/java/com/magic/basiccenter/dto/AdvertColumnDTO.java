package com.magic.basiccenter.dto;

import java.io.Serializable;
import lombok.Data;

/**
 * <p>广告栏位查询入参</P>
 *
 * @author jianggq@belink.com
 * @version 0.0.1
 * @className AdvertColumnDTO
 * @sine 2020/8/28 17:16
 */
@Data
public class AdvertColumnDTO implements Serializable{
	private static final long serialVersionUID = 5460201993895217080L;
	/*
	 * 基础字典类型
	 */
	private String bsCodeType;
}
