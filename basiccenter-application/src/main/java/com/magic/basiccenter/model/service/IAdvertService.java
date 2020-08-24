package com.magic.basiccenter.model.service;

import com.magic.basiccenter.model.dto.AddAdvertInfoDTO;
import com.magic.basiccenter.model.dto.AddAdvertInfoOutDTO;
import com.magic.basiccenter.model.dto.DelAdvertInfoDTO;
import com.magic.basiccenter.model.dto.DelAdvertInfoOutDTO;
import com.magic.basiccenter.model.dto.SelAdvertInfoPageDTO;
import com.magic.basiccenter.model.dto.SelAdvertInfoPageOutDTO;
import com.magic.basiccenter.model.dto.UpdAdvertInfoDTO;
import com.magic.basiccenter.model.dto.UpdAdvertInfoOutDTO;

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
     * @author laiqx@belink.com
     */
    public AddAdvertInfoOutDTO addAdvertInfo(AddAdvertInfoDTO inputDTO);
    
    /**
     * 广告分页查询
     * @param selAdvertInfoPageDTO
     * @return
     * @author jianggq@belink.com
     */
    public SelAdvertInfoPageOutDTO advertSelPageCond(SelAdvertInfoPageDTO selAdvertInfoPageDTO);
    
    /**
     * 通过主键id删除广告(逻辑删除，将广告状态置为3)
     * @param advertDelDTO
     * @return
     * @author tangw@belink.com
     */
    public DelAdvertInfoOutDTO delAdvertInfo(DelAdvertInfoDTO advertDelDTO);

    /**
     * 广告配置修改
     * @param updDTO
     * @return
     * @author luolf@belink.com
     * */
    public UpdAdvertInfoOutDTO updAdvertInfo(UpdAdvertInfoDTO updDTO);
}
