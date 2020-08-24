package com.magic.basiccenter.model.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.magic.basiccenter.model.entity.BsDocumentInf;
import com.magic.basiccenter.model.mapper.BsDocumentInfMapper;
import com.magic.basiccenter.model.service.IBsDocumentService;

@Service
public class BsDocumentServiceImpl extends ServiceImpl<BsDocumentInfMapper, BsDocumentInf> implements IBsDocumentService {

    @Autowired
    BsDocumentInfMapper bsDocumentInfMapper;

    /**
     * 查询文档类型列表
     * @return
     */
    @Override
    public List<String> queryCatalogNameList() {
        return bsDocumentInfMapper.queryCatalogNameList();
    }

}
