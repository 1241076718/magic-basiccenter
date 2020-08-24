package com.magic.basiccenter.service.impl;

import com.gift.domain.sequence.factory.SequenceFactory;
import com.magic.application.infrastructure.service.dto.MagicDTO;
import com.magic.application.infrastructure.service.dto.MagicOutDTO;
import com.magic.application.infrastructure.service.dto.data.RespHeader;
import com.magic.application.infrastructure.utils.ApplicationServiceUtil;
import com.magic.basiccenter.dto.*;
import com.magic.basiccenter.entity.FestivalManageInf;
import com.magic.basiccenter.error.FestivalMessageEnum;
import com.magic.basiccenter.model.service.FestivalService;
import com.magic.basiccenter.service.IFestivalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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

        //定义输出对象
        FestivalAddOutDTO festivalAddOutDTO = new FestivalAddOutDTO();
        RespHeader respHeader=new RespHeader();
        MagicOutDTO<FestivalAddOutDTO> magicOutDTO;
        ApplicationServiceUtil.supplementaryRespHeader(magicDTO.getHeader(), respHeader);

        //封装实体对象
        festivalManageInf.setFestivalYear(body.getFestivalYear());
        festivalManageInf.setFestivalName(body.getFestivalName());
        festivalManageInf.setFestivalType(body.getFestivalType());
        festivalManageInf.setFestivalDeploy(body.getFestivalDeploy());
        festivalManageInf.setFestivalStartTime(body.getFestivalStartTime());
        festivalManageInf.setFestivalEndTime(body.getFestivalEndTime());
        festivalManageInf.setFestivalPutTime(body.getFestivalPutTime());
        festivalManageInf.setFestivalPutPerson(body.getFestivalPutPerson());
        festivalManageInf.setFestivalExist("0");
        festivalManageInf.setFestivalValid("0");

        //冲突判断
        List<FestivalManageInf> festivalManageInfs = festivalService.FestivalSelectNameYear(festivalManageInf.getFestivalName(), festivalManageInf.getFestivalYear());

        if (festivalManageInfs.isEmpty()){
            //无冲突则添加
            festivalService.FestivalAdd(festivalManageInf);
            respHeader.setErrorCode(FestivalMessageEnum.SUCCESS.code());
            respHeader.setErrorMsg(FestivalMessageEnum.SUCCESS.msg());
        }else {
            //有冲突则返回失败
            respHeader.setErrorCode(FestivalMessageEnum.FAIL_FESTIVAL_ADD_CONFLICT.code());
            respHeader.setErrorMsg(FestivalMessageEnum.FAIL_FESTIVAL_ADD_CONFLICT.msg());
        }
        magicOutDTO = new MagicOutDTO<>(festivalAddOutDTO);
        magicOutDTO.setHeader(respHeader);
        return magicOutDTO;
    }



    /**
     * 查询节假日列表
     * @param magicDTO
     * @return
     */
    @Override
    public MagicOutDTO<FestivalQueryListOutDTO> QueryFestivalList(MagicDTO<FestivalQueryListDTO> magicDTO) {

        MagicOutDTO<FestivalQueryListOutDTO> magicOutDTO=new MagicOutDTO<FestivalQueryListOutDTO>();
        FestivalQueryListOutDTO result = festivalService.FestivalQuery();
        magicOutDTO.setBody(result);
        RespHeader respHeader=new RespHeader();
        ApplicationServiceUtil.supplementaryRespHeader(magicDTO.getHeader(), respHeader);
        respHeader.setErrorCode(FestivalMessageEnum.SUCCESS.code());
        respHeader.setErrorMsg(FestivalMessageEnum.SUCCESS.msg());
        magicOutDTO.setHeader(respHeader);
        return magicOutDTO;
    }



    /**
     * 根据节假日年份查询节假日列表
     * @param magicDTO
     * @return
     */
    @Override
    public MagicOutDTO<FestivalQueryListOutDTO> QueryFestival(MagicDTO<FestivalQueryDTO> magicDTO) {

        FestivalQueryDTO body = magicDTO.getBody();
        MagicOutDTO<FestivalQueryListOutDTO> magicOutDTO=new MagicOutDTO<FestivalQueryListOutDTO>();
        FestivalQueryListOutDTO result = festivalService.FestivalQueryForYear(body.getFestivalYear());
        magicOutDTO.setBody(result);
        RespHeader respHeader=new RespHeader();
        ApplicationServiceUtil.supplementaryRespHeader(magicDTO.getHeader(), respHeader);
        respHeader.setErrorCode(FestivalMessageEnum.SUCCESS.code());
        respHeader.setErrorMsg(FestivalMessageEnum.SUCCESS.msg());
        magicOutDTO.setHeader(respHeader);
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
     * @param magicDTO
     * @return
     */
    @Override
    public MagicOutDTO<FestivalManageModifyOutDTO> ModifyFestival(MagicDTO<FestivalManageModifyDTO> magicDTO) {
        // 获取输入类
        FestivalManageModifyDTO festivalModifyDTO = magicDTO.getBody();

        // 获取输出类
        MagicOutDTO<FestivalManageModifyOutDTO> magicOutDTO = new MagicOutDTO<>();

        RespHeader respHeader = new RespHeader();
        ApplicationServiceUtil.supplementaryRespHeader(magicDTO.getHeader(), respHeader);

        if (festivalModifyDTO.getFestivalDeploy() == null) {
            respHeader.setErrorCode(FestivalMessageEnum.FAIL_FESTIVAL_INVALID.code());
            respHeader.setErrorMsg(FestivalMessageEnum.FAIL_FESTIVAL_INVALID.msg());
            magicOutDTO.setHeader(respHeader);
            return magicOutDTO;
        }

        // 获取被修改节假日安排的Id
        String festivalId = festivalModifyDTO.getFestivalId();
        // 根据Id判断被修改节假日安排是否有效
        FestivalManageInf oldFestival = festivalService.FestivalModifySelectId(festivalId);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String format = sdf.format(new Date());
        Date nowDate = null;
        try {
            nowDate = sdf.parse(format);
            if (oldFestival.getFestivalStartTime().getTime() <= nowDate.getTime()) {
                // 获取的节假日开始的时间比当前系统时间小或相等(不能修改,选择的节假日无效)
                respHeader.setErrorCode(FestivalMessageEnum.FAIL_FESTIVAL_INVALID.code());
                respHeader.setErrorMsg(FestivalMessageEnum.FAIL_FESTIVAL_INVALID.msg());
                magicOutDTO.setHeader(respHeader);
                return magicOutDTO;
            }
        } catch (ParseException e) {
            respHeader.setErrorCode(FestivalMessageEnum.FAIL.code());
            respHeader.setErrorMsg(FestivalMessageEnum.FAIL.msg());
            magicOutDTO.setHeader(respHeader);
            return magicOutDTO;
        }

        // 获取节假日修改日期数据
        String festivalDeploy = festivalModifyDTO.getFestivalDeploy();
        String[] festivalArr = festivalDeploy.split(",");
        Date festivalStartDate = null;
        Date festivalEndDate = null;
        try {
            festivalStartDate = sdf.parse(festivalArr[0]);
            festivalEndDate = sdf.parse(festivalArr[festivalArr.length - 1]);
            if (festivalStartDate.getTime() < nowDate.getTime()) {
                // 修改失败，传入的修改日期无效
                respHeader.setErrorCode(FestivalMessageEnum.FAIL_IN_FESTIVAL_INVALID.code());
                respHeader.setErrorMsg(FestivalMessageEnum.FAIL_IN_FESTIVAL_INVALID.msg());
                magicOutDTO.setHeader(respHeader);
                return magicOutDTO;
            }
        } catch (ParseException e) {
            respHeader.setErrorCode(FestivalMessageEnum.FAIL.code());
            respHeader.setErrorMsg(FestivalMessageEnum.FAIL.msg());
            magicOutDTO.setHeader(respHeader);
            return magicOutDTO;
        }

        // 获取所有有效的节假日安排的日期数据(大于当前系统日期)
        List<FestivalManageInf> selectList = festivalService.FestivalModifySelectList(nowDate);

        // 判断节假日修改日期是否与其他日期冲突
        // 创建判断失败flag
        boolean conflict = false;
        for (FestivalManageInf festivalRawDataDate : selectList) {
            // 判断是否是其他日期
            if (!festivalRawDataDate.getFestivalId().equals(festivalId)) {
                // 不冲突
                if (festivalRawDataDate.getFestivalStartTime().getTime() > festivalEndDate.getTime()
                        || festivalRawDataDate.getFestivalEndTime().getTime() < festivalStartDate.getTime()) {
                    conflict = true;
                } else {
                    // 冲突：修改失败
                    respHeader.setErrorCode(FestivalMessageEnum.FAIL_FESTIVAL_CONFLICT.code());
                    respHeader.setErrorMsg(FestivalMessageEnum.FAIL_FESTIVAL_CONFLICT.msg());
                    magicOutDTO.setHeader(respHeader);

                    return magicOutDTO;
                }
            } else {
                conflict = true;
            }
        }
        // 判断成功，修改数据
        if (conflict) {
            // 获取节假日修改的其他数据
            // 将数据修改至数据库
            FestivalManageInf updateFestivalInf = new FestivalManageInf();
            updateFestivalInf.setFestivalDeploy(festivalDeploy);
            updateFestivalInf.setFestivalName(festivalModifyDTO.getFestivalName());
            updateFestivalInf.setFestivalUpdatePerson("LEI");
            updateFestivalInf.setFestivalUpdateTime(nowDate);
            updateFestivalInf.setFestivalStartTime(festivalStartDate);
            updateFestivalInf.setFestivalEndTime(festivalEndDate);
            updateFestivalInf.setFestivalType(festivalModifyDTO.getFestivalType());

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(festivalStartDate);
            updateFestivalInf.setFestivalYear(String.valueOf(calendar.get(Calendar.YEAR)));
            festivalService.FestivalModifyUpdata(updateFestivalInf, festivalId);

        }
        // 返回修改成功
        respHeader.setErrorCode(FestivalMessageEnum.SUCCESS.code());
        respHeader.setErrorMsg(FestivalMessageEnum.SUCCESS.msg());
        magicOutDTO.setHeader(respHeader);
        return magicOutDTO;
    }
}
