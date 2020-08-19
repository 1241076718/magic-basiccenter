package com.magic.basiccenter.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.magic.application.infrastructure.service.dto.MagicDTO;
import com.magic.application.infrastructure.service.dto.MagicOutDTO;
import com.magic.basiccenter.application.error.FestivalModifyMessageEnum;
import com.magic.basiccenter.dto.FestivalModifyDTO;
import com.magic.basiccenter.dto.FestivalModifyOutDTO;
import com.magic.basiccenter.dto.entity.FestivalManageInf;
import com.magic.basiccenter.model.mapper.FestivalDateChackMapper;
import com.magic.basiccenter.service.IFestivalService;

import lombok.extern.slf4j.Slf4j;

/**
 * 节假日管理Server实现类
 * 
 * @author LEI
 *
 */
@Service
@Slf4j
public class FestivalDateChackServiceImpl implements IFestivalService {
	
	@Autowired
	FestivalDateChackMapper festivalDateChackMapper;
	
	/**
	 * 节假日修改日期冲突检查
	 */
	@Override
	public MagicOutDTO<FestivalModifyOutDTO> FestivalDateChack(MagicDTO<FestivalModifyDTO> magicDTO) {
		// 获取输入类
		FestivalModifyDTO festivalModifyDTO = magicDTO.getBody();
		//获取输出类
		FestivalModifyOutDTO festivalModifyOutDTO = new FestivalModifyOutDTO();
		System.out.println(festivalModifyDTO);
		if (festivalModifyDTO==null) {
			festivalModifyOutDTO.setStatus(FestivalModifyMessageEnum.FAIL_FESTIVAL_INVALID.getStatus());
			festivalModifyOutDTO.setInf(FestivalModifyMessageEnum.FAIL_FESTIVAL_INVALID.getInf());
			return new MagicOutDTO<>(festivalModifyOutDTO);
		}
		// 获取被修改节假日安排的Id
		Integer festivalId = festivalModifyDTO.getFestivalId();
		// 根据Id判断被修改节假日安排是否有效
		FestivalManageInf oldFestival = festivalDateChackMapper.selectById(festivalId);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String format = sdf.format(new Date());
		Date nowDate = null;
		try {
			nowDate = sdf.parse(format);
			if(oldFestival.getFestivalStartTime().getTime()<=nowDate.getTime()){
				//获取的节假日开始的时间比当前系统时间小或相等(不能修改,选择的节假日无效)
				festivalModifyOutDTO.setStatus(FestivalModifyMessageEnum.FAIL_FESTIVAL_INVALID.getStatus());
				festivalModifyOutDTO.setInf(FestivalModifyMessageEnum.FAIL_FESTIVAL_INVALID.getInf());
				return new MagicOutDTO<>(festivalModifyOutDTO);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		// 获取节假日修改日期数据
		String festivalDeploy = festivalModifyDTO.getFestivalDeploy();
		String[] festivalArr = festivalDeploy.split(",");
		Date festivalStartDate =null;
		Date festivalEndDate = null;
		try {
			festivalStartDate = sdf.parse(festivalArr[0]);
			festivalEndDate = sdf.parse(festivalArr[festivalArr.length-1]);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		// 获取所有有效的节假日安排的日期数据(大于当前系统日期)
		QueryWrapper<FestivalManageInf> QueryWrapper = new QueryWrapper<>();
		List<FestivalManageInf> selectList = festivalDateChackMapper.selectList(QueryWrapper.gt("FESTIVAL_START_TIME", nowDate));
		// 判断节假日修改日期是否与其他日期冲突
		for (FestivalManageInf festivalRawDataDate : selectList) {
			// 不冲突：修改成功
			if(festivalRawDataDate.getFestivalStartTime().getTime()>festivalEndDate.getTime()||festivalRawDataDate.getFestivalEndTime().getTime()<festivalStartDate.getTime()) {
				// 获取节假日修改其他数据
				// 将数据修改至数据库
				FestivalManageInf updateFestivalInf = new FestivalManageInf();
				updateFestivalInf.setFestivalId(festivalId.toString());
				updateFestivalInf.setFestivalDeploy(festivalDeploy);
				updateFestivalInf.setFestivalName(festivalModifyDTO.getFestivalName());
				festivalDateChackMapper.update(updateFestivalInf, QueryWrapper.eq("FESTIVAL_ID", festivalId.toString()));
			}else {
				// 冲突：修改失败
				festivalModifyOutDTO.setStatus(FestivalModifyMessageEnum.FAIL_FESTIVAL_CONFLICT.getStatus());
				festivalModifyOutDTO.setInf(FestivalModifyMessageEnum.FAIL_FESTIVAL_CONFLICT.getInf());
				return new MagicOutDTO<>(festivalModifyOutDTO);
			}
		}
		// 返回修改成功
		festivalModifyOutDTO.setStatus(FestivalModifyMessageEnum.SUCCESS.getStatus());
		festivalModifyOutDTO.setInf(FestivalModifyMessageEnum.SUCCESS.getInf());
		return new MagicOutDTO<>(festivalModifyOutDTO);
	}

}
