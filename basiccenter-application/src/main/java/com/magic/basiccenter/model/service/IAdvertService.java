package com.magic.basiccenter.model.service;

import com.magic.basiccenter.model.dto.AddAdvertInfoDTO;
import com.magic.basiccenter.model.dto.AddAdvertInfoOutDTO;

/**
 * <p>广告配置数据交互接口</P>
 *
 * @author laiqx@belink.com
 * @version 0.0.1
 * @interfaceName IAdvertService
 * @sine 2020/8/19 10:18
 */
public interface IAdvertService {

    /**
     * 广告配置新增
     * @param inputDTO
     * @return
     */
    public AddAdvertInfoOutDTO addAdvertInfo(AddAdvertInfoDTO inputDTO);
}
