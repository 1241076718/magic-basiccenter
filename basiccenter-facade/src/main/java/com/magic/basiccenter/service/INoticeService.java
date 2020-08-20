package com.magic.basiccenter.service;

import com.magic.application.infrastructure.service.dto.MagicDTO;
import com.magic.application.infrastructure.service.dto.MagicOutDTO;
import com.magic.basiccenter.dto.QueryNoticeInfoInDTO;
import com.magic.basiccenter.dto.QueryNoticeInfoOutDTO;

/**
 * @author ：wzr
 * @date ：Created in 2020/7/6 9:54
 * @description：企业操作员信息管理
 * @modified By：
 * @version: $
 */
public interface INoticeService {


    /**
     * 查询接口
     *
     * @param requestDTO
     * @return
     */
    MagicOutDTO<QueryNoticeInfoOutDTO> queryOperatorList4CustId(MagicDTO<QueryNoticeInfoInDTO> requestDTO);





    MagicOutDTO<QueryNoticeInfoOutDTO> querynoticeinfo();





    /**
     * 网银根据客户id查询操作员列表
     *
     * @param requestDTO
     * @return
     */


}