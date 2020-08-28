package com.magic.basiccenter.model.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.magic.basiccenter.model.entity.BsDocumentInf;
import com.magic.basiccenter.model.mapper.BsDocumentInfMapper;
import com.magic.basiccenter.model.service.IBsDocumentService;

@Service
public class BsDocumentServiceImpl extends ServiceImpl<BsDocumentInfMapper, BsDocumentInf> implements IBsDocumentService {


    /**
     * 查询文档类型列表
     * @return
     */
    @Override
    public List<String> queryCatalogNameList() {
        return baseMapper.queryCatalogNameList();
    }

    @Override
    public List<BsDocumentInf> selectDocumentList(Integer startIndex, Integer turnPageShowNum, String docTitle, String docType, String startTime, String endTime) {
        return  baseMapper.selectDocumentList(startIndex,turnPageShowNum,docTitle,docType,startTime,endTime);
    }
}
