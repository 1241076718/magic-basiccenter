package com.magic.basiccenter.service.impl;


import com.gift.core.utils.SpringContextUtils;
import com.magic.basiccenter.dto.QueryNoticeInfoInDTO;
import com.magic.basiccenter.dto.QueryNoticeInfoOutDTO;
import com.magic.basiccenter.model.entity.CuNoticeInf;
import com.magic.basiccenter.model.mapper.CuNoticeInfMapper;
import com.magic.basiccenter.model.mapper.CuNoticeStatusInfMapper;
import com.magic.basiccenter.model.service.IBsNoticeInfService;
import com.magic.basiccenter.model.service.NoticeStatusService;
import com.magic.basiccenter.model.service.impl.BsNoticeStatusInfServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticeStatusServiceImpl implements NoticeStatusService {
    @Autowired
    private IBsNoticeInfService iBsNoticeInfService;

    @Override
    public QueryNoticeInfoOutDTO changeNoticeStatus(QueryNoticeInfoInDTO inputDTO) {
        QueryNoticeInfoOutDTO changeNoticeStatus = new QueryNoticeInfoOutDTO();
        BsNoticeStatusInfServiceImpl been = SpringContextUtils.getBean(BsNoticeStatusInfServiceImpl.class);
        CuNoticeStatusInfMapper baseMapper = been.getBaseMapper();
        CuNoticeInf cuNoticeInf = new CuNoticeInf();
        BeanUtils.copyProperties(inputDTO,cuNoticeInf);
        int i =baseMapper.updateById(cuNoticeInf);
        changeNoticeStatus.setTotal(i);
        return changeNoticeStatus;
    }
}
