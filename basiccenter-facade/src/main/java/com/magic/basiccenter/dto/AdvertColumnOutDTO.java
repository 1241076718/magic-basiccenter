package com.magic.basiccenter.dto;

import java.io.Serializable;
import java.util.List;
import lombok.Data;

/**
 * <p>广告栏位查询出参</P>
 *
 * @author jianggq@belink.com
 * @version 0.0.1
 * @className AdvertColumnOutDTO
 * @sine 2020/8/28 17:16
 */
@Data
public class AdvertColumnOutDTO implements Serializable{
	private static final long serialVersionUID = 5110565387298288445L;
	/*
	 * 栏位信息集合
	 */
	private List<ColumnInfBean> columnList;
}
