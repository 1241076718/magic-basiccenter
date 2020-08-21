package com.magic.basiccenter.service.impl;

import com.gift.core.utils.SpringContextUtils;
import com.gift.domain.sequence.factory.SequenceFactory;
import com.magic.basiccenter.constants.Constant;
import com.magic.basiccenter.dto.AddNoticeInfoInDTO;
import com.magic.basiccenter.dto.AddNoticeInfoOutDTO;
import com.magic.basiccenter.model.entity.CuNoticeInf;
import com.magic.basiccenter.model.mapper.CuNoticeInfMapper;
import com.magic.basiccenter.model.service.AddNoticeService;
import com.magic.basiccenter.model.service.IBsNoticeInfService;
import com.magic.basiccenter.model.service.impl.BsNoticeInfServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AddNoticeServiceDaoImpl implements AddNoticeService {

    @Autowired
    SequenceFactory sequenceFactory;
    @Autowired
    private IBsNoticeInfService bsNoticeInfService;

    @Override
    public AddNoticeInfoOutDTO addNotice(AddNoticeInfoInDTO inputDTO) {
        AddNoticeInfoOutDTO addNoticeInfoOutDTO = new AddNoticeInfoOutDTO();
        BsNoticeInfServiceImpl bean = SpringContextUtils.getBean(BsNoticeInfServiceImpl.class);
        CuNoticeInfMapper baseMapper = bean.getBaseMapper();
        CuNoticeInf cuNoticeInf = new CuNoticeInf();
        //DTO转换为entity
        BeanUtils.copyProperties(inputDTO,cuNoticeInf);
        String noticeId = sequenceFactory.getSegmentDateId(Constant.CU_NOTICE_ID);
        cuNoticeInf.setNiNtcId(noticeId);
        cuNoticeInf.setNiNtcGmtCreate(new Date());
        int row = baseMapper.insert(cuNoticeInf);
        addNoticeInfoOutDTO.setTotal(row);
        return addNoticeInfoOutDTO;
    }

}
