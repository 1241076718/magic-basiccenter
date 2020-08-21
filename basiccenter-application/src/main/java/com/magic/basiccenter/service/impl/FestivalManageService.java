package com.magic.basiccenter.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.magic.application.infrastructure.service.dto.MagicDTO;
import com.magic.application.infrastructure.service.dto.MagicOutDTO;
import com.magic.basiccenter.dto.*;
import com.magic.basiccenter.error.FestivalDeleteMessageEnum;
import com.magic.basiccenter.error.FestivalModifyMessageEnum;
import com.magic.basiccenter.entity.FestivalManageInf;
import com.magic.basiccenter.model.service.FestivalService;
import com.magic.basiccenter.service.IFestivalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


@Slf4j
@Service
public class FestivalManageService implements IFestivalService {
    

    @Autowired(required = false)
    private FestivalService festivalService;


    /**
     * 添加节日
     * @param magicDTO
     * @return
     */
    @Override
    public MagicOutDTO<FestivalAddOutDTO> AddFestival(MagicDTO<FestivalAddDTO> magicDTO) {


        //定义实体对象
        FestivalManageInf festivalManageInf = new FestivalManageInf();
        FestivalAddDTO body = magicDTO.getBody();

        //封装实体对象
        //获取当前系统时间转为字符串作为Id
        String s = new Date().toString();
        festivalManageInf.setFestivalId(s);
        festivalManageInf.setFestivalYear(body.getFestivalYear());
        festivalManageInf.setFestivalName(body.getFestivalName());
        festivalManageInf.setFestivalType(body.getFestivalType());
        festivalManageInf.setFestivalDeploy(body.getFestivalDeploy());
        festivalManageInf.setFestivalStartTime(body.getFestivalStartTime());
        festivalManageInf.setFestivalEndTime(body.getFestivalEndTime());
        festivalManageInf.setFestivalPutTime(body.getFestivalPutTime());
        festivalManageInf.setFestivalPutPerson(body.getFestivalPutPerson());
        festivalManageInf.setFestivalValid("0");

        System.out.println(festivalManageInf);

        FestivalAddOutDTO festivalAddOutDTO = festivalService.FestivalAdd(festivalManageInf);

        MagicOutDTO<FestivalAddOutDTO> magicOutDTO = new MagicOutDTO<>(festivalAddOutDTO);

        return magicOutDTO;
    }

    /**
     * 查询节假日列表
     */
    @Override
    public MagicOutDTO<FestivalQueryListOutDTO> QueryFestivalList(MagicDTO<FestivalQueryListDTO> magicDTO) {

        MagicOutDTO<FestivalQueryListOutDTO> magicOutDTO=new MagicOutDTO<FestivalQueryListOutDTO>();

        FestivalQueryListOutDTO result = festivalService.FestivalQuery();

        magicOutDTO.setBody(result);

        return magicOutDTO;
    }

    /**
     * 根据节假日年份查询节假日列表
     */
    @Override
    public MagicOutDTO<FestivalQueryListOutDTO> QueryFestival(MagicDTO<FestivalQueryDTO> magicDTO) {
        FestivalQueryDTO body = magicDTO.getBody();

        MagicOutDTO<FestivalQueryListOutDTO> magicOutDTO=new MagicOutDTO<FestivalQueryListOutDTO>();

        FestivalQueryListOutDTO result = festivalService.FestivalQueryForYear(body.getFestivalYear());

        magicOutDTO.setBody(result);
        return magicOutDTO;
    }

    /**
     * 删除功能
     * @param magicDTO
     * @return
     */
    @Override
    public MagicOutDTO<FestivaldeleteOutDTO> DeleteFestival(@RequestBody MagicDTO<FestivaldeleteDTO> magicDTO) {

        MagicOutDTO<FestivaldeleteOutDTO> magicOutDTO = festivalService.FestivalDelete(magicDTO);

        return magicOutDTO;

    }

    /**
     * 节假日修改日期冲突检查
     */
    @Override
    public MagicOutDTO<FestivalManageModifyOutDTO> ModifyFestival(MagicDTO<FestivalManageModifyDTO> magicDTO) {
        // 获取输入类
        FestivalManageModifyDTO festivalModifyDTO = magicDTO.getBody();

        FestivalManageModifyOutDTO festivalModifyOutDTO = festivalService.FestivalModify(festivalModifyDTO);

        MagicOutDTO<FestivalManageModifyOutDTO> magicOutDTO = new MagicOutDTO<>(festivalModifyOutDTO);

        return magicOutDTO;
    }
}
