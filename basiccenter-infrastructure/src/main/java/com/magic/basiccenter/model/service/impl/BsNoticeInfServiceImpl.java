package com.magic.basiccenter.model.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.magic.basiccenter.model.dto.QueryNoticeDTO;
import com.magic.basiccenter.model.dto.QueryNoticeOutDTO;
import com.magic.basiccenter.model.entity.BsNoticeInf;
import com.magic.basiccenter.model.mapper.BsNoticeInfMapper;
import com.magic.basiccenter.model.service.IBsNoticeInfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author ：goupc1@belink.com
 * @date ：Created in 2020/8/620 9:54
 * @description： 数据交互层服务实现类
 * @modified By：
 * @version: $1.0.0
 */
@Service
public class BsNoticeInfServiceImpl extends ServiceImpl<BsNoticeInfMapper, BsNoticeInf> implements IBsNoticeInfService {

    @Autowired
    private BsNoticeInfMapper bsNoticeInfMapper;


    @Override
    public List<QueryNoticeOutDTO>  selectNotice(QueryNoticeDTO queryNoticeDTO) {

        List<QueryNoticeOutDTO> cuNoticeInfs = bsNoticeInfMapper.selectNotice(queryNoticeDTO);

                    return cuNoticeInfs;
    }
}
