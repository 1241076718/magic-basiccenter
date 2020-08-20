package com.magic.basiccenter.model.service;

import com.magic.basiccenter.dto.AddNoticeInfoInDTO;
import com.magic.basiccenter.dto.AddNoticeInfoOutDTO;

/**
 * 公告表数据交互服务
 * @author huangmm
 *
 */
public interface AddNoticeService {

    public AddNoticeInfoOutDTO addNotice(AddNoticeInfoInDTO inputDTO);

}
