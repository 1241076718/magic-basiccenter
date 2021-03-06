package com.magic.basiccenter.model.service;

import com.magic.basiccenter.model.dto.*;

/**
 * 后端接口
 */
public interface DocumentManageService {
    /**
     * 数据回显
     * @param documentIdDto
     * @return
     */
    DocumentDTO queryData(DocumentIdDTO documentIdDto);

    /**
     * 数据修改
     * @param documentDto
     * @return
     */
    DocumentStateDTO queryModify(DocumentDTO documentDto);

    /**
     * 文档发布
     * @param documentDto
     * @return
     */
    DocumentStateDTO publish(DocumentInputDTO documentDto);

    /**
     * 文档删除
     * @param documentDto
     * @return
     */
    DocumentStateDTO delete (DocumentIdDTO documentDto);

    /**
     * 新增
     * @param inputDTO
     * @return
     */
    public DocumentStateDTO addDocumentState(DocumentDTO inputDTO);
	
    /**
	 * 查询文档列表
	 * @param inputDTO
	 * @return
	 */
	public QueryDocumentOutDTO queryDocumentList(QueryDocumentDTO inputDTO);

}