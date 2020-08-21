package com.magic.basiccenter.service;

import com.magic.application.infrastructure.service.dto.MagicDTO;
import com.magic.application.infrastructure.service.dto.MagicOutDTO;
import com.magic.basiccenter.dto.QueryNoticeInfoInDTO;
import com.magic.basiccenter.dto.UpdateNoticeInfoOutDTO;

/**
 * @description:公告修改管理
 * @author: liubing
 * @create: 2020-08-18
 */
public interface IBasicUpdateNoticeService {
	/**
	 * 修改公告
	 * @param requestDTO
	 * @return
	 */
	MagicOutDTO<UpdateNoticeInfoOutDTO> updateNotice(MagicDTO<QueryNoticeInfoInDTO> requestDTO);
}
