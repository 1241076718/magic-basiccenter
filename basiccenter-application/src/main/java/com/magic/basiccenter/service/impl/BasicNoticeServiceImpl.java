package com.magic.basiccenter.service.impl;

import com.magic.application.infrastructure.service.dto.MagicDTO;
import com.magic.application.infrastructure.service.dto.MagicOutDTO;
import com.magic.application.infrastructure.service.dto.data.ReqHeader;
import com.magic.application.infrastructure.service.dto.data.RespHeader;
import com.magic.basiccenter.dto.QueryNoticeInfoOutDTO;
import com.magic.basiccenter.dto.QueryNoticeInfoInDTO;
import com.magic.basiccenter.error.BasicErrorEnum;
import com.magic.basiccenter.model.service.NoticeStatusService;
import com.magic.basiccenter.service.IBasicNoticeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * :TODO
 *
 * @author Goku
 * @date 2020年 08月19日 15:49:55
 */
@Slf4j
@Service
public class BasicNoticeServiceImpl implements IBasicNoticeService {
    @Autowired
    private NoticeStatusService noticeStatusService;

    @Override
    public MagicOutDTO<QueryNoticeInfoOutDTO> changeNoticeStatus(MagicDTO<QueryNoticeInfoInDTO> requestDTO) {
        QueryNoticeInfoOutDTO queryNoticeInfoOutDTO = new QueryNoticeInfoOutDTO();
        MagicOutDTO<QueryNoticeInfoOutDTO> magicOutDTO = new MagicOutDTO<>(queryNoticeInfoOutDTO);

        RespHeader respHeader = new RespHeader();
        ReqHeader reqHeader = requestDTO.getHeader();
        QueryNoticeInfoInDTO body = requestDTO.getBody();

        QueryNoticeInfoOutDTO changeNoticeStatus = noticeStatusService.changeNoticeStatus(body);

        int i = changeNoticeStatus.getTotal();
        if(i > 0){
            respHeader.setErrorCode(BasicErrorEnum.SUCCESS.code());
            respHeader.setErrorMsg(BasicErrorEnum.SUCCESS.msg());
        }else {
            respHeader.setErrorCode(BasicErrorEnum.FAIL.code());
            respHeader.setErrorMsg(BasicErrorEnum.FAIL.msg());
        }
        magicOutDTO.setHeader(respHeader);
        return magicOutDTO;
    }
}
