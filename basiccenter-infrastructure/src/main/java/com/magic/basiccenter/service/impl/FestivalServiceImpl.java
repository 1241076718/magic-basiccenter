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
import com.magic.basiccenter.dto.entity.FestivalQueryListInf;
import com.magic.basiccenter.error.FestivalMessageEnum;
import com.magic.basiccenter.model.entity.BsFestivalInf;
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
    public void festivalAdd(FestivalAddDTO festivalAddDTO) {

        BsFestivalInf festivalManageInf = new BsFestivalInf();

        //添加Id
        festivalManageInf.setFestivalId(sequenceFactory.getSegmentDateId(Constant.FESTIVAL_BIZ_TAG));
        //封装实体对象
        festivalManageInf.setFestivalYear(festivalAddDTO.getFestivalYear());
        festivalManageInf.setFestivalName(festivalAddDTO.getFestivalName());
        festivalManageInf.setFestivalType(festivalAddDTO.getFestivalType());
        festivalManageInf.setFestivalDeploy(festivalAddDTO.getFestivalDeploy());
        festivalManageInf.setFestivalStartTime(festivalAddDTO.getFestivalStartTime());
        festivalManageInf.setFestivalEndTime(festivalAddDTO.getFestivalEndTime());
        festivalManageInf.setFestivalPutTime(festivalAddDTO.getFestivalPutTime());
        festivalManageInf.setFestivalPutPerson(festivalAddDTO.getECFID());
        festivalManageInf.setFestivalExist("0");
        festivalManageInf.setFestivalValid("0");
        festManageMapper.insert(festivalManageInf);

    }
    /**
     * 冲突查询
     * @param festivalName
     * @param festivalYear
     * @return
     */
    @Override
    public Boolean festivalSelectNameYear(String festivalName, String festivalYear,Date startTime,Date endTime) {

        Boolean f=false;
        QueryWrapper<BsFestivalInf> queryWrapper = new QueryWrapper<>();

        LambdaQueryWrapper<BsFestivalInf> wrapper =new LambdaQueryWrapper<BsFestivalInf>();

        LambdaQueryWrapper<BsFestivalInf> wrapper1 = wrapper.eq(BsFestivalInf::getFestivalExist, "0").eq(BsFestivalInf::getFestivalYear, festivalYear);


        List<BsFestivalInf> bsFestivalInfs = festManageMapper.selectList(wrapper1);
        for (BsFestivalInf bsFestivalInf : bsFestivalInfs) {
            if(startTime.getTime()>bsFestivalInf.getFestivalEndTime().getTime()||endTime.getTime()<bsFestivalInf.getFestivalStartTime().getTime()){
                f=true;
            }
            else return false;
        }

        //判断年份和名称
        queryWrapper.eq("FESTIVAL_YEAR", festivalYear).eq("FESTIVAL_NAME", festivalName);
        List<BsFestivalInf> festivalManageInfs = festManageMapper.selectList(queryWrapper);
        if (festivalManageInfs.isEmpty()){
            f=true;
        }else {
            f=false;
        }
        return f;
    }

    /**
     * 根据节假日年份查询节假日列表
     * @param festivalYear
     * @return
     */
    @Override
    public FestivalQueryListOutDTO festivalQueryByYear(String festivalYear) {
        //定义输出对象
        FestivalQueryListOutDTO result=new FestivalQueryListOutDTO();
        ArrayList<FestivalQueryListInf> festivalQueryListInfs = new ArrayList<>();

        LambdaQueryWrapper<BsFestivalInf> wrapper =new LambdaQueryWrapper<BsFestivalInf>();
        //注意：测试时为0，之后要设置为1
        wrapper.eq(BsFestivalInf::getFestivalExist,"0").eq(BsFestivalInf::getFestivalValid, "0").eq(BsFestivalInf::getFestivalYear, festivalYear);
        List<BsFestivalInf> selectList = festManageMapper.selectList(wrapper);
        for (BsFestivalInf festivalmanageInf : selectList) {
            FestivalQueryListInf queryFestivalListOutDTO=new FestivalQueryListInf();
            queryFestivalListOutDTO.setFestivalDeploy(festivalmanageInf.getFestivalDeploy());
            queryFestivalListOutDTO.setFestivalId(festivalmanageInf.getFestivalId());
            queryFestivalListOutDTO.setFestivalName(festivalmanageInf.getFestivalName());
            queryFestivalListOutDTO.setFestivalYear(festivalmanageInf.getFestivalYear());
            queryFestivalListOutDTO.setFestivalType(festivalmanageInf.getFestivalType());
            queryFestivalListOutDTO.setFestivalPutPerson(festivalmanageInf.getFestivalPutPerson());
            queryFestivalListOutDTO.setFestivalPutTime(festivalmanageInf.getFestivalPutTime());
            festivalQueryListInfs.add(queryFestivalListOutDTO);
        }
        result.setFestivalQueryListInfs(festivalQueryListInfs);
        return result;
    }

    /**
     * 删除选定节假日
     * @param magicDTO
     * @return
     */
    @Override
    public MagicOutDTO<FestivaldeleteOutDTO> festivalDelete(MagicDTO<FestivaldeleteDTO> magicDTO) {

        //定义输出对象
        MagicOutDTO magicOutDTO = new MagicOutDTO();
        RespHeader respHeader=new RespHeader();
        ApplicationServiceUtil.supplementaryRespHeader(magicDTO.getHeader(), respHeader);

        //日期格式转换
        SimpleDateFormat dataformat=new SimpleDateFormat("yyyy-MM-dd");
        Date date=new Date();
        String format = dataformat.format(date);

        //获取删除节假日时间
        Date getdate=null;
        //获取当前时间
        Date nowdate=null;


        try {
            getdate = dataformat.parse(magicDTO.getBody().getFestivalDeploy().split(",")[0]);
            nowdate = dataformat.parse(format);
        }catch (Exception e){
            respHeader.setErrorCode(FestivalMessageEnum.FAIL.code());
            respHeader.setErrorMsg(FestivalMessageEnum.FAIL.msg());
            e.printStackTrace();
        }

        //判断日期是否过时
        if (getdate.getTime()<=nowdate.getTime()){
            //日期过时
            respHeader.setErrorCode(FestivalMessageEnum.FAIL_FESTIVAL_DELETE_INVALID.code());
            respHeader.setErrorMsg(FestivalMessageEnum.FAIL_FESTIVAL_DELETE_INVALID.msg());

            magicOutDTO.setHeader(respHeader);
            return magicOutDTO;
        }else {
            //日期未过时
            respHeader.setErrorCode(FestivalMessageEnum.SUCCESS.code());
            respHeader.setErrorMsg(FestivalMessageEnum.SUCCESS.msg());
            magicOutDTO.setHeader(respHeader);

            QueryWrapper<BsFestivalInf> queryWrapper= new QueryWrapper<>();
            BsFestivalInf festivalManageInf=new BsFestivalInf();
            festivalManageInf.setFestivalExist("-1");

            festivalManageInf.setFestivalUpdatePerson(magicDTO.getBody().getECIFID());
            festivalManageInf.setFestivalUpdateTime(nowdate);

            festManageMapper.update(festivalManageInf,queryWrapper.eq("FESTIVAL_ID",magicDTO.getBody().getFestivalId()));
            return magicOutDTO;
        }

    }


    /**
     * 修改选定节假日
     * @param festivalModifyDTO
     * @return
     */
    @Override
    public RespHeader festivalModify(FestivalModifyDTO festivalModifyDTO) {

        //定义响应头
        RespHeader respHeader = new RespHeader();

        //获取Id
        String festivalId = festivalModifyDTO.getFestivalId();

        // 根据Id判断被修改节假日安排是否有效
        BsFestivalInf oldFestival = festManageMapper.selectById(festivalId);

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
        QueryWrapper<BsFestivalInf> QueryWrapper = new QueryWrapper<>();
        List<BsFestivalInf> selectList = festManageMapper
                .selectList(QueryWrapper.gt("FESTIVAL_START_TIME", nowDate));

        // 判断节假日修改日期是否与其他日期冲突
        // 创建判断失败flag
        boolean conflict = false;
        for (BsFestivalInf festivalRawDataDate : selectList) {
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
            BsFestivalInf updateFestivalInf = new BsFestivalInf();
            updateFestivalInf.setFestivalDeploy(festivalDeploy);
            updateFestivalInf.setFestivalName(festivalModifyDTO.getFestivalName());
            updateFestivalInf.setFestivalUpdatePerson(festivalModifyDTO.getECIFID());
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
