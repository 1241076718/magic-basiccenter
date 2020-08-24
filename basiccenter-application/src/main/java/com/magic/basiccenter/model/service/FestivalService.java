package com.magic.basiccenter.model.service;

import com.magic.application.infrastructure.service.dto.MagicDTO;
import com.magic.application.infrastructure.service.dto.MagicOutDTO;
import com.magic.basiccenter.dto.*;
import com.magic.basiccenter.entity.FestivalManageInf;

import java.util.Date;
import java.util.List;

/**
 * 节假日表交互服务
 */
public interface FestivalService {

    /**
     * 向数据库添加一条节日信息
     * @param festivalManageInf
     */
    FestivalAddOutDTO FestivalAdd(FestivalManageInf festivalManageInf);

    /**
     * 查询当前库中所有节假日信息
     */
    FestivalQueryListOutDTO FestivalQuery();

    /**
     * 根据节假日年份查询节假日列表
     */
    FestivalQueryListOutDTO FestivalQueryForYear(String year);

    /**
     * 删除节假日
     */
    MagicOutDTO<FestivaldeleteOutDTO> FestivalDelete(MagicDTO<FestivaldeleteDTO> deleteDTO);

    /**
     * 根据Id判断被修改节假日安排是否有效
     */
    FestivalManageInf FestivalModifySelectId(String festivalId);


    /**
     *
     * @param nowDate
     * @return
     */
    List<FestivalManageInf> FestivalModifySelectList(Date nowDate);


    void FestivalModifyUpdata(FestivalManageInf updateFestivalInf, String festivalId);




}
