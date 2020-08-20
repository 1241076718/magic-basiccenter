package com.magic.basiccenter.controller;

import com.magic.application.infrastructure.service.dto.MagicDTO;
import com.magic.application.infrastructure.service.dto.MagicOutDTO;
import com.magic.basiccenter.dto.AddNoticeInfoInDTO;
import com.magic.basiccenter.dto.AddNoticeInfoOutDTO;
import com.magic.basiccenter.model.service.AddNoticeService;
import com.magic.basiccenter.service.IAddNoticeService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    private IAddNoticeService addNoticeService;

    @PostMapping("/addNotice")
    public MagicOutDTO<AddNoticeInfoOutDTO> addNotice(@RequestBody MagicDTO<AddNoticeInfoInDTO> requestDTO){
        return addNoticeService.addNoticeInfo(requestDTO);
    }
}