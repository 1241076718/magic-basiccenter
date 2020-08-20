package com.magic.basiccenter.service;

import com.magic.application.infrastructure.service.dto.MagicDTO;
import com.magic.application.infrastructure.service.dto.MagicOutDTO;
import com.magic.basiccenter.dto.AdvertSelDTO;
import com.magic.basiccenter.dto.AdvertSelOutPageDTO;
import com.magic.basiccenter.dto.SysAdvertInfoDTO;

public interface IAdvertSelCond{
	public MagicOutDTO<AdvertSelOutPageDTO> advertSelCond (MagicDTO<AdvertSelDTO> requestDTO);
}
