package com.magic.basiccenter.service;

import com.magic.application.infrastructure.service.dto.MagicDTO;
import com.magic.application.infrastructure.service.dto.MagicOutDTO;
import com.magic.basiccenter.dto.AddNoticeInfoInDTO;
import com.magic.basiccenter.dto.AddNoticeInfoOutDTO;

public interface IAddNoticeService {

    /**
     * 添加公告信息
     * @param requestDTO
     * @return
     */

    MagicOutDTO<AddNoticeInfoOutDTO> addNoticeInfo(MagicDTO<AddNoticeInfoInDTO> requestDTO);

}
