package com.magic.basiccenter.service;

import com.magic.application.infrastructure.service.dto.MagicDTO;
import com.magic.application.infrastructure.service.dto.MagicOutDTO;
import com.magic.basiccenter.dto.*;

import java.util.List;

/**
 * 节假日管理服务
 */
public interface IFestivalService {


    /**
     * 新增
     * @param magicDTO
     * @return
     */
    MagicOutDTO<FestivalAddOutDTO> AddFestival(MagicDTO<FestivalAddDTO> magicDTO);


    /**
     * 查询节假日列表
     * @param magicDTO
     * @return
     */
    MagicOutDTO<FestivalQueryListOutDTO> QueryFestivalList(MagicDTO<FestivalQueryListDTO> magicDTO);



    /**
     * 根据节假日年份查询节假日列表
     * @param magicDTO
     * @return
     */
    MagicOutDTO<FestivalQueryListOutDTO> QueryFestival(MagicDTO<FestivalQueryDTO> magicDTO);



    /**
     * 删除指定节假日
     * @param magicDTO
     * @return
     */
    MagicOutDTO<FestivaldeleteOutDTO> DeleteFestival(MagicDTO<FestivaldeleteDTO> magicDTO);

    /**
     * 节假日修改日期冲突检查
     * @param magicDTO
     * @return
     */
    MagicOutDTO<FestivalManageModifyOutDTO> ModifyFestival(MagicDTO<FestivalManageModifyDTO> magicDTO);





}
