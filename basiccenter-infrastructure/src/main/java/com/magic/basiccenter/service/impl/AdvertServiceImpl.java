package com.magic.basiccenter.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.magic.basiccenter.dto.AdvertSelDTO;
import com.magic.basiccenter.dto.AdvertSelOutPageDTO;
import com.magic.basiccenter.model.dto.AddAdvertInfoDTO;
import com.magic.basiccenter.model.dto.AddAdvertInfoOutDTO;
import com.magic.basiccenter.model.dto.DelAdvertInfoDTO;
import com.magic.basiccenter.model.dto.DelAdvertInfoOutDTO;
import com.magic.basiccenter.model.entity.BsAdvertInf;
import com.magic.basiccenter.model.service.IAdvertService;
import com.magic.basiccenter.model.service.IBsAdvertInfService;

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

    @Override
    public AdvertSelOutPageDTO advertSelPageCond(AdvertSelDTO advertSelDTO) {
    	AdvertSelOutPageDTO advertSelOutPageDTO = new AdvertSelOutPageDTO();
    	Integer currentPage = advertSelDTO.getCurrentPage();
    	Integer turnPageShowNum = advertSelDTO.getTurnPageShowNum();
    	Integer advertStatus = advertSelDTO.getAdvertStatus();
    	String advertTheme = advertSelDTO.getAdvertTheme();
    	IPage<BsAdvertInf> page = new Page<>(currentPage,turnPageShowNum);
    	QueryWrapper<BsAdvertInf> queryWrapper = new QueryWrapper<>();
    	queryWrapper.eq(!StringUtils.isEmpty(advertStatus), "AI_ADV_STATUS", advertStatus)
    	.like(!StringUtils.isEmpty(advertTheme), "AI_ADV_THEME", advertTheme)
    	.orderByDesc("AI_ADV_UPDATE_TIME");
    	
    	page = bsAdvertInfService.page(page, queryWrapper);
    	advertSelOutPageDTO.setBannerList(page.getRecords())
    	.setCurrentPage(page.getCurrent())
    	.setTotalNum(page.getTotal())
    	.setTurnPageShowNum(page.getSize());
    	return advertSelOutPageDTO;
    }
    
    @Override
	public DelAdvertInfoOutDTO deleteAdvert(DelAdvertInfoDTO advertDTO) {
		DelAdvertInfoOutDTO outDTO = new DelAdvertInfoOutDTO();
		BsAdvertInf bsAdvertInf = new BsAdvertInf();
		Integer advId = bsAdvertInf.getAiAdvId();
		bsAdvertInfService.removeById(advId);
		return outDTO;	
	}

}
