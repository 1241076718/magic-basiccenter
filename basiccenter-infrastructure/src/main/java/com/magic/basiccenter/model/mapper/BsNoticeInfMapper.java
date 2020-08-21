package com.magic.basiccenter.model.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.magic.basiccenter.model.dto.QueryNoticeDTO;
import com.magic.basiccenter.model.dto.QueryNoticeOutDTO;
import com.magic.basiccenter.model.entity.BsNoticeInf;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 用户信息变更流水表 Mapper 接口
 * </p>
 *
 * @author yangquan
 * @since 2020-05-19
 */

@Repository
public interface BsNoticeInfMapper extends BaseMapper<BsNoticeInf> {

    List<QueryNoticeOutDTO>  selectNotice(QueryNoticeDTO dto);


}
