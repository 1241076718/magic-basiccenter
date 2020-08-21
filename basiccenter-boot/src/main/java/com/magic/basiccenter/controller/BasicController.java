package com.magic.basiccenter.controller;

import com.magic.application.infrastructure.service.dto.MagicDTO;
import com.magic.application.infrastructure.service.dto.MagicOutDTO;
import com.magic.basiccenter.dto.AdvertAddDTO;
import com.magic.basiccenter.dto.AdvertAddOutDTO;
import com.magic.basiccenter.dto.AdvertSelDTO;
import com.magic.basiccenter.dto.AdvertSelOutPageDTO;
import com.magic.basiccenter.dto.AdvertUpdDTO;
import com.magic.basiccenter.dto.AdvertUpdOutDTO;
import com.magic.basiccenter.dto.DelAdvertDTO;
import com.magic.basiccenter.dto.DelAdvertOutDTO;
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
@RequestMapping("basic")
public class BasicController {
    /**
     * 广告管理模块服务
     */
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

    /**
     * 删除广告
     * @param requestDTO
     * @return
     */
    @PostMapping("advert/delAdvertInfo")
	public MagicOutDTO<DelAdvertOutDTO> delAdvertInfo(@RequestBody MagicDTO<DelAdvertDTO> requestDTO){
		return advertManageService.deleteAdvert(requestDTO);
	}

    /**
     * 广告配置修改
     * @param requestDTO
     * @return
     */
    @PostMapping("/advert/updAdvertInfo")
    public MagicOutDTO<AdvertUpdOutDTO> updAdvertInfo(@RequestBody MagicDTO<AdvertUpdDTO> requestDTO) {
        return advertManageService.updAdvertInfo(requestDTO);
    }

}
