package com.magic.basiccenter.controller;

import com.magic.application.infrastructure.service.dto.MagicDTO;
import com.magic.application.infrastructure.service.dto.MagicOutDTO;
import com.magic.basiccenter.dto.*;
import com.magic.basiccenter.service.impl.FestivalManageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * <p>基础中心--控制器</P>
 *
 * @author FestivalGroup
 * @version 0.0.1
 * @className festivalController
 * @sine 2020/8/17 9:13
 */
@RestController
@Slf4j
public class FestivalController {

    @Autowired
    private FestivalManageService festivalManageService;


    /**
     * 节假日管理--新增
     * @param magicDTO
     * @return
     */
    @PostMapping("/festival/festivalAdd")
    public MagicOutDTO<FestivalAddOutDTO> festivalAdd(@RequestBody MagicDTO<FestivalAddDTO> magicDTO){
        return festivalManageService.addFestival(magicDTO);
    }


    /**
     * 节假日管理 --返回指定年份的节假日列表
     * @param magicDTO
     * @return
     */
    @PostMapping("/festival/festivalGetList")
    public MagicOutDTO<FestivalQueryListOutDTO> festivalList(@RequestBody MagicDTO<FestivalQueryListDTO> magicDTO){
        return festivalManageService.queryFestivalList(magicDTO);

    }

    /**
     * 节假日管理--选出当前年份的节假日信息
     * @param magicDTO
     * @return
     */
    @PostMapping("/festival/festivalGet")
    public MagicOutDTO<FestivalQueryListOutDTO> festivalYear(@RequestBody MagicDTO<FestivalQueryDTO> magicDTO){
        return festivalManageService.queryFestival(magicDTO);
    }


    /**
     * 节假日管理--删除
     * @param deleteDTO
     * @return
     */
    @PostMapping("/festival/festivalDelete")
    public MagicOutDTO<FestivaldeleteOutDTO> festivalDelete(@RequestBody MagicDTO<FestivaldeleteDTO> deleteDTO){
        return festivalManageService.deleteFestival(deleteDTO);
    }


    /**
     * 节假日管理--修改
     * @param magicDTO
     * @return
     */
    @PostMapping("/festival/festivalModify")
    public MagicOutDTO<FestivalModifyOutDTO> festivalModify(@RequestBody MagicDTO<FestivalModifyDTO> magicDTO){
        return festivalManageService.modifyFestival(magicDTO);
    }


}
