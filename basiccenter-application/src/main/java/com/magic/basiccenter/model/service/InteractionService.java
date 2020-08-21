package com.magic.basiccenter.model.service;

import com.magic.basiccenter.model.dto.*;

public interface InteractionService {
    /**
     * 数据回显
     * @param documentIdDto
     * @return
     */
    DocumentDto queryData(DocumentIdDto documentIdDto);

    /**
     * 数据修改
     * @param documentDto
     * @return
     */
    DocmentUpdataDto queryModify(DocumentDto documentDto);

    /**
     * 文档发布
     * @param documentDto
     * @return
     */
    DocumentOutDTO publish(DocumentInputDto documentDto);

    /**
     * 文档删除
     * @param documentDto
     * @return
     */
    DocmentUpdataDto delete (DocumentIdDto documentDto);

    /**
     * 根据文档标题查询
     * @param inputDTO
     * @return
     */
    public QueryDocumentOutDTO queryTitleList(QueryDocumentDTO inputDTO);

    /**
     * 根据文档类型查询
     * @param inputDTO
     * @return
     */
    public QueryDocumentOutDTO queryTypeList(QueryDocumentDTO inputDTO);

    /**
     * 根据发布时间查询
     * @param inputDTO
     * @return
     */
    public QueryDocumentOutDTO queryPubdateList(QueryDocumentDTO inputDTO);

    /**
     * 新增
     * @param inputDTO
     * @return
     */
    public DocmentUpdataDto addDocumentState(DocumentDto inputDTO);

}
