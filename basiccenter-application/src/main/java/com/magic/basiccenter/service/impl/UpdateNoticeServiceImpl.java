package com.magic.basiccenter.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.magic.application.infrastructure.service.dto.MagicDTO;
import com.magic.application.infrastructure.service.dto.MagicOutDTO;
import com.magic.basiccenter.dto.QueryNoticeInfoInDTO;
import com.magic.basiccenter.dto.UpdateNoticeInfoOutDTO;
import com.magic.basiccenter.model.dto.QueryNoticeDTO;
import com.magic.basiccenter.model.service.UpdateNoticeService;
import com.magic.basiccenter.service.IBasicUpdateNoticeService;

@Component
public class UpdateNoticeServiceImpl implements IBasicUpdateNoticeService{
	@Autowired
	UpdateNoticeService service;
	@Override
	public MagicOutDTO<UpdateNoticeInfoOutDTO> updateNotice(MagicDTO<QueryNoticeInfoInDTO> requestDTO) {
		//1.返回DTO构造
		UpdateNoticeInfoOutDTO appNoticeOutDTO = new UpdateNoticeInfoOutDTO();
		MagicOutDTO<UpdateNoticeInfoOutDTO> magicOutDTO = new MagicOutDTO<>();
		//2.获取请求数据
		QueryNoticeInfoInDTO body = requestDTO.getBody();
		//3.1构建实体对象
		QueryNoticeDTO updateNoticeDTO = new QueryNoticeDTO();
//		updateNoticeDTO.setNoticeId(body.getNoticeId())
//						.setNoticeName(body.getNoticeName())
//						.setNoticeText(body.getNoticeText())
//						.setRemindCount(body.getRemindCount())
//						.setRemindEndTime(body.getRemindEndTime())
//						.setRemindStartTime(body.getRemindStartTime())
//						.setRemindStatus(body.getRemindStatus());
		updateNoticeDTO.setNiNtcId(body.getNiNtcId())
						.setNiNtcName(body.getNiNtcName())
						.setNiNtcText(body.getNiNtcText())
						.setNiNtcCount(body.getNiNtcCount())
						.setNiNtcEndTime(body.getNiNtcEndTime())
						.setNiNtcStartTime(body.getNiNtcStartTime())
						.setNiNtcStatus(body.getNiNtcStatus());
		service.updateNotice(updateNoticeDTO);
		//4.数据存放在响应对象中
//		appNoticeOutDTO.setNoticeName(updateNoticeDTO.getNoticeName())
//						.setNoticeText(updateNoticeDTO.getNoticeText())
//						.setRemindCount(updateNoticeDTO.getRemindCount())
//						.setRemindEndTime(updateNoticeDTO.getRemindEndTime())
//						.setRemindStartTime(updateNoticeDTO.getRemindStartTime())
//						.setRemindStatus(updateNoticeDTO.getRemindStatus());
		appNoticeOutDTO.setNiNtcName(updateNoticeDTO.getNiNtcName())
						.setNiNtcText(updateNoticeDTO.getNiNtcText())
						.setNiNtcRemindStatus(updateNoticeDTO.getNiNtcStatus())
						.setNiNtcCount(updateNoticeDTO.getNiNtcCount())
						.setNiNtcStartTime(updateNoticeDTO.getNiNtcStartTime())
						.setNiNtcEndTime(updateNoticeDTO.getNiNtcEndTime());
		magicOutDTO.setBody(appNoticeOutDTO);
		return magicOutDTO;
	}

}
