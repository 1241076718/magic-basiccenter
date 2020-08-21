package com.magic.basiccenter.model.dto;

import com.magic.basiccenter.dto.DocumentFacadeDto;
import lombok.Data;

import javax.swing.event.DocumentEvent;
import java.io.Serializable;
import java.util.List;

@Data
public class QueryDocumentOutDTO implements Serializable {
	
	/**
	 * 序列号
	 */
	private static final long serialVersionUID = -1024716140048009045L;

	/**
	 * 返回文档列表
	 */
	private List<DocumentFacadeDto> docsList;

	/**
	 * 返回列表总数
	 */
	private Integer total;

}
