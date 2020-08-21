package com.magic.basiccenter.service.impl;

import com.magic.application.infrastructure.service.dto.MagicDTO;
import com.magic.application.infrastructure.service.dto.MagicOutDTO;
import com.magic.basiccenter.dto.QueryNoticeInfoInDTO;
import com.magic.basiccenter.dto.QueryNoticeInfoOutDTO;

import com.magic.basiccenter.model.dto.QueryNoticeDTO;
import com.magic.basiccenter.model.dto.QueryNoticeOutDTO;
import com.magic.basiccenter.model.service.IQueryNoticeService;
import com.magic.basiccenter.service.INoticeService;
import org.springframework.beans.BeanUtils;
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
public class QueryNoticeServiceImpl implements INoticeService {


    //    @Autowired(required = false)
//    private CuNoticeInfMapper mapper;
    @Autowired
    IQueryNoticeService service;


    @Override
    public MagicOutDTO<QueryNoticeInfoOutDTO> queryNoticeList(MagicDTO<QueryNoticeInfoInDTO> requestDTO) {
        System.out.println(requestDTO + ")==========================queryNoticeList=======================11================");
        System.out.println(requestDTO.getBody());
        MagicOutDTO<QueryNoticeInfoOutDTO> result = new MagicOutDTO<>();
        QueryNoticeDTO queryNoticeDTO = new QueryNoticeDTO();

        QueryNoticeInfoInDTO body = requestDTO.getBody();

        queryNoticeDTO.setNiNtcCreator(body.getNiNtcCreator());

        queryNoticeDTO.setNiNtcId(body.getNiNtcId());

        queryNoticeDTO.setNiNtcName(body.getNiNtcName());

        queryNoticeDTO.setNiNtcStatus(body.getNiNtcStatus());

        queryNoticeDTO.setNiNtcStartTime(body.getNiNtcStartTime());
        queryNoticeDTO.setNiNtcEndTime(body.getNiNtcEndTime());
        if (body.getNowsPage() != null && body.getPageSize() != null) {
            queryNoticeDTO.setNowsPage((body.getNowsPage() - 1) * body.getPageSize());
            queryNoticeDTO.setPageSize(body.getPageSize() * body.getNowsPage());

        }
//        BeanUtils.copyProperties(body,queryNoticeDTO);
        List<QueryNoticeOutDTO> queryNoticeOutDTOS = service.queryNotice(queryNoticeDTO);
        queryNoticeDTO.setPageSize(null);
        List<QueryNoticeOutDTO> totalNotices = service.queryNotice(queryNoticeDTO);
        QueryNoticeInfoOutDTO outDTOd = new QueryNoticeInfoOutDTO();
        if (!queryNoticeOutDTOS.isEmpty()) {
            outDTOd.setData(queryNoticeOutDTOS);
            outDTOd.setTotal(totalNotices.size());
            outDTOd.setCode(200);
            outDTOd.setMsg("成功");
            result.setBody(outDTOd);
        } else {
            outDTOd.setCode(500);
            outDTOd.setMsg("失败");
        }
        return result;
    }


    @Override
    public MagicOutDTO<QueryNoticeInfoOutDTO> querynoticeinfo() {
        MagicOutDTO<QueryNoticeInfoOutDTO> result = new MagicOutDTO<>();

        return result;


    }


}
