package com.magic.basiccenter.service.impl;

import com.gift.core.utils.SpringContextUtils;
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

@Service
public class AddNoticeServiceDaoImpl implements AddNoticeService {

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
        int row = baseMapper.insert(cuNoticeInf);
        addNoticeInfoOutDTO.setTotal(row);
        return addNoticeInfoOutDTO;
    }

}
