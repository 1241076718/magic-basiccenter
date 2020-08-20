package com.magic.basiccenter.model.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.magic.application.infrastructure.service.dto.MagicDTO;
import com.magic.basiccenter.dto.QueryNoticeInfoInDTO;
import com.magic.basiccenter.model.dto.QueryNoticeDTO;
import com.magic.basiccenter.model.entity.CuNoticeInf;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
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
public interface CuNoticeInfMapper extends BaseMapper<CuNoticeInf> {

    List<CuNoticeInf>  selectNotice(QueryNoticeDTO dto);


}
