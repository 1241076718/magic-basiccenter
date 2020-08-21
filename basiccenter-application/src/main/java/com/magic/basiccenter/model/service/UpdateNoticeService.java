package com.magic.basiccenter.model.service;

import com.magic.basiccenter.model.dto.QueryNoticeDTO;
import com.magic.basiccenter.model.dto.QueryNoticeOutDTO;

public interface UpdateNoticeService {
	public QueryNoticeOutDTO updateNotice(QueryNoticeDTO requestDTO);
}
