package com.magic.basiccenter.model.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.magic.basiccenter.model.entity.FestivalManageInf;
import org.apache.ibatis.annotations.Mapper;

/**
 * 节假日管理信息表Mapper接口
 */
@Mapper
public interface FestManageMapper extends BaseMapper<FestivalManageInf> {

}
