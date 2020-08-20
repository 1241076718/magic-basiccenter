package com.magic.basiccenter.controller;

import com.magic.application.infrastructure.service.dto.MagicDTO;
import com.magic.application.infrastructure.service.dto.MagicOutDTO;
import com.magic.basiccenter.dto.QueryNoticeInfoInDTO;
import com.magic.basiccenter.dto.QueryNoticeInfoOutDTO;
import com.magic.basiccenter.service.INoticeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>基础中心--控制器</P>
 *
 * @author zhuzh@belink.com
 * @version 0.0.1
 * @className basicController
 * @sine 2020/8/17 9:13
 */
@RestController
@Slf4j
@RequestMapping("/notice")
public class BasicController {

    @Autowired(required = false)
    INoticeService service;

    @RequestMapping("/test01")
    public MagicOutDTO<QueryNoticeInfoOutDTO> test01(){
        MagicOutDTO<QueryNoticeInfoOutDTO> querynoticeinfo = service.querynoticeinfo();
        System.out.println(querynoticeinfo);
        return  querynoticeinfo;

    }
    @PostMapping("/select")
    public MagicOutDTO<QueryNoticeInfoOutDTO> test012(@RequestBody MagicDTO<QueryNoticeInfoInDTO> queryNoticeInfoInDTO){
        System.out.println(queryNoticeInfoInDTO+"==============test02================================");
        MagicOutDTO<QueryNoticeInfoOutDTO> querynoticeinfo = service.queryOperatorList4CustId(queryNoticeInfoInDTO);
        System.out.println(querynoticeinfo);
        return  querynoticeinfo;

    }
}