package com.magic.basiccenter.service.impl;

import com.magic.application.infrastructure.service.dto.MagicDTO;
import com.magic.application.infrastructure.service.dto.MagicOutDTO;
import com.magic.basiccenter.dto.QueryNoticeInfoInDTO;
import com.magic.basiccenter.dto.QueryNoticeInfoOutDTO;

import com.magic.basiccenter.model.dto.QueryNoticeDTO;
import com.magic.basiccenter.model.dto.QueryNoticeOutDTO;
import com.magic.basiccenter.model.service.NoticeService;
import com.magic.basiccenter.service.INoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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
        QueryNoticeDTO queryNoticeDTO = new QueryNoticeDTO();
        QueryNoticeInfoInDTO body = requestDTO.getBody();
        queryNoticeDTO.setNiNtcCreator(body.getNiNtcCreator());
        queryNoticeDTO.setNiNtcId(body.getNiNtcId());
        queryNoticeDTO.setNiNtcName(body.getNiNtcName());
        queryNoticeDTO.setNiNtcStatus(body.getNiNtcStatus());
        queryNoticeDTO.setNiNtcStartTime(body.getNiNtcStartTime());
        queryNoticeDTO.setNiNtcEndTime(body.getNiNtcEndTime());
        queryNoticeDTO.setNowsPage(body.getNowsPage());
        queryNoticeDTO.setPageSize(body.getPageSize());
        List<QueryNoticeOutDTO> queryNoticeOutDTOS = service.queryNotice(queryNoticeDTO);
        queryNoticeDTO.setPageSize(null);
        List<QueryNoticeOutDTO> totalNotices = service.queryNotice(queryNoticeDTO);
        QueryNoticeInfoOutDTO outDTOd = new QueryNoticeInfoOutDTO();
        System.out.println(requestDTO + "==============queryOperatorList4CustId==11================");
        System.out.println(requestDTO.getBody());
        outDTOd.setData(queryNoticeOutDTOS);
        outDTOd.setTatal(totalNotices.size());
        outDTOd.setCode(200);
        outDTOd.setMsg("成功");
        result.setBody(outDTOd);
        System.out.println("NoticeServiceDaoImpl=========11====================");
        return result;
    }


    @Override
    public MagicOutDTO<QueryNoticeInfoOutDTO> querynoticeinfo() {
        MagicOutDTO<QueryNoticeInfoOutDTO> result = new MagicOutDTO<>();

        return result;


    }


}
