package com.magic.basiccenter.model.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.magic.basiccenter.dto.entity.NoticeBean;
import com.magic.basiccenter.model.dto.QueryNoticeDTO;
import com.magic.basiccenter.model.entity.BsNoticeInf;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @author ：goupc1@belink.com
 * @date ：Created in 2020/8/620 9:54
 * @description：  公告表Mapper 接口
 * @modified By：
 * @version: $1.0.0
 */
@Repository
public interface BsNoticeInfMapper extends BaseMapper<BsNoticeInf> {

    /**
     *查询公告mapper接口方法
     * @param dto
     * @return
     */
    List<NoticeBean>  selectNotice(QueryNoticeDTO dto);
    /**
     *查询公告总数mapper接口方法
     * @param queryNoticeDTO
     * @return
     */

    Integer queryNoticeTotalNum(QueryNoticeDTO queryNoticeDTO);
}
