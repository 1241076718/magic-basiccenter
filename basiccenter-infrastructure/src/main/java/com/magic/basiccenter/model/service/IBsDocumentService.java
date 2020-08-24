package com.magic.basiccenter.model.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.magic.basiccenter.model.entity.BsDocumentInf;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IBsDocumentService extends IService<BsDocumentInf> {

    /**
     * 查询文档类型列表
     * @return
     */
    List<String> queryCatalogNameList();


}
