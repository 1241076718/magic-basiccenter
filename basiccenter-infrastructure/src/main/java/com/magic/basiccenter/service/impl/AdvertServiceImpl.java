package com.magic.basiccenter.service.impl;

import com.magic.basiccenter.model.dto.AddAdvertInfoDTO;
import com.magic.basiccenter.model.dto.AddAdvertInfoOutDTO;
import com.magic.basiccenter.model.entity.BsAdvertInf;
import com.magic.basiccenter.model.service.IAdvertService;
import com.magic.basiccenter.model.service.IBsAdvertInfService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>广告配置数据交互接口实现类</P>
 *
 * @author laiqx@belink.com
 * @version 0.0.1
 * @className AdvertServiceImpl
 * @sine 2020/8/19 10:18
 */
@Service("advertService")
public class AdvertServiceImpl implements IAdvertService {
    /**
     * 广告配置数据对应实体服务
     */
    @Autowired
    private IBsAdvertInfService bsAdvertInfService;

    @Override
    public AddAdvertInfoOutDTO addAdvertInfo(AddAdvertInfoDTO inputDTO) {
        AddAdvertInfoOutDTO outData = new AddAdvertInfoOutDTO();

        BsAdvertInf bsAdvertInf = new BsAdvertInf();
        //bsAdvertInf.setAiAdvId(inputDTO.getAiAdvId());
        BeanUtils.copyProperties(inputDTO, bsAdvertInf);
        bsAdvertInfService.save(bsAdvertInf);

        return outData;
    }
}
