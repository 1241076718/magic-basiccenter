package com.magic.basiccenter.dto.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class DocumentTypeBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6298898543436263061L;
	
	/**
	 * 文档类型ID
	 */
	private String docTypeId;
	
	/**
	 * 文档类型
	 */
	private String docType;
	/**
	 * 文档类型是否失效(否：0，是：1)
	 */
	private String invalid;

}
