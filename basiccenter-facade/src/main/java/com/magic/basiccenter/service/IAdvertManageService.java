package com.magic.basiccenter.service;

import com.magic.application.infrastructure.service.dto.MagicDTO;
import com.magic.application.infrastructure.service.dto.MagicOutDTO;
import com.magic.basiccenter.dto.AdvertAddDTO;
import com.magic.basiccenter.dto.AdvertAddOutDTO;
import com.magic.basiccenter.dto.AdvertSelPageDTO;
import com.magic.basiccenter.dto.AdvertSelPageOutDTO;
import com.magic.basiccenter.dto.AdvertUpdDTO;
import com.magic.basiccenter.dto.AdvertUpdOutDTO;
import com.magic.basiccenter.dto.AdvertDelOutDTO;
import com.magic.basiccenter.dto.AdvertDelDTO;

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
     * @author laiqx@belink.com
     */
    public MagicOutDTO<AdvertAddOutDTO> addAdvertInfo(MagicDTO<AdvertAddDTO> requestDTO);

    /**
     * 广告列表查询
     * @param requestDTO currentPage,setTurnPageShowNum,advertTheme,advertStatus
     * @return AdvertSelOutPageDTO currentPage,totalNum,bannerList
     * @author jianggq@belink.com
     */
    public MagicOutDTO<AdvertSelPageOutDTO> advertSelCond (MagicDTO<AdvertSelPageDTO> requestDTO);

    /**
     * 删除广告
     * @param requestDTO
     * @return
     * @author tangw@belink.com
     */
    public MagicOutDTO<AdvertDelOutDTO> delAdvertInfo(MagicDTO<AdvertDelDTO> requestDTO);

    /**
     * 广告配置修改
     * @param requestDTO
     * @return
     * @author luolf@belink.com
     */
    public MagicOutDTO<AdvertUpdOutDTO> updAdvertInfo(MagicDTO<AdvertUpdDTO> requestDTO);
}
