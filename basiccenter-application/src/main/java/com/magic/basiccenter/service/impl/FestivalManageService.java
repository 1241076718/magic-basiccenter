package com.magic.basiccenter.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.magic.application.infrastructure.service.dto.MagicDTO;
import com.magic.application.infrastructure.service.dto.MagicOutDTO;
import com.magic.basiccenter.application.error.FestivalDeleteMessageEnum;
import com.magic.basiccenter.application.error.FestivalModifyMessageEnum;
import com.magic.basiccenter.dto.*;
import com.magic.basiccenter.entity.FestivalManageInf;
import com.magic.basiccenter.model.mapper.FestManageMapper;
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
    private FestManageMapper festManageMapper;



    @Override
    public MagicOutDTO<FestivalAddOutDTO> AddFestival(MagicDTO<FestivalAddDTO> magicDTO) {

        //定义输出报文
        FestivalAddOutDTO festivalAddOutDTO = new FestivalAddOutDTO();

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


        //冲突查询
        QueryWrapper<FestivalManageInf> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("FESTIVAL_YEAR", festivalManageInf.getFestivalYear()).eq("FESTIVAL_NAME", festivalManageInf.getFestivalName());
        List<FestivalManageInf> festivalManageInfs = festManageMapper.selectList(queryWrapper);
        if (festivalManageInfs.isEmpty()){

            festManageMapper.insert(festivalManageInf);
            festivalAddOutDTO.setAddResult("添加成功");
        }else {
            festivalAddOutDTO.setAddResult("添加失败");

        }

        return new MagicOutDTO<>(festivalAddOutDTO);
    }

    /**
     * 查询节假日列表
     */
    @Override
    public MagicDTO<List<FestivalQueryListOutDTO>> queryFestivalList() {

        List<FestivalQueryListOutDTO> result=new ArrayList<FestivalQueryListOutDTO>();

        MagicDTO<List<FestivalQueryListOutDTO>> magicDTO=new MagicDTO<List<FestivalQueryListOutDTO>>();

        LambdaQueryWrapper<FestivalManageInf> wrapper =new LambdaQueryWrapper<FestivalManageInf>();

        Calendar now = Calendar.getInstance();
        Integer year = now.get(Calendar.YEAR);

        //注意：测试时为0，之后要设置为1
        wrapper.eq(FestivalManageInf::getFestivalValid, "0").eq(FestivalManageInf::getFestivalYear, year);
        List<FestivalManageInf> selectList = festManageMapper.selectList(wrapper);


        for (FestivalManageInf festivalmanageInf : selectList) {
            FestivalQueryListOutDTO queryFestivalListOutDTO=new FestivalQueryListOutDTO();
            queryFestivalListOutDTO.setFestivalYear(festivalmanageInf.getFestivalYear());
            queryFestivalListOutDTO.setFestivalYear(festivalmanageInf.getFestivalType());
            queryFestivalListOutDTO.setFestivalDeploy(festivalmanageInf.getFestivalDeploy());
            queryFestivalListOutDTO.setFestivalName(festivalmanageInf.getFestivalName());
            queryFestivalListOutDTO.setFestivalPutPerson(festivalmanageInf.getFestivalPutPerson());
            queryFestivalListOutDTO.setFestivalPutTime(festivalmanageInf.getFestivalPutTime());
            result.add(queryFestivalListOutDTO);
        }
        magicDTO.setBody(result);
        return magicDTO;
    }

    /**
     * 根据节假日年份查询节假日列表
     */
    @Override
    public MagicDTO<List<FestivalQueryListOutDTO>> accordingFestivalYearQueryFestivalList(String festivalYear) {
        List<FestivalQueryListOutDTO> result=new ArrayList<FestivalQueryListOutDTO>();
        MagicDTO<List<FestivalQueryListOutDTO>> magicDTO=new MagicDTO<List<FestivalQueryListOutDTO>>();
        LambdaQueryWrapper<FestivalManageInf> wrapper =new LambdaQueryWrapper<FestivalManageInf>();
        wrapper.eq(FestivalManageInf::getFestivalValid, "0").eq(FestivalManageInf::getFestivalYear, festivalYear);
        List<FestivalManageInf> selectList = festManageMapper.selectList(wrapper);

        for (FestivalManageInf festivalmanageInf : selectList) {
            System.out.println("进入循环");
            FestivalQueryListOutDTO queryFestivalListOutDTO=new FestivalQueryListOutDTO();
            queryFestivalListOutDTO.setFestivalDeploy(festivalmanageInf.getFestivalDeploy());
            queryFestivalListOutDTO.setFestivalName(festivalmanageInf.getFestivalName());
            queryFestivalListOutDTO.setFestivalYear(festivalmanageInf.getFestivalYear());
            queryFestivalListOutDTO.setFestivalPutPerson(festivalmanageInf.getFestivalPutPerson());
            queryFestivalListOutDTO.setFestivalPutTime(festivalmanageInf.getFestivalPutTime());
            result.add(queryFestivalListOutDTO);
        }
        magicDTO.setBody(result);
        return magicDTO;
    }


    /**
     * 删除功能
     * @param deleteDTO
     * @return
     */
    @Override
    public MagicOutDTO<FestivaldeleteOutDTO> DeleteFestival(@RequestBody MagicDTO<FestivaldeleteDTO> deleteDTO) {

        //日期格式转换
        SimpleDateFormat dataformat=new SimpleDateFormat("yyyy-MM-dd");
        Date date=new Date();
        String format = dataformat.format(date);
        Date getdate=null;
        Date nowdate=null;
        try {
            getdate = dataformat.parse(deleteDTO.getBody().getFestivalDeploy().split(",")[0]);
            nowdate = dataformat.parse(format);
        }catch (Exception e){
            e.printStackTrace();
        }
        //判断
        if (getdate.getTime()<=nowdate.getTime()){
            String deleteResult= FestivalDeleteMessageEnum.FALL.getDeleteResult();
            FestivaldeleteOutDTO result = new FestivaldeleteOutDTO();
            result.setDeleteResult(deleteResult);
            MagicOutDTO magicOutDTO = new MagicOutDTO(result);
            return magicOutDTO;
        }else {
            System.out.println(festManageMapper);
            System.out.println(deleteDTO.getBody());
            festManageMapper.deleteById(deleteDTO.getBody().getFestivalId());
            //festManageMapper.deleteById("1");
            String deleteResult = FestivalDeleteMessageEnum.SUCCESS.getDeleteResult();
            FestivaldeleteOutDTO result = new FestivaldeleteOutDTO();
            result.setDeleteResult(deleteResult);
            MagicOutDTO magicOutDTO = new MagicOutDTO(result);
            return magicOutDTO;
        }
    }

    /**
     * 节假日修改日期冲突检查
     */
    @Override
    public MagicOutDTO<FestivalManageModifyOutDTO> festivalManageModify(MagicDTO<FestivalManageModifyDTO> magicDTO) {
        // 获取输入类
        FestivalManageModifyDTO festivalModifyDTO = magicDTO.getBody();
        // 获取输出类
        FestivalManageModifyOutDTO festivalModifyOutDTO = new FestivalManageModifyOutDTO();
        System.out.println(festivalModifyDTO);
        if (festivalModifyDTO == null) {
            festivalModifyOutDTO.setStatus(FestivalModifyMessageEnum.FAIL_FESTIVAL_INVALID.getStatus());
            festivalModifyOutDTO.setInf(FestivalModifyMessageEnum.FAIL_FESTIVAL_INVALID.getInf());
            return new MagicOutDTO<>(festivalModifyOutDTO);
        }
        // 获取被修改节假日安排的Id
        String festivalId = festivalModifyDTO.getFestivalId();
        // 根据Id判断被修改节假日安排是否有效
        FestivalManageInf oldFestival = festManageMapper.selectById(festivalId);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String format = sdf.format(new Date());
        Date nowDate = null;
        try {
            nowDate = sdf.parse(format);
            if (oldFestival.getFestivalStartTime().getTime() <= nowDate.getTime()) {
                // 获取的节假日开始的时间比当前系统时间小或相等(不能修改,选择的节假日无效)
                festivalModifyOutDTO.setStatus(FestivalModifyMessageEnum.FAIL_FESTIVAL_INVALID.getStatus());
                festivalModifyOutDTO.setInf(FestivalModifyMessageEnum.FAIL_FESTIVAL_INVALID.getInf());
                return new MagicOutDTO<>(festivalModifyOutDTO);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        // 获取节假日修改日期数据
        String festivalDeploy = festivalModifyDTO.getFestivalDeploy();
        String[] festivalArr = festivalDeploy.split(",");
        Date festivalStartDate = null;
        Date festivalEndDate = null;
        try {
            festivalStartDate = sdf.parse(festivalArr[0]);
            festivalEndDate = sdf.parse(festivalArr[festivalArr.length - 1]);
            if (festivalStartDate.getTime()<nowDate.getTime()) {
                //修改失败，传入的修改日期无效
                festivalModifyOutDTO.setStatus(FestivalModifyMessageEnum.FAIL_IN_FESTIVAL_INVALID.getStatus());
                festivalModifyOutDTO.setInf(FestivalModifyMessageEnum.FAIL_IN_FESTIVAL_INVALID.getInf());
                return new MagicOutDTO<>(festivalModifyOutDTO);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        // 获取所有有效的节假日安排的日期数据(大于当前系统日期)
        QueryWrapper<FestivalManageInf> QueryWrapper = new QueryWrapper<>();
        List<FestivalManageInf> selectList = festManageMapper
                .selectList(QueryWrapper.gt("FESTIVAL_START_TIME", nowDate));
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
                    festivalModifyOutDTO.setStatus(FestivalModifyMessageEnum.FAIL_FESTIVAL_CONFLICT.getStatus());
                    festivalModifyOutDTO.setInf(FestivalModifyMessageEnum.FAIL_FESTIVAL_CONFLICT.getInf());
                    return new MagicOutDTO<>(festivalModifyOutDTO);
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
            festManageMapper.update(updateFestivalInf, QueryWrapper.eq("FESTIVAL_ID", festivalId));
        }
        // 返回修改成功
        festivalModifyOutDTO.setStatus(FestivalModifyMessageEnum.SUCCESS.getStatus());
        festivalModifyOutDTO.setInf(FestivalModifyMessageEnum.SUCCESS.getInf());
        return new MagicOutDTO<>(festivalModifyOutDTO);
    }
}
