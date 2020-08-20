package com.magic.basiccenter.service.impl;

import com.magic.application.infrastructure.service.dto.MagicDTO;
import com.magic.application.infrastructure.service.dto.MagicOutDTO;
import com.magic.application.infrastructure.service.dto.data.ReqHeader;
import com.magic.application.infrastructure.service.dto.data.RespHeader;
import com.magic.basiccenter.dto.AddNoticeInfoInDTO;
import com.magic.basiccenter.dto.AddNoticeInfoOutDTO;
import com.magic.basiccenter.model.service.AddNoticeService;
import com.magic.basiccenter.service.IAddNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddNoticeServiceImpl implements IAddNoticeService {

    @Autowired
    private AddNoticeService addNoticeService;

    @Override
    public MagicOutDTO<AddNoticeInfoOutDTO> addNoticeInfo(MagicDTO<AddNoticeInfoInDTO> requestDTO) {
        //定义输出
        AddNoticeInfoOutDTO addNoticeDTO = new AddNoticeInfoOutDTO();
        MagicOutDTO<AddNoticeInfoOutDTO> magicOutDTO = new MagicOutDTO<>(addNoticeDTO);
        RespHeader respHead = new RespHeader();
        //请求头
        ReqHeader reqHead = requestDTO.getHeader();
        AddNoticeInfoInDTO body = requestDTO.getBody();
        AddNoticeInfoOutDTO addNoticeInfoOutDTO = addNoticeService.addNotice(body);
        Integer rows = addNoticeInfoOutDTO.getTotal();
        if (rows<1){
            respHead.setErrorCode("-1");
            respHead.setErrorMsg("添加公告失败");
        }else{
            addNoticeInfoOutDTO.setMsg("添加公告成功");
            addNoticeInfoOutDTO.setCode(0);
        }
        magicOutDTO.setHeader(respHead);
        magicOutDTO.setBody(addNoticeInfoOutDTO);
        return magicOutDTO;
    }
}
