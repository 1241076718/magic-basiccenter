package com.magic.basiccenter.service;

import com.magic.application.infrastructure.service.dto.MagicDTO;
import com.magic.application.infrastructure.service.dto.MagicOutDTO;
import com.magic.basiccenter.dto.*;

/**
 * @author ：wzr
 * @date ：Created in 2020/7/6 9:54
 * @description：企业操作员信息管理
 * @modified By：
 * @version: $
 */
public interface IBasicService {


    /**
     * 查询公告接口
     *
     * @param requestDTO
     * @return
     */
    MagicOutDTO<QueryNoticeInfoOutDTO>  queryNoticeList(MagicDTO<QueryNoticeInfoInDTO>  requestDTO);





    /**
     * 修改公告
     * @param requestDTO
     * @return
     */
    MagicOutDTO<UpdateNoticeInfoOutDTO> updateNotice(MagicDTO<QueryNoticeInfoInDTO> requestDTO);


    /**
     * 添加公告信息
     * @param requestDTO
     * @return
     */

    MagicOutDTO<AddNoticeInfoOutDTO> addNoticeInfo(MagicDTO<AddNoticeInfoInDTO> requestDTO);

    /**
     * 公告上架下架
     * @param requestDTO
     * @return
     */
    MagicOutDTO<QueryNoticeInfoOutDTO> changeNoticeStatus(MagicDTO<QueryNoticeInfoInDTO> requestDTO);




}