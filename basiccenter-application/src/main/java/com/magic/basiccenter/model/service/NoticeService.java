package com.magic.basiccenter.model.service;


import com.magic.basiccenter.model.dto.QueryNoticeDTO;
import com.magic.basiccenter.model.dto.QueryNoticeOutDTO;

import java.util.List;

/**
 * 公告表数据交互服务
 * @author huangmm
 *
 */
public interface NoticeService {

	public List<QueryNoticeOutDTO> queryNotice(QueryNoticeDTO inputDTO);
	
}
