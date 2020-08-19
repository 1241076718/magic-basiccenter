package com.magic.basiccenter.service;

import com.magic.application.infrastructure.service.dto.MagicDTO;
import com.magic.application.infrastructure.service.dto.MagicOutDTO;
import com.magic.basiccenter.dto.FestivalModifyDTO;
import com.magic.basiccenter.dto.FestivalModifyOutDTO;

/**
 * 节假日管理Server
 * @author LEI
 *
 */
public interface IFestivalService {
	
	/**
	 * 节假日修改日期冲突检查
	 * @param magicDTO
	 * @return
	 */
	public MagicOutDTO<FestivalModifyOutDTO> FestivalDateChack(MagicDTO<FestivalModifyDTO> magicDTO);

}
