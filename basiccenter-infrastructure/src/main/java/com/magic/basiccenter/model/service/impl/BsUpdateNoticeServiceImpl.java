package com.magic.basiccenter.model.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.magic.basiccenter.model.entity.Notice;
import com.magic.basiccenter.model.mapper.UpdateNoticeMapper;
import com.magic.basiccenter.model.service.IBsUpdateNoticeService;

@Service
public class BsUpdateNoticeServiceImpl extends ServiceImpl<UpdateNoticeMapper, Notice> implements IBsUpdateNoticeService{

}
