package com.magic.basiccenter.model.dto;

import java.io.Serializable;
import java.util.List;
import com.magic.basiccenter.dto.ColumnInfBean;

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
public class SelAdvertColInfoOutDTO implements Serializable {
	private static final long serialVersionUID = -8492306318549401032L;
	/*
	 * 栏位信息集合
	 */
	private List<ColumnInfBean> columnList;
}
