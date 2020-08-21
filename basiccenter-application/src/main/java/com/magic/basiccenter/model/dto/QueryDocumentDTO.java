package com.magic.basiccenter.model.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class QueryDocumentDTO implements Serializable {
	
	/**
	 * 序列号
	 */
	private static final long serialVersionUID = -824940392640078563L;
	/**
	 * 文档标题
	 */
	private String docsName;
	/**
	 * 文档类型
	 */
	private String catalogName;
	
	/**
	 * 发布时间
	 */
	private String documentPubdate;
	/**
	 * 当前页码
	 */
	private Integer currentPage;
	/**
	 * 页面展示数据条数
	 */
	private Integer turnPageShowNum;
	/**
	 * 当前文档状态
	 */
	private Integer state;

}
