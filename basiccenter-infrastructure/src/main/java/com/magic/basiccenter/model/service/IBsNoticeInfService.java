package com.magic.basiccenter.model.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.magic.basiccenter.dto.entity.NoticeBean;
import com.magic.basiccenter.model.dto.QueryNoticeDTO;
import com.magic.basiccenter.model.dto.QueryNoticeOutDTO;
import com.magic.basiccenter.model.entity.BsNoticeInf;

import java.util.List;


/**
 * @author ：goupc1@belink.com
 * @date ：Created in 2020/8/620 9:54
 * @description：  数据交互层服务接口
 * @modified By：
 * @version: $1.0.0
 */
public interface IBsNoticeInfService extends IService<BsNoticeInf>{

    /**
     * 查询公告方法
     *
     * @param queryNoticeDTO
     * @return
     */

    List<NoticeBean>  selectNotice(QueryNoticeDTO queryNoticeDTO);
    /**
     * 查询公告总数
     *
     * @param queryNoticeDTO
     * @return
     */

    Integer  queryNoticeTotalNum(QueryNoticeDTO queryNoticeDTO);

}
