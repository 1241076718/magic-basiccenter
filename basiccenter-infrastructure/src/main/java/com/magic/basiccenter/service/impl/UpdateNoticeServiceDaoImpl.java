package com.magic.basiccenter.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gift.core.utils.SpringContextUtils;
import com.magic.basiccenter.model.dto.QueryNoticeDTO;
import com.magic.basiccenter.model.dto.QueryNoticeOutDTO;
import com.magic.basiccenter.model.entity.CuNoticeInf;
import com.magic.basiccenter.model.mapper.CuNoticeStatusInfMapper;
import com.magic.basiccenter.model.service.IBsNoticeStatusInfService;
import com.magic.basiccenter.model.service.UpdateNoticeService;
import com.magic.basiccenter.model.service.impl.BsNoticeStatusInfServiceImpl;


@Service
public class UpdateNoticeServiceDaoImpl implements UpdateNoticeService{
	@Autowired
	private IBsNoticeStatusInfService bsUpdateNoticeService;
	@Override
	public QueryNoticeOutDTO updateNotice(QueryNoticeDTO requestDTO) {
		QueryNoticeOutDTO outDTO = new QueryNoticeOutDTO();
		BsNoticeStatusInfServiceImpl bean = SpringContextUtils.getBean(BsNoticeStatusInfServiceImpl.class);
		CuNoticeStatusInfMapper baseMapper = bean.getBaseMapper();
		CuNoticeInf entity = new CuNoticeInf();
//		entity.setNoticeName(requestDTO.getNoticeName())
//				.setNoticeId(requestDTO.getNoticeId())
//				.setNoticeText(requestDTO.getNoticeText())
//				.setRemindCount(requestDTO.getRemindCount())
//				.setRemindEndTime(requestDTO.getRemindEndTime())
//				.setRemindStartTime(requestDTO.getRemindStartTime())
//				.setRemindStatus(requestDTO.getRemindStatus());
		entity.setNiNtcName(requestDTO.getNiNtcName())
				.setNiNtcId(requestDTO.getNiNtcId())
				.setNiNtcText(requestDTO.getNiNtcText())
				.setNiNtcCount(requestDTO.getNiNtcCount())
				.setNiNtcEndTime(requestDTO.getNiNtcEndTime())
				.setNiNtcStartTime(requestDTO.getNiNtcStartTime())
				.setNiNtcStatus(requestDTO.getNiNtcStatus());
		//3.2.2修改数据库中的数据
		baseMapper.updateById(entity);
		//4.1获取数据库中数据
		CuNoticeInf notice = baseMapper.selectById(requestDTO.getNiNtcId());
//		outDTO.setNoticeName(notice.getNoticeName())
//				.setNoticeText(notice.getNoticeText())
//				.setRemindCount(notice.getRemindCount())
//				.setRemindEndTime(notice.getRemindEndTime())
//				.setRemindStartTime(notice.getRemindStartTime())
//				.setRemindStatus(notice.getRemindStatus());

		outDTO.setNiNtcName(notice.getNiNtcName())
				.setNiNtcText(notice.getNiNtcText())
				.setNiNtcCount(notice.getNiNtcCount())
				.setNiNtcEndTime(notice.getNiNtcEndTime())
				.setNiNtcStartTime(notice.getNiNtcStartTime())
				.setNiNtcStatus(notice.getNiNtcStatus());
		return outDTO;
	}
}
