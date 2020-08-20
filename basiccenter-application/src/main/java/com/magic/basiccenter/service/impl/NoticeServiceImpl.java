package com.magic.basiccenter.service.impl;

import com.gift.core.utils.SpringContextUtils;
import com.magic.application.infrastructure.service.dto.MagicDTO;
import com.magic.application.infrastructure.service.dto.MagicOutDTO;
import com.magic.basiccenter.dto.QueryNoticeInfoInDTO;
import com.magic.basiccenter.dto.QueryNoticeInfoOutDTO;
import com.magic.basiccenter.model.entity.CuNoticeInf;
import com.magic.basiccenter.model.mapper.CuNoticeInfMapper;
import com.magic.basiccenter.service.INoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
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
public class NoticeServiceImpl implements INoticeService {


//    @Autowired(required = false)
//    @Resource
//    private CuNoticeInfMapper mapper;


    @Override
    public MagicOutDTO<QueryNoticeInfoOutDTO> queryOperatorList4CustId(MagicDTO<QueryNoticeInfoInDTO> requestDTO) {
        MagicOutDTO<QueryNoticeInfoOutDTO> result = new MagicOutDTO<>();
           System.out.println(result+"================11================");
        CuNoticeInfMapper mapper = SpringContextUtils.getBean(CuNoticeInfMapper.class);

        CuNoticeInf cuNoticeInf = mapper.selectOne(null);
           List   list=new ArrayList();
           list.add(cuNoticeInf);
        QueryNoticeInfoOutDTO  dto=new QueryNoticeInfoOutDTO();
           dto.setNotice_infs(list);
           result.setBody(dto);

          System.out.println("NoticeServiceImpl=========11====================");
           return result;
    }

    @Override
    public MagicOutDTO<QueryNoticeInfoOutDTO> querynoticeinfo() {
         MagicOutDTO<QueryNoticeInfoOutDTO> result = new MagicOutDTO<>();
         System.out.println(result+"==MagicOutDTO===========22===================");
//        CuNoticeInf cuNoticeInf1 = mapper.selectOne(null);
//        System.out.println(cuNoticeInf1+"=============");
        CuNoticeInfMapper mapper = SpringContextUtils.getBean(CuNoticeInfMapper.class);
        CuNoticeInf cuNoticeInf = mapper.selectById(1);
        System.out.println(cuNoticeInf+"==========22=================");
         List   list=new ArrayList();
         list.add(cuNoticeInf);
         QueryNoticeInfoOutDTO  dto=new QueryNoticeInfoOutDTO();
         dto.setNotice_infs(list);
         result.setBody(dto);

         System.out.println("NoticeServiceImpl======22=======================");
        return result;



    }


}
