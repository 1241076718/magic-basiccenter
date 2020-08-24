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
    void FestivalAdd(FestivalManageInf festivalManageInf);

    /**
     * 判断数据库中是否有指定节假日
     * @param festivalName
     * @param festivalYear
     * @return
     */
    List<FestivalManageInf> FestivalSelectNameYear(String festivalName,String festivalYear);

    /**
     * 查询当前库中所有节假日信息
     */
    FestivalQueryListOutDTO FestivalQuery();


    /**
     * 根据节假日年份查询节假日列表
     * @param year
     * @return
     */
    FestivalQueryListOutDTO FestivalQueryForYear(String year);


    /**
     * 删除节假日
     * @param deleteDTO
     * @return
     */
    MagicOutDTO<FestivaldeleteOutDTO> FestivalDelete(MagicDTO<FestivaldeleteDTO> deleteDTO);


    /**
     * 根据Id判断被修改节假日安排是否有效
     * @param festivalId
     * @return
     */
    FestivalManageInf FestivalModifySelectId(String festivalId);


    /**
     * 获取所有有效的节假日安排的日期数据(大于当前系统日期)
     * @param nowDate
     * @return
     */
    List<FestivalManageInf> FestivalModifySelectList(Date nowDate);


    /**
     * 修改数据库对应数据
     * @param updateFestivalInf
     * @param festivalId
     */
    void FestivalModifyUpdata(FestivalManageInf updateFestivalInf, String festivalId);


}
