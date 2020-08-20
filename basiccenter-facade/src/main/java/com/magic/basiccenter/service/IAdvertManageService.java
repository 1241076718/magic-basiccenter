package com.magic.basiccenter.service;

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

/**
 * <p>广告管理接口</P>
 *
 * @author laiqx@belink.com
 * @version 0.0.1
 * @interfaceName IAdvertManageService
 * @sine 2020/8/19 10:18
 */
public interface IAdvertManageService {

    /**
     * 广告配置新增
     * @param requestDTO
     * @return
     */
    public MagicOutDTO<AdvertAddOutDTO> addAdvertInfo(MagicDTO<AdvertAddDTO> requestDTO);

    /**
     * 广告列表查询
     * @param requestDTO
     * @return
     */
    public MagicOutDTO<AdvertSelOutPageDTO> advertSelCond (MagicDTO<AdvertSelDTO> requestDTO);

    /**
     * 删除广告
     * @param dto
     * @return 
     */
    public MagicOutDTO<DelAdvertOutDTO> deleteAdvert(MagicDTO<DelAdvertDTO> dto);

    /**
     * 广告配置修改
     * @param requestDTO
     * @return
     */
    public MagicOutDTO<AdvertUpdOutDTO> updAdvertInfo(MagicDTO<AdvertUpdDTO> requestDTO);
}
