package com.magic.basiccenter.model.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class QueryDocumentDTO implements Serializable {
	
	/**
	 * 
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
	
//	/**
//	 * 发布时间段
//	 */
//	private List<String> docsCtime;
	
	/**
	 * 起始时间
	 */
	private String startTime;
	/**
	 * 终止时间
	 */
	private String endTime;
	/**
	 * 当前页码
	 */
	private Integer currentPage;
	/**
	 * 页面展示数据条数
	 */
	private Integer turnPageShowNum;

}
