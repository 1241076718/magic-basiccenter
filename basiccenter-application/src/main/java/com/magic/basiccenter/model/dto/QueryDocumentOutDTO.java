package com.magic.basiccenter.model.dto;

import com.magic.basiccenter.dto.DocumentFacadeDto;
import com.magic.basiccenter.model.entity.DocumentEntity;
import lombok.Data;

import javax.swing.event.DocumentEvent;
import java.io.Serializable;
import java.util.List;

@Data
public class QueryDocumentOutDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1024716140048009045L;

	/**
	 * 返回文档列表
	 */
	private List<DocumentEntity> docsList;

	/**
	 * 返回列表总数
	 */
	private Integer total;

}
