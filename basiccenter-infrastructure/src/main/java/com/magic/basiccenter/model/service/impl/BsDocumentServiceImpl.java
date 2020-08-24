package com.magic.basiccenter.model.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.magic.basiccenter.model.entity.BsDocumentInf;
import com.magic.basiccenter.model.mapper.BsDocumentInfMapper;
import com.magic.basiccenter.model.service.IBsDocumentService;

@Service
public class BsDocumentServiceImpl extends ServiceImpl<BsDocumentInfMapper, BsDocumentInf> implements IBsDocumentService {


    @Override
    public List<BsDocumentInf> selectDocumentList(Integer startIndex, Integer turnPageShowNum, String docTitle, String docType, String startTime, String endTime) {

        return  baseMapper.selectDocumentList(startIndex,turnPageShowNum,docTitle,docType,startTime,endTime);
    }
}
