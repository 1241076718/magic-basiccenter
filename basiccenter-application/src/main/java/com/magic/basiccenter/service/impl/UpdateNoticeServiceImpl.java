package com.magic.basiccenter.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.magic.application.infrastructure.service.dto.MagicDTO;
import com.magic.application.infrastructure.service.dto.MagicOutDTO;
import com.magic.basiccenter.dto.AppNoticeStateDTO;
import com.magic.basiccenter.dto.AppNoticeStateOutDTO;
import com.magic.basiccenter.model.dto.UpdateNoticeDTO;
import com.magic.basiccenter.model.dto.UpdateNoticeOutDTO;
import com.magic.basiccenter.model.service.UpdateNoticeService;
import com.magic.basiccenter.service.IBasicUpdateNoticeService;

@Component
public class UpdateNoticeServiceImpl implements IBasicUpdateNoticeService{
	@Autowired
	UpdateNoticeService service;
	@Override
	public MagicOutDTO<AppNoticeStateOutDTO> selectNoticeById(MagicDTO<AppNoticeStateDTO> requestDTO) {
		//1.返回DTO构造
		AppNoticeStateOutDTO appNoticeDTO = new AppNoticeStateOutDTO();
		MagicOutDTO<AppNoticeStateOutDTO> magicOutDTO = new MagicOutDTO<>();
		//2.获取请求数据
		AppNoticeStateDTO body = requestDTO.getBody();
		//3.根据id查询数据
		UpdateNoticeDTO updateNoticeDTO = new UpdateNoticeDTO();
		updateNoticeDTO.setNoticeId(body.getNoticeId());
		UpdateNoticeOutDTO notice = service.selectNoticeById(updateNoticeDTO);
		//4.数据存放在响应对象中
		appNoticeDTO.setNoticeName(notice.getNoticeName())
					.setNoticeText(notice.getNoticeText())
					.setRemindCount(notice.getRemindCount())
					.setRemindEndTime(notice.getRemindEndTime())
					.setRemindStartTime(notice.getRemindStartTime())
					.setRemindStatus(notice.getRemindStatus());
		magicOutDTO.setBody(appNoticeDTO);
		return magicOutDTO;
	}

	@Override
	public MagicOutDTO<AppNoticeStateOutDTO> updateNotice(MagicDTO<AppNoticeStateDTO> requestDTO) {
		//1.返回DTO构造
		AppNoticeStateOutDTO appNoticeOutDTO = new AppNoticeStateOutDTO();
		MagicOutDTO<AppNoticeStateOutDTO> magicOutDTO = new MagicOutDTO<>();
		//2.获取请求数据
		AppNoticeStateDTO body = requestDTO.getBody();
		//3.1构建实体对象
		UpdateNoticeDTO updateNoticeDTO = new UpdateNoticeDTO();
		updateNoticeDTO.setNoticeId(body.getNoticeId())
						.setNoticeName(body.getNoticeName())
						.setNoticeText(body.getNoticeText())
						.setRemindCount(body.getRemindCount())
						.setRemindEndTime(body.getRemindEndTime())
						.setRemindStartTime(body.getRemindStartTime())
						.setRemindStatus(body.getRemindStatus());
		service.updateNotice(updateNoticeDTO);
		//4.数据存放在响应对象中
		appNoticeOutDTO.setNoticeName(updateNoticeDTO.getNoticeName())
						.setNoticeText(updateNoticeDTO.getNoticeText())
						.setRemindCount(updateNoticeDTO.getRemindCount())
						.setRemindEndTime(updateNoticeDTO.getRemindEndTime())
						.setRemindStartTime(updateNoticeDTO.getRemindStartTime())
						.setRemindStatus(updateNoticeDTO.getRemindStatus());
		magicOutDTO.setBody(appNoticeOutDTO);
		return magicOutDTO;
	}

}
