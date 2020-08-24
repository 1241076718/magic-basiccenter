package com.magic.basiccenter.model.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.magic.basiccenter.model.entity.BsDocumentInf;
import org.apache.ibatis.annotations.Param;

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
}
