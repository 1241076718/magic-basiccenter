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

import java.util.List;

/**
 * <p>基础中心--控制器</P>
 *
 * @author zhuzh@belink.com
 * @version 0.0.1
 * @className basicController
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
    public MagicOutDTO<FestivalAddOutDTO> FestivalAdd(@RequestBody MagicDTO<FestivalAddDTO> magicDTO){
        return festivalManageService.AddFestival(magicDTO);
    }



    /**
     * 节假日管理 --返回列表
     * @param magicDTO
     * @return
     */
    @PostMapping("/festival/festivalGetList")
    public MagicOutDTO<FestivalQueryListOutDTO> FestivalList(@RequestBody MagicDTO<FestivalQueryListDTO> magicDTO){
        return festivalManageService.QueryFestivalList(magicDTO);

    }

    /**
     * 节假日管理--选出当前年份的节假日信息
     * @param magicDTO
     * @return
     */
    @PostMapping("/festival/festivalGet")
    public MagicOutDTO<FestivalQueryListOutDTO> FestivalYear(@RequestBody MagicDTO<FestivalQueryDTO> magicDTO){
        return festivalManageService.QueryFestival(magicDTO);
    }


    /**
     * 节假日管理--删除
     * @param deleteDTO
     * @return
     */
    @PostMapping("/festival/festivalDelete")
    public MagicOutDTO<FestivaldeleteOutDTO> FestivalDelete(@RequestBody MagicDTO<FestivaldeleteDTO> deleteDTO){
        return festivalManageService.DeleteFestival(deleteDTO);
    }


    /**
     * 节假日管理--修改
     * @param magicDTO
     * @return
     */
    @PostMapping("/festival/festivalModify")
    public MagicOutDTO<FestivalManageModifyOutDTO> FestivalModify(@RequestBody MagicDTO<FestivalManageModifyDTO> magicDTO){
        return festivalManageService.ModifyFestival(magicDTO);
    }


}
