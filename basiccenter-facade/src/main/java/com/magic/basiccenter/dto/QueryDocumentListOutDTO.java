package com.magic.basiccenter.dto;

import com.magic.basiccenter.model.entity.DocumentEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class QueryDocumentListOutDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4045098523557410822L;
	/**
	 * 返回文档列表
	 */
	private List<DocumentEntity> docsList;

	/**
	 * 返回页码
	 */
	private Integer total;

}
