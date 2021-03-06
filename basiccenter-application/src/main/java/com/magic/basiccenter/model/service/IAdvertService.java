package com.magic.basiccenter.model.service;

import com.magic.basiccenter.model.dto.AddAdvertInfoDTO;
import com.magic.basiccenter.model.dto.DelAdvertInfoDTO;
import com.magic.basiccenter.model.dto.SelAdvertColInfoDTO;
import com.magic.basiccenter.model.dto.SelAdvertColInfoOutDTO;
import com.magic.basiccenter.model.dto.SelAdvertInfoDTO;
import com.magic.basiccenter.model.dto.SelAdvertInfoOutDTO;
import com.magic.basiccenter.model.dto.UpdAdvertInfoDTO;

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
    public boolean addAdvertInfo(AddAdvertInfoDTO inputDTO);
    
    /**
     * 广告分页查询
     * @param selAdvertInfoDTO
     * @return
     * @author jianggq@belink.com
     */
    public SelAdvertInfoOutDTO selAdvertInfo(SelAdvertInfoDTO selAdvertInfoDTO);
    
    /**
     * 通过主键id删除广告(逻辑删除，将广告状态置为3)
     * @param advertDelDTO
     * @return
     * @author tangw@belink.com
     */
    public boolean delAdvertInfo(DelAdvertInfoDTO advertDelDTO);

    /**
     * 广告配置修改
     * @param updDTO
     * @return
     * @author luolf@belink.com
     * */
    public boolean updAdvertInfo(UpdAdvertInfoDTO updDTO);
    
    /**
     * 广告栏位查询
     * @param SelAdvertColInfoDTO
     * @return SelAdvertColInfoOutDTO
     * @author jianggq@belink.com
     */
    public SelAdvertColInfoOutDTO selAdvertColInfo(SelAdvertColInfoDTO selAdvertColInfoDTO);
}
