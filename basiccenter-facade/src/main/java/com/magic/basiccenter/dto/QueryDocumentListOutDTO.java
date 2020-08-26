package com.magic.basiccenter.dto;

import java.io.Serializable;
import java.util.List;

import com.magic.application.infrastructure.service.dto.SelectPageOutDTO;
import com.magic.basiccenter.dto.entity.DocumentBean;

import com.magic.basiccenter.dto.entity.DocumentTypeBean;
import lombok.Data;

@Data
public class QueryDocumentListOutDTO extends SelectPageOutDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4045098523557410822L;
	/**
	 * 返回文档列表
	 */
	private List<DocumentBean> docsList;
    /**
     * 返还文档类型列表
     */
    private List<DocumentTypeBean> catalogNameList;

}
