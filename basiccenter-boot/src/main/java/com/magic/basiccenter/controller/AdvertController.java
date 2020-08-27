package com.magic.basiccenter.controller;

import com.magic.application.infrastructure.service.dto.MagicDTO;
import com.magic.application.infrastructure.service.dto.MagicOutDTO;
import com.magic.basiccenter.dto.AdvertAddDTO;
import com.magic.basiccenter.dto.AdvertAddOutDTO;
import com.magic.basiccenter.dto.AdvertSelDTO;
import com.magic.basiccenter.dto.AdvertSelOutDTO;
import com.magic.basiccenter.dto.AdvertUpdDTO;
import com.magic.basiccenter.dto.AdvertUpdOutDTO;
import com.magic.basiccenter.dto.AdvertDelDTO;
import com.magic.basiccenter.dto.AdvertDelOutDTO;
import com.magic.basiccenter.service.IAdvertManageService;
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
public class AdvertController {
    /**
     * 广告管理模块服务
     */
    @Autowired
    private IAdvertManageService advertManageService;

    /**
     * 广告配置新增
     * @param requestDTO
     * @return
     * @author laiqx@belink.com
     */
    @PostMapping("/advert/addAdvertInfo")
    public MagicOutDTO<AdvertAddOutDTO> addAdvertInfo(@RequestBody MagicDTO<AdvertAddDTO> requestDTO) {
        return advertManageService.addAdvertInfo(requestDTO);
    }

    /**
     * 广告列表查询
     * @param requestDTO
     * @return
     * @author jianggq@belink.com
     */
    @PostMapping("/advert/selAdvertInfo")
    public MagicOutDTO<AdvertSelOutDTO> selAdvertInfo(@RequestBody MagicDTO<AdvertSelDTO> requestDTO){
        return advertManageService.selAdvertInfo(requestDTO);
    }

    /**
     * 删除广告
     * @param requestDTO
     * @return
     * @author tangw@belink.com
     */
    @PostMapping("advert/delAdvertInfo")
	public MagicOutDTO<AdvertDelOutDTO> delAdvertInfo(@RequestBody MagicDTO<AdvertDelDTO> requestDTO){
		return advertManageService.delAdvertInfo(requestDTO);
	}

    /**
     * 广告配置修改
     * @param requestDTO
     * @return
     * @author luolf@belink.com
     */
    @PostMapping("/advert/updAdvertInfo")
    public MagicOutDTO<AdvertUpdOutDTO> updAdvertInfo(@RequestBody MagicDTO<AdvertUpdDTO> requestDTO) {
        return advertManageService.updAdvertInfo(requestDTO);
    }



}
