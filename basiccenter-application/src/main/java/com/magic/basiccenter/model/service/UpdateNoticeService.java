package com.magic.basiccenter.model.service;

import com.magic.basiccenter.model.dto.UpdateNoticeDTO;
import com.magic.basiccenter.model.dto.UpdateNoticeOutDTO;

public interface UpdateNoticeService {
	public UpdateNoticeOutDTO selectNoticeById(UpdateNoticeDTO requestDTO);
	public UpdateNoticeOutDTO updateNotice(UpdateNoticeDTO requestDTO);
}
