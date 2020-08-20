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
@RequestMapping("basic")
public class BasicController {

    @Autowired
    private FestivalManageService festivalManageService;



    /**
     * 节假日管理--新增
     * @param magicDTO
     * @return
     */
    @PostMapping("/festival/festivalAdd")
    public MagicOutDTO<FestivalAddOutDTO> FestivalAdd(@RequestBody MagicDTO<FestivalAddDTO> magicDTO){
        System.out.println("进入添加方法");
        return festivalManageService.AddFestival(magicDTO);

    }

    /**
     * 节假日管理 --返回列表
     * @return
     */
    @PostMapping("/festival/festivalGetList")
    public MagicDTO<List<FestivalQueryListOutDTO>> FestivalList(){
        return festivalManageService.queryFestivalList();

    }

    /**
     * 节假日管理--选出当前年份的节假日信息
     * @param magicDTO
     * @return
     */
    @PostMapping("/festival/festivalGet")
    public MagicDTO<List<FestivalQueryListOutDTO>> FestivalYear(@RequestBody MagicDTO<FestivalQueryDTO> magicDTO){
        FestivalQueryDTO body = magicDTO.getBody();

        System.out.println(body.getFestivalYear());
        return festivalManageService.accordingFestivalYearQueryFestivalList(body.getFestivalYear());
    }


    /**
     * 节假日管理--删除
     * @param deleteDTO
     * @return
     */
    @PostMapping("/festival/festivalDelete")
    public MagicOutDTO<FestivaldeleteOutDTO> DeleteFestival(@RequestBody MagicDTO<FestivaldeleteDTO> deleteDTO){
        System.out.println("------------------------------------");
        return festivalManageService.DeleteFestival(deleteDTO);
    }


    /**
     * 节假日管理--修改
     */
    @PostMapping("/festival/festivalModify")
    public MagicOutDTO<FestivalManageModifyOutDTO> festivalManageModify(@RequestBody MagicDTO<FestivalManageModifyDTO> magicDTO){
        return festivalManageService.festivalManageModify(magicDTO);
    }






}
