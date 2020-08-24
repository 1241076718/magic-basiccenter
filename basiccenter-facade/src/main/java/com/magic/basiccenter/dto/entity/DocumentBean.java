package com.magic.basiccenter.dto.entity;

import java.io.Serializable;


import lombok.Data;

@Data
public class DocumentBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 796359233361857801L;
	
	
	/**
	 * 文档编号
	 */
	private String docsId;
	/**
	 * 文档标题
	 */
	private String docsName;
	/**
	 * 文档类型
	 */
	private String catalogName;
	/**
	 * 文档状态   (新建：00，已上架：20，已下架：29)
	 */
	private Integer state;
	/**
	 * 文档f发布时间
	 */
	private String documentPubdate;
	/**
	 * 发布人
	 */
	private String docsCreateUser;


}
