package com.magic.basiccenter.model.service;

import com.magic.basiccenter.dto.QueryNoticeInfoInDTO;
import com.magic.basiccenter.dto.QueryNoticeInfoOutDTO;


public interface NoticeStatusService {
    QueryNoticeInfoOutDTO changeNoticeStatus(QueryNoticeInfoInDTO inputDTO);

}
