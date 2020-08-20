package com.magic.basiccenter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.magic.application.infrastructure.service.dto.MagicDTO;
import com.magic.application.infrastructure.service.dto.MagicOutDTO;
import com.magic.basiccenter.dto.AdvertAddDTO;
import com.magic.basiccenter.dto.AdvertAddOutDTO;
import com.magic.basiccenter.dto.AdvertSelDTO;
import com.magic.basiccenter.dto.AdvertSelOutPageDTO;
import com.magic.basiccenter.service.IAdvertManageService;

/**
 * <p>基础中心--控制器</P>
 *
 * @author zhuzh@belink.com
 * @version 0.0.1
 * @className basicController
 * @sine 2020/8/17 9:13
 */
@RequestMapping("basic")
@RestController
public class BasicController {
    @Autowired
    private IAdvertManageService advertManageService;

    /**
     * 广告配置新增
     * @param requestDTO
     * @return
     */
    @PostMapping("/advert/addAdvertInfo")
    public MagicOutDTO<AdvertAddOutDTO> addAdvertInfo(@RequestBody MagicDTO<AdvertAddDTO> requestDTO) {
        return advertManageService.addAdvertInfo(requestDTO);
    }
    /**
     * 广告列表查询
     * @param requestDTO
     * @return
     */
    @PostMapping("/advert/advertSelCond")
    public MagicOutDTO<AdvertSelOutPageDTO> advertSelCond(@RequestBody MagicDTO<AdvertSelDTO> requestDTO){
        return advertManageService.advertSelCond(requestDTO);
    }
}
