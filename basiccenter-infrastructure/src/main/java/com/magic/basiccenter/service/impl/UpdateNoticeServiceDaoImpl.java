package com.magic.basiccenter.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gift.core.utils.SpringContextUtils;
import com.magic.basiccenter.model.dto.UpdateNoticeDTO;
import com.magic.basiccenter.model.dto.UpdateNoticeOutDTO;
import com.magic.basiccenter.model.entity.Notice;
import com.magic.basiccenter.model.mapper.UpdateNoticeMapper;
import com.magic.basiccenter.model.service.IBsUpdateNoticeService;
import com.magic.basiccenter.model.service.UpdateNoticeService;
import com.magic.basiccenter.model.service.impl.BsUpdateNoticeServiceImpl;

@Service
public class UpdateNoticeServiceDaoImpl implements UpdateNoticeService{
	@Autowired
	private IBsUpdateNoticeService bsUpdateNoticeService;
	@Override
	public UpdateNoticeOutDTO selectNoticeById(UpdateNoticeDTO requestDTO) {
		UpdateNoticeOutDTO outDTO = new UpdateNoticeOutDTO();
		BsUpdateNoticeServiceImpl bean = SpringContextUtils.getBean(BsUpdateNoticeServiceImpl.class);
		UpdateNoticeMapper baseMapper = bean.getBaseMapper();
		Integer noticeId = requestDTO.getNoticeId();
		Notice notice = baseMapper.selectById(noticeId);
		outDTO.setNoticeName(notice.getNoticeName())
				.setNoticeText(notice.getNoticeText())
				.setRemindCount(notice.getRemindCount())
				.setRemindEndTime(notice.getRemindEndTime())
				.setRemindStartTime(notice.getRemindStartTime())
				.setRemindStatus(notice.getRemindStatus());
		return outDTO;
	}
	@Override
	public UpdateNoticeOutDTO updateNotice(UpdateNoticeDTO requestDTO) {
		UpdateNoticeOutDTO outDTO = new UpdateNoticeOutDTO();
		BsUpdateNoticeServiceImpl bean = SpringContextUtils.getBean(BsUpdateNoticeServiceImpl.class);
		UpdateNoticeMapper baseMapper = bean.getBaseMapper();
		Notice entity = new Notice();
		entity.setNoticeName(requestDTO.getNoticeName())
				.setNoticeId(requestDTO.getNoticeId())
				.setNoticeText(requestDTO.getNoticeText())
				.setRemindCount(requestDTO.getRemindCount())
				.setRemindEndTime(requestDTO.getRemindEndTime())
				.setRemindStartTime(requestDTO.getRemindStartTime())
				.setRemindStatus(requestDTO.getRemindStatus());
		//3.2.2修改数据库中的数据
		baseMapper.updateById(entity);
		//4.1获取数据库中数据
		Notice notice = baseMapper.selectById(requestDTO.getNoticeId());
		outDTO.setNoticeName(notice.getNoticeName())
				.setNoticeText(notice.getNoticeText())
				.setRemindCount(notice.getRemindCount())
				.setRemindEndTime(notice.getRemindEndTime())
				.setRemindStartTime(notice.getRemindStartTime())
				.setRemindStatus(notice.getRemindStatus());
		return outDTO;
	}
}
