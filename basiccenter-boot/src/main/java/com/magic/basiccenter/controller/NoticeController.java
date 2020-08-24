package com.magic.basiccenter.controller;

import com.magic.application.infrastructure.service.dto.MagicDTO;
import com.magic.application.infrastructure.service.dto.MagicOutDTO;
import com.magic.basiccenter.dto.*;
import com.magic.basiccenter.service.IBasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notice")
public class NoticeController {

    @Autowired(required = false)
    IBasicService service;

    /**
     * 添加公告
     * @param requestDTO
     * @return
     */

    @PostMapping("/addNotice")
    public MagicOutDTO<AddNoticeInfoOutDTO> addNotice(@RequestBody MagicDTO<AddNoticeInfoInDTO> requestDTO){
        return service.addNoticeInfo(requestDTO);
    }

    /**
     * 修改公告
     * @param requestDTO
     * @return
     */
    @PostMapping("/updateNotice")
    public MagicOutDTO<UpdateNoticeInfoOutDTO> updateNoticeData(@RequestBody MagicDTO<QueryNoticeInfoInDTO> requestDTO) {
        return service.updateNotice(requestDTO);
    }

    /**
     * 查询公告
     * @param
     * @return
     */

    @PostMapping("/select")
    public MagicOutDTO<QueryNoticeInfoOutDTO> selectNotice(@RequestBody MagicDTO<QueryNoticeInfoInDTO> queryNoticeInfoInDTO){
        System.out.println(queryNoticeInfoInDTO+"==============test02================================");
        MagicOutDTO<QueryNoticeInfoOutDTO> querynoticeinfo = service.queryNoticeList(queryNoticeInfoInDTO);
        return  querynoticeinfo;



    }

    /**
     * 公告上下架管理 改变公告状态
     * @param queryNoticeInfoInDTO
     * @return
     */
    @PostMapping("/changeNoticeStatus")
//    @ApiOperation(value = "公告上架下架管理", notes = "公告上架下架", httpMethod = "POST", response = String.class)
    public MagicOutDTO<QueryNoticeInfoOutDTO> changeNoticeStatus(@RequestBody MagicDTO<QueryNoticeInfoInDTO> queryNoticeInfoInDTO){

        MagicOutDTO<QueryNoticeInfoOutDTO> magicDTO = service.changeNoticeStatus(queryNoticeInfoInDTO);

        return magicDTO;
    }
}