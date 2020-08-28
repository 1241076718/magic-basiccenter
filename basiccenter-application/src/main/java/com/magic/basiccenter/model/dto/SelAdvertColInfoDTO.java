package com.magic.basiccenter.model.dto;

import java.io.Serializable;
import lombok.Data;

/**
 * <p>广告配置列表查询基础交互入参DTO</P>
 *
 * @author jianggq@belink.com
 * @version 0.0.1
 * @className AdvertSelDTO
 * @sine 2020/8/21 17:12
 */
@Data
public class SelAdvertColInfoDTO implements Serializable {
	private static final long serialVersionUID = -480802116434685117L;
	/*
	 * 基础字典类型
	 */
	private String bsCodeType;
}
