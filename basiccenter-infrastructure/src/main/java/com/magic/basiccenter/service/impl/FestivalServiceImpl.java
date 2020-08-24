package com.magic.basiccenter.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gift.domain.sequence.factory.SequenceFactory;
import com.magic.application.infrastructure.service.dto.MagicDTO;
import com.magic.application.infrastructure.service.dto.MagicOutDTO;
import com.magic.application.infrastructure.service.dto.data.RespHeader;
import com.magic.application.infrastructure.utils.ApplicationServiceUtil;
import com.magic.basiccenter.constants.Constant;
import com.magic.basiccenter.dto.*;
import com.magic.basiccenter.model.entity.FestivalManageInf;
import com.magic.basiccenter.dto.entity.FestivalQueryListInf;
import com.magic.basiccenter.error.FestivalMessageEnum;
import com.magic.basiccenter.model.mapper.FestManageMapper;
import com.magic.basiccenter.model.service.FestivalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


/**
 * 节假日模块数据交互层功能
 * @Author YuJiaYu
 */
@Slf4j
@Service
public class FestivalServiceImpl implements FestivalService {

    @Autowired(required = false)
    private FestManageMapper festManageMapper;

    @Autowired
    private SequenceFactory sequenceFactory;



    /**
     * 向数据库添加节日
     * @param festivalAddDTO
     */
    @Override
    public void FestivalAdd(FestivalAddDTO festivalAddDTO) {

        FestivalManageInf festivalManageInf = new FestivalManageInf();

        //添加Id
        //封装实体对象
        festivalManageInf.setFestivalYear(festivalAddDTO.getFestivalYear());
        festivalManageInf.setFestivalName(festivalAddDTO.getFestivalName());
        festivalManageInf.setFestivalType(festivalAddDTO.getFestivalType());
        festivalManageInf.setFestivalDeploy(festivalAddDTO.getFestivalDeploy());
        festivalManageInf.setFestivalStartTime(festivalAddDTO.getFestivalStartTime());
        festivalManageInf.setFestivalEndTime(festivalAddDTO.getFestivalEndTime());
        festivalManageInf.setFestivalPutTime(festivalAddDTO.getFestivalPutTime());
        festivalManageInf.setFestivalPutPerson(festivalAddDTO.getFestivalPutPerson());
        festivalManageInf.setFestivalExist("0");
        festivalManageInf.setFestivalValid("0");
        festivalManageInf.setFestivalId(sequenceFactory.getSegmentDateId(Constant.FESTIVAL_BIZ_TAG));

    }
    /**
     * 冲突查询
     * @param festivalName
     * @param festivalYear
     * @return
     */
    @Override
    public Boolean FestivalSelectNameYear(String festivalName, String festivalYear) {
        QueryWrapper<FestivalManageInf> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("FESTIVAL_YEAR", festivalYear).eq("FESTIVAL_NAME", festivalName);
        List<FestivalManageInf> festivalManageInfs = festManageMapper.selectList(queryWrapper);
        if (festivalManageInfs.isEmpty()){
            return true;
            //festManageMapper.insert(festivalManageInf);
        }else {
            return false;
        }
    }


    /**
     * 查询当前年份的节假日
     * @return
     */
    @Override
    public FestivalQueryListOutDTO FestivalQuery() {
        //定义输出报文
        FestivalQueryListOutDTO result=new FestivalQueryListOutDTO();
        ArrayList<FestivalQueryListInf> festivalQueryListInfs = new ArrayList<>();
        LambdaQueryWrapper<FestivalManageInf> wrapper =new LambdaQueryWrapper<FestivalManageInf>();
        Calendar now = Calendar.getInstance();
        Integer year = now.get(Calendar.YEAR);
        //注意：测试时为0，之后要设置为1
        wrapper.eq(FestivalManageInf::getFestivalExist,"0").eq(FestivalManageInf::getFestivalValid, "0").eq(FestivalManageInf::getFestivalYear, year);
        List<FestivalManageInf> selectList = festManageMapper.selectList(wrapper);
        for (FestivalManageInf festivalmanageInf : selectList) {
            FestivalQueryListInf queryFestivalListOutDTO=new FestivalQueryListInf();
            queryFestivalListOutDTO.setFestivalYear(festivalmanageInf.getFestivalYear());
            queryFestivalListOutDTO.setFestivalType(festivalmanageInf.getFestivalType());
            queryFestivalListOutDTO.setFestivalDeploy(festivalmanageInf.getFestivalDeploy());
            queryFestivalListOutDTO.setFestivalName(festivalmanageInf.getFestivalName());
            queryFestivalListOutDTO.setFestivalPutPerson(festivalmanageInf.getFestivalPutPerson());
            queryFestivalListOutDTO.setFestivalPutTime(festivalmanageInf.getFestivalPutTime());
            festivalQueryListInfs.add(queryFestivalListOutDTO);
        }
        result.setFestivalQueryListInfs(festivalQueryListInfs);
        return result;

    }


    /**
     * 根据节假日年份查询节假日列表
     * @param year
     * @return
     */
    @Override
    public FestivalQueryListOutDTO FestivalQueryForYear(String year) {
        FestivalQueryListOutDTO result=new FestivalQueryListOutDTO();
        ArrayList<FestivalQueryListInf> festivalQueryListInfs = new ArrayList<>();
        LambdaQueryWrapper<FestivalManageInf> wrapper =new LambdaQueryWrapper<FestivalManageInf>();
        wrapper.eq(FestivalManageInf::getFestivalExist,"0").eq(FestivalManageInf::getFestivalValid, "0").eq(FestivalManageInf::getFestivalYear, year);
        List<FestivalManageInf> selectList = festManageMapper.selectList(wrapper);
        for (FestivalManageInf festivalmanageInf : selectList) {
            FestivalQueryListInf queryFestivalListOutDTO=new FestivalQueryListInf();
            queryFestivalListOutDTO.setFestivalDeploy(festivalmanageInf.getFestivalDeploy());
            queryFestivalListOutDTO.setFestivalName(festivalmanageInf.getFestivalName());
            queryFestivalListOutDTO.setFestivalYear(festivalmanageInf.getFestivalYear());
            queryFestivalListOutDTO.setFestivalPutPerson(festivalmanageInf.getFestivalPutPerson());
            queryFestivalListOutDTO.setFestivalPutTime(festivalmanageInf.getFestivalPutTime());
            festivalQueryListInfs.add(queryFestivalListOutDTO);
        }
        result.setFestivalQueryListInfs(festivalQueryListInfs);
        return result;
    }

    /**
     * 删除选定节假日
     * @param deleteDTO
     * @return
     */
    @Override
    public MagicOutDTO<FestivaldeleteOutDTO> FestivalDelete(MagicDTO<FestivaldeleteDTO> deleteDTO) {
            //日期格式转换
            SimpleDateFormat dataformat=new SimpleDateFormat("yyyy-MM-dd");
            Date date=new Date();
            String format = dataformat.format(date);
            Date getdate=null;
            Date nowdate=null;
            RespHeader respHeader=new RespHeader();
            MagicOutDTO magicOutDTO = new MagicOutDTO();
            ApplicationServiceUtil.supplementaryRespHeader(deleteDTO.getHeader(), respHeader);
            try {
                getdate = dataformat.parse(deleteDTO.getBody().getFestivalDeploy().split(",")[0]);
                nowdate = dataformat.parse(format);
            }catch (Exception e){
                e.printStackTrace();
            }
            //判断日期是否过时
            if (getdate.getTime()<=nowdate.getTime()){
                respHeader.setErrorCode(FestivalMessageEnum.FAIL.code());
                respHeader.setErrorMsg(FestivalMessageEnum.FAIL.msg());
                magicOutDTO.setHeader(respHeader);
                //festManageMapper.updateById()
                return magicOutDTO;
            }else {
                respHeader.setErrorCode(FestivalMessageEnum.SUCCESS.code());
                respHeader.setErrorMsg(FestivalMessageEnum.SUCCESS.msg());
                magicOutDTO.setHeader(respHeader);
                QueryWrapper<FestivalManageInf> queryWrapper= new QueryWrapper<>();
                FestivalManageInf festivalManageInf=new FestivalManageInf();
                festivalManageInf.setFestivalExist("-1");
                festManageMapper.update(festivalManageInf,queryWrapper.eq("FESTIVAL_ID",deleteDTO.getBody().getFestivalId()));
                return magicOutDTO;
            }

    }

    @Override
    public RespHeader FestivalModify(FestivalManageModifyDTO festivalModifyDTO) {

        RespHeader respHeader = new RespHeader();

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
                respHeader.setErrorCode(FestivalMessageEnum.FAIL_FESTIVAL_INVALID.code());
                respHeader.setErrorMsg(FestivalMessageEnum.FAIL_FESTIVAL_INVALID.msg());
                return respHeader;
            }
        } catch (ParseException e) {
            respHeader.setErrorCode(FestivalMessageEnum.FAIL.code());
            respHeader.setErrorMsg(FestivalMessageEnum.FAIL.msg());
            return respHeader;
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
                return respHeader;
            }
        } catch (ParseException e) {
            respHeader.setErrorCode(FestivalMessageEnum.FAIL.code());
            respHeader.setErrorMsg(FestivalMessageEnum.FAIL.msg());
            return respHeader;
        }

        // 获取所有有效的节假日安排的日期数据(大于当前系统日期)
        QueryWrapper<FestivalManageInf> QueryWrapper = new QueryWrapper<>();
        List<FestivalManageInf> selectList = festManageMapper
                .selectList(QueryWrapper.gt("FESTIVAL_START_TIME", nowDate));

        // 判断节假日修改日期是否与其他日期冲突
        // 创建判断失败flag
        boolean conflict = false;
        for (FestivalManageInf festivalRawDataDate : selectList) {
            //判断日期是否存在
            if (festivalRawDataDate.getFestivalExist().equals("0")) {

                // 判断是否是其他日期
                if (!festivalRawDataDate.getFestivalId().equals(festivalModifyDTO.getFestivalId())) {
                    // 不冲突
                    if (festivalRawDataDate.getFestivalStartTime().getTime() > festivalEndDate.getTime()
                            || festivalRawDataDate.getFestivalEndTime().getTime() < festivalStartDate.getTime()) {
                        conflict = true;
                    } else {
                        // 冲突：修改失败
                        respHeader.setErrorCode(FestivalMessageEnum.FAIL_FESTIVAL_CONFLICT.code());
                        respHeader.setErrorMsg(FestivalMessageEnum.FAIL_FESTIVAL_CONFLICT.msg());
                        return respHeader;
                    }
                } else {
                    conflict = true;
                }
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
        respHeader.setErrorCode(FestivalMessageEnum.SUCCESS.code());
        respHeader.setErrorMsg(FestivalMessageEnum.SUCCESS.msg());

        return respHeader;

    }




}
