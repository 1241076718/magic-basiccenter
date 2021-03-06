package com.magic.basiccenter.model.service;

import com.magic.basiccenter.dto.AddNoticeInfoInDTO;
import com.magic.basiccenter.dto.AddNoticeInfoOutDTO;
import com.magic.basiccenter.dto.entity.NoticeBean;
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
    List<NoticeBean> queryNotice(QueryNoticeDTO inputDTO);

    /**
     * 修改管理公告
     * @param requestDTO
     * @return
     * @author liubing1@belink.com
     */
    QueryNoticeOutDTO updateNotice(QueryNoticeDTO requestDTO);
    /**
     * 公告上下架、删除
     * @param inputDTO
     * @return
     */
    AddNoticeInfoOutDTO changeNoticeStatus(AddNoticeInfoInDTO inputDTO);

    /**
     * 查询公告总数
     * @param queryNoticeDTO
     * @return
     */
    Integer queryNoticeTotalNum(QueryNoticeDTO queryNoticeDTO);
}
