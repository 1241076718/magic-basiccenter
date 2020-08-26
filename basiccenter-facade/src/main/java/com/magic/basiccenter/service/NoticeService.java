package com.magic.basiccenter.service;

import com.magic.application.infrastructure.service.dto.MagicDTO;
import com.magic.application.infrastructure.service.dto.MagicOutDTO;
import com.magic.basiccenter.dto.*;

/**
 * @author ：goupc1@belink.com
 * @date ：Created in 2020/8/620 9:54
 * @description：  对外暴露业务层接口
 * @modified By：
 * @version: $1.0.0
 */
public interface NoticeService {





    /**
     * 查询公告接口方法
     * @param requestDTO
     * @return
     */
    MagicOutDTO<QueryNoticeInfoOutDTO>  queryNoticeList(MagicDTO<QueryNoticeInfoDTO>  requestDTO);





    /**
     * 修改公告方法
     * @param requestDTO
     * @return
     */
    MagicOutDTO<UpdateNoticeInfoOutDTO> updateNotice(MagicDTO<QueryNoticeInfoDTO> requestDTO);


    /**
     * 添加公告方法
     * @param requestDTO
     * @return
     */
    MagicOutDTO<AddNoticeInfoOutDTO> addNoticeInfo(MagicDTO<AddNoticeInfoInDTO> requestDTO);


    /**
     * 公告上架下架方法
     * @param requestDTO
     * @return
     */
    MagicOutDTO<AddNoticeInfoOutDTO> changeNoticeStatus(MagicDTO<AddNoticeInfoInDTO> requestDTO);




}