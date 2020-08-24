package com.magic.basiccenter.model.service;

import com.magic.basiccenter.dto.AddNoticeInfoInDTO;
import com.magic.basiccenter.dto.AddNoticeInfoOutDTO;
import com.magic.basiccenter.dto.QueryNoticeInfoInDTO;
import com.magic.basiccenter.model.dto.QueryNoticeDTO;
import com.magic.basiccenter.model.dto.QueryNoticeOutDTO;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: GPC
 * Date: 2020/08/21 14:00
 * Description:
 * Version: V1.0
 */
public interface INoticeService {


    /**
     *
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
     * 公告上下架、删除
     * @param inputDTO
     * @return
     */
    QueryNoticeOutDTO changeNoticeStatus(QueryNoticeInfoInDTO inputDTO);


    


}