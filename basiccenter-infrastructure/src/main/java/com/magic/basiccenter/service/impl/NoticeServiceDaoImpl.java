package com.magic.basiccenter.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gift.core.utils.SpringContextUtils;
import com.magic.basiccenter.model.dto.QueryNoticeDTO;
import com.magic.basiccenter.model.dto.QueryNoticeOutDTO;
import com.magic.basiccenter.model.mapper.CuNoticeInfMapper;
import com.magic.basiccenter.model.service.IBsNoticeInfService;
import com.magic.basiccenter.model.service.NoticeService;
import com.magic.basiccenter.model.service.impl.BsNoticeInfServiceImpl;

@Service
public class NoticeServiceDaoImpl implements NoticeService{

	@Autowired
	private IBsNoticeInfService bsNoticeInfService;

	@Override
	public List<QueryNoticeOutDTO> queryNotice(QueryNoticeDTO inputDTO) {
		QueryNoticeOutDTO outData = new QueryNoticeOutDTO();
		BsNoticeInfServiceImpl bean = SpringContextUtils.getBean(BsNoticeInfServiceImpl.class);
		CuNoticeInfMapper baseMapper = bean.getBaseMapper();
		List<QueryNoticeOutDTO> cuNoticeInfs = baseMapper.selectNotice(inputDTO);


		return cuNoticeInfs;
	}

}
