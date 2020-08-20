package com.magic.basiccenter.model.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.magic.basiccenter.model.entity.DocumentEntity;
import com.magic.basiccenter.model.mapper.ModifyMapper;
import com.magic.basiccenter.model.service.DocumentService;
import org.springframework.stereotype.Service;

@Service
public class DocumentServiceImpl extends ServiceImpl<ModifyMapper, DocumentEntity> implements DocumentService {
}
