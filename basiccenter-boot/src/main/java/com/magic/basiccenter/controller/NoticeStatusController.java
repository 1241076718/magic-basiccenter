package com.magic.basiccenter.controller;

import com.magic.application.infrastructure.service.dto.MagicDTO;
import com.magic.application.infrastructure.service.dto.MagicOutDTO;
import com.magic.basiccenter.dto.QueryNoticeInfoInDTO;
import com.magic.basiccenter.dto.QueryNoticeInfoOutDTO;
import com.magic.basiccenter.service.IBasicNoticeService;
//import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Goku
 * @date 2020年 08月19日 14:05:25
 */
@RestController
@Slf4j
@RequestMapping("notice")
public class NoticeStatusController {
    @Autowired
    private IBasicNoticeService inoticeService;

    /**
     * 公告上下架管理 改变公告状态
     * @param queryNoticeInfoInDTO
     * @return
     */
    @PostMapping("/changeNoticeStatus")
//    @ApiOperation(value = "公告上架下架管理", notes = "公告上架下架", httpMethod = "POST", response = String.class)
    public MagicOutDTO<QueryNoticeInfoOutDTO> changeNoticeStatus(@RequestBody MagicDTO<QueryNoticeInfoInDTO> queryNoticeInfoInDTO){

        MagicOutDTO<QueryNoticeInfoOutDTO> magicDTO = inoticeService.changeNoticeStatus(queryNoticeInfoInDTO);

        return magicDTO;
    }
}
