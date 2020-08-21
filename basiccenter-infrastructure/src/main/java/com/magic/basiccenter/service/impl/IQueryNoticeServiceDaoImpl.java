package com.magic.basiccenter.service.impl;

import com.gift.core.utils.SpringContextUtils;
import com.magic.basiccenter.model.dto.QueryNoticeDTO;
import com.magic.basiccenter.model.dto.QueryNoticeOutDTO;
import com.magic.basiccenter.model.mapper.CuNoticeInfMapper;
import com.magic.basiccenter.model.service.IBsNoticeInfService;
import com.magic.basiccenter.model.service.IQueryNoticeService;
import com.magic.basiccenter.model.service.impl.BsNoticeInfServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class IQueryNoticeServiceDaoImpl implements IQueryNoticeService {

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