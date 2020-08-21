package com.magic.basiccenter.model.service;

import com.magic.basiccenter.dto.AddNoticeInfoInDTO;
import com.magic.basiccenter.dto.AddNoticeInfoOutDTO;
import com.magic.basiccenter.dto.QueryNoticeInfoInDTO;
import com.magic.basiccenter.dto.QueryNoticeInfoOutDTO;
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


    AddNoticeInfoOutDTO addNotice(AddNoticeInfoInDTO inputDTO);


    List<QueryNoticeOutDTO> queryNotice(QueryNoticeDTO inputDTO);


    QueryNoticeOutDTO changeNoticeStatus(QueryNoticeInfoInDTO inputDTO);


    QueryNoticeOutDTO updateNotice(QueryNoticeDTO requestDTO);


}
