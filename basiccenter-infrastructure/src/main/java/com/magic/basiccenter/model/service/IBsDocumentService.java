package com.magic.basiccenter.model.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.magic.basiccenter.model.entity.BsDocumentInf;


import java.util.List;


public interface IBsDocumentService extends IService<BsDocumentInf> {
    /**
     * 根据条件查询文档列表
     */
    List<BsDocumentInf> selectDocumentList(Integer startIndex,
                                           Integer turnPageShowNum,
                                           String docTitle,
                                           String docType,
                                           String startTime,
                                           String endTime);
    /**
     * 查询文档类型列表
     * @return
     */
    List<String> queryCatalogNameList();
}
