package com.magic.basiccenter.service;

import com.magic.application.infrastructure.service.dto.MagicDTO;
import com.magic.application.infrastructure.service.dto.MagicOutDTO;
import com.magic.basiccenter.dto.*;

import java.util.List;

/**
 * 节假日管理服务
 */
public interface IFestivalService {



    MagicOutDTO<FestivalAddOutDTO> AddFestival(MagicDTO<FestivalAddDTO> magicDTO);
    /**
     * 查询节假日列表
     * @param
     * @return
     */
    MagicDTO<List<FestivalQueryListOutDTO>> queryFestivalList();

    /**
     * 根据节假日年份查询节假日列表
     * @param festivalYear 节假日年份
     * @return
     */
    MagicDTO<List<FestivalQueryListOutDTO>> accordingFestivalYearQueryFestivalList(String festivalYear);


    /**
     * 删除
     * @param requsetDTO
     * @return
     */
    MagicOutDTO<FestivaldeleteOutDTO> DeleteFestival(MagicDTO<FestivaldeleteDTO> requsetDTO);

    /**
     * 节假日修改日期冲突检查
     * @param magicDTO
     * @return
     */
    MagicOutDTO<FestivalManageModifyOutDTO> festivalManageModify(MagicDTO<FestivalManageModifyDTO> magicDTO);


}
