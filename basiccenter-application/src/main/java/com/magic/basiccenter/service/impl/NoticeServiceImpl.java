package com.magic.basiccenter.service.impl;

import com.gift.core.utils.SpringContextUtils;
import com.magic.application.infrastructure.service.dto.MagicDTO;
import com.magic.application.infrastructure.service.dto.MagicOutDTO;
import com.magic.basiccenter.dto.QueryNoticeInfoInDTO;
import com.magic.basiccenter.dto.QueryNoticeInfoOutDTO;

import com.magic.basiccenter.model.dto.QueryNoticeDTO;
import com.magic.basiccenter.model.service.NoticeService;
import com.magic.basiccenter.service.INoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: GPC
 * Date: 2020/08/19 15:59
 * Description:
 * Version: V1.0
 */

@Component
@Transactional(rollbackFor = Exception.class)
public class NoticeServiceImpl implements INoticeService {


//    @Autowired(required = false)
//    private CuNoticeInfMapper mapper;
     @Autowired
     NoticeService service;


    @Override
    public MagicOutDTO<QueryNoticeInfoOutDTO> queryNoticeList(MagicDTO<QueryNoticeInfoInDTO> requestDTO) {
        MagicOutDTO<QueryNoticeInfoOutDTO> result = new MagicOutDTO<>();
//        QueryNoticeDTO    queryNoticeDTO=QueryNoticeDTO>requestDTO.getBody();

//        QueryNoticeInfoOutDTO outDTOd = new QueryNoticeInfoOutDTO();
//        System.out.println(requestDTO + "==============queryOperatorList4CustId==11================");
//        //CuNoticeInfMapper mapper = SpringContextUtils.getBean(CuNoticeInfMapper.class);
//        System.out.println(requestDTO.getBody());
//        List<CuNoticeInf> cuNoticeInfs = mapper.selectLogByPage(requestDTO.getBody());
//        requestDTO.getBody().setNowsPage(null);
//        List<CuNoticeInf> cuNoticeInf = mapper.selectLogByPage(requestDTO.getBody());
//        System.out.println(cuNoticeInfs.toString());
//        outDTOd.setData(cuNoticeInfs);
//        outDTOd.setTatal(cuNoticeInf.size());
//        outDTOd.setCode(200);
//        outDTOd.setMsg("成功");
//        result.setBody(outDTOd);
//        System.out.println("NoticeServiceDaoImpl=========11====================");
        return result;
    }


    @Override
    public MagicOutDTO<QueryNoticeInfoOutDTO> querynoticeinfo() {
        MagicOutDTO<QueryNoticeInfoOutDTO> result = new MagicOutDTO<>();
//        System.out.println(result + "==MagicOutDTO===========22===================");
////        CuNoticeInf cuNoticeInf1 = mapper.selectOne(null);
////        System.out.println(cuNoticeInf1+"=============");
////        CuNoticeInfMapper mapper = SpringContextUtils.getBean(CuNoticeInfMapper.class);
//        CuNoticeInf cuNoticeInf = mapper.selectById(1);
//        System.out.println(cuNoticeInf + "==========22=================");
//        List list = new ArrayList();
//        list.add(cuNoticeInf);
//        QueryNoticeInfoOutDTO dto = new QueryNoticeInfoOutDTO();
//        dto.setData(list);
//        result.setBody(dto);
//
//        System.out.println("NoticeServiceDaoImpl======22=======================");
        return result;


    }


}
