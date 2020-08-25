package com.magic.basiccenter.model.service;

import com.magic.basiccenter.dto.AddNoticeInfoInDTO;
import com.magic.basiccenter.dto.AddNoticeInfoOutDTO;
import com.magic.basiccenter.dto.QueryNoticeInfoDTO;
import com.magic.basiccenter.model.dto.QueryNoticeDTO;
import com.magic.basiccenter.model.dto.QueryNoticeOutDTO;

import java.util.List;

/**
 * @author ：goupc1@belink.com
 * @date ：Created in 2020/8/620 9:54
 * @description：  应用层服务接口
 * @modified By：
 * @version: $1.0.0
 */
public interface NoticeAppService {


    /**
     *新增公告
     * @param inputDTO
     * @return
     */

    AddNoticeInfoOutDTO addNotice(AddNoticeInfoInDTO inputDTO);

    /**
     *查询公告方法
     * @param inputDTO
     * @return
     */
    List<QueryNoticeOutDTO> queryNotice(QueryNoticeDTO inputDTO);

    /**
     * 修改管理公告
     * @param requestDTO
     * @return
     */
    QueryNoticeOutDTO updateNotice(QueryNoticeDTO requestDTO);
    /**
     *
     * @param inputDTO
     * @return
     */
    QueryNoticeOutDTO changeNoticeStatus(QueryNoticeInfoDTO inputDTO);


    


}
