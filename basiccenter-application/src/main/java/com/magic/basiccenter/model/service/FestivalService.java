package com.magic.basiccenter.model.service;

import com.magic.application.infrastructure.service.dto.MagicDTO;
import com.magic.application.infrastructure.service.dto.MagicOutDTO;
import com.magic.application.infrastructure.service.dto.data.RespHeader;
import com.magic.basiccenter.dto.*;



/**
 * 节假日表交互服务
 * @Author YuJiaYu
 */
public interface FestivalService {



    /**
     * 向数据库添加一条节日信息
     * @param festivalAddDTO
     */
    void FestivalAdd(FestivalAddDTO festivalAddDTO);

    /**
     * 判断数据库中是否有指定节假日
     * @param festivalName
     * @param festivalYear
     * @return
     */
    Boolean FestivalSelectNameYear(String festivalName,String festivalYear);

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
     * 修改节假日信息
     * @param festivalModifyDTO
     * @return
     */
    RespHeader FestivalModify(FestivalManageModifyDTO festivalModifyDTO);



}
