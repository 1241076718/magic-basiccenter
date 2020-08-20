package com.magic.basiccenter.service;

import com.magic.application.infrastructure.service.dto.MagicDTO;
import com.magic.application.infrastructure.service.dto.MagicOutDTO;
import com.magic.basiccenter.dto.AppNoticeStateDTO;
import com.magic.basiccenter.dto.AppNoticeStateOutDTO;

/**
 * @description:公告修改管理
 * @author: liubing
 * @create: 2020-08-18
 */
public interface IBasicUpdateNoticeService {
	/**
	 * 查询一条数据
	 * @param requestDTO
	 * @return
	 */
	MagicOutDTO<AppNoticeStateOutDTO> selectNoticeById(MagicDTO<AppNoticeStateDTO> requestDTO);
	/**
	 * 修改公告
	 * @param requestDTO
	 * @return
	 */
	MagicOutDTO<AppNoticeStateOutDTO> updateNotice(MagicDTO<AppNoticeStateDTO> requestDTO);
}
