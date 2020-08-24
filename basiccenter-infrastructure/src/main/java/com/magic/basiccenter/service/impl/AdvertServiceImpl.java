package com.magic.basiccenter.service.impl;

import com.gift.domain.sequence.factory.SequenceFactory;
import com.magic.basiccenter.constants.Constant;
import com.magic.basiccenter.dto.AdvertInfBean;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.magic.basiccenter.model.dto.AddAdvertInfoDTO;
import com.magic.basiccenter.model.dto.AddAdvertInfoOutDTO;
import com.magic.basiccenter.model.dto.DelAdvertInfoDTO;
import com.magic.basiccenter.model.dto.DelAdvertInfoOutDTO;
import com.magic.basiccenter.model.dto.SelAdvertInfoDTO;
import com.magic.basiccenter.model.dto.SelAdvertInfoOutDTO;
import com.magic.basiccenter.model.dto.UpdAdvertInfoDTO;
import com.magic.basiccenter.model.dto.UpdAdvertInfoOutDTO;
import com.magic.basiccenter.model.entity.BsAdvertInf;
import com.magic.basiccenter.model.service.IAdvertService;
import com.magic.basiccenter.model.service.IBsAdvertInfService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
	 * 序列号生成工具
	 */
	@Autowired
	private SequenceFactory sequenceFactory;

    /**
     * 广告配置数据对应实体服务
     */
    @Autowired
    private IBsAdvertInfService bsAdvertInfService;

	/**
	 * 广告配置表数据新增
	 * @param inputDTO
	 * @return
	 * @author laiqx@belink.com
	 */
	@Override
    public AddAdvertInfoOutDTO addAdvertInfo(AddAdvertInfoDTO inputDTO) {
        AddAdvertInfoOutDTO outData = new AddAdvertInfoOutDTO();

        BsAdvertInf bsAdvertInf = new BsAdvertInf();
        BeanUtils.copyProperties(inputDTO, bsAdvertInf);
		String aiAdvId = sequenceFactory.getSegmentFillZeroId(Constant.ADVERT_ID_TAG);
		bsAdvertInf.setAiAdvId(aiAdvId);
        bsAdvertInf.setAiAdvCreateTime(LocalDateTime.now()).setAiAdvUpdateTime(LocalDateTime.now());
        bsAdvertInfService.save(bsAdvertInf);

        return outData;
    }

	/**
	 * 广告列表查询
	 * @param selAdvertInfoDTO
	 * @return
	 * @author jianggq@belink.com
	 */
	@Override
    public SelAdvertInfoOutDTO selAdvertInfo(SelAdvertInfoDTO selAdvertInfoDTO) {
		//构建返回对象
		SelAdvertInfoOutDTO selAdvertInfoOutDTO = new SelAdvertInfoOutDTO();

		//获取分页参数
		long currentPage = selAdvertInfoDTO.getCurrentPage();
		long turnPageShowNum = selAdvertInfoDTO.getTurnPageShowNum();
		Integer advertStatus = selAdvertInfoDTO.getAdvertStatus();
		String advertTheme = selAdvertInfoDTO.getAdvertTheme();

		//构建分页对象
		IPage<BsAdvertInf> page = new Page<>(currentPage,turnPageShowNum);
		LambdaQueryWrapper<BsAdvertInf> queryWrapper = new LambdaQueryWrapper<>();
		//构建条件查询
		if (!StringUtils.isEmpty(advertStatus)) {
			queryWrapper
					.eq(BsAdvertInf::getAiAdvStatus, advertStatus)
					.like(!StringUtils.isEmpty(advertTheme), BsAdvertInf::getAiAdvTheme, advertTheme)
					.orderByDesc(BsAdvertInf::getAiAdvUpdateTime);
		} else {
			queryWrapper
					.ne(BsAdvertInf::getAiAdvStatus, Constant.ADVERT_DELETE_STATUS_CODE)
					.like(!StringUtils.isEmpty(advertTheme), BsAdvertInf::getAiAdvTheme, advertTheme)
					.orderByDesc(BsAdvertInf::getAiAdvUpdateTime);
		}
		//执行查询
		page = bsAdvertInfService.page(page, queryWrapper);

		//对返回对象赋值
		List<BsAdvertInf> records = page.getRecords();
		List<AdvertInfBean> bannerList = new ArrayList<>(records.size());
		for (BsAdvertInf bsAdvertInf : records) {
			AdvertInfBean tempBean = new AdvertInfBean();
			BeanUtils.copyProperties(bsAdvertInf, tempBean);
			bannerList.add(tempBean);
		}
		selAdvertInfoOutDTO.setBannerList(bannerList)
				.setCurrentPage(page.getCurrent())
				.setTotalNum(page.getTotal())
				.setTurnPageTotalNum(page.getSize());

		return selAdvertInfoOutDTO;
    }

	/**
	 * 通过主键id删除广告(逻辑删除，将广告状态置为3)
	 * @param advertDelDTO
	 * @return
	 * @author tangw@belink.com
	 */
	@Override
	public DelAdvertInfoOutDTO delAdvertInfo(DelAdvertInfoDTO advertDelDTO) {
		DelAdvertInfoOutDTO outDTO = new DelAdvertInfoOutDTO();

		BsAdvertInf bsAdvertInf = new BsAdvertInf();
		BeanUtils.copyProperties(advertDelDTO, bsAdvertInf);
		bsAdvertInf.setAiAdvStatus(Constant.ADVERT_DELETE_STATUS_CODE).setAiAdvUpdateTime(LocalDateTime.now());
		bsAdvertInfService.updateById(bsAdvertInf);

		return outDTO;
	}

	/**
	 * 广告配置表数据修改
	 * @param updDTO
	 * @return
	 * @author luolf@belink.com
	 */
	@Override
	public UpdAdvertInfoOutDTO updAdvertInfo(UpdAdvertInfoDTO updDTO) {
		UpdAdvertInfoOutDTO  updOutDate= new UpdAdvertInfoOutDTO();

		BsAdvertInf bsAdvertInf = new BsAdvertInf();
		bsAdvertInf.setAiAdvUpdateTime(LocalDateTime.now());
		BeanUtils.copyProperties(updDTO, bsAdvertInf);
		bsAdvertInfService.updateById(bsAdvertInf);

		return updOutDate;
	}

}
