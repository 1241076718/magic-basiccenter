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
import com.magic.basiccenter.entity.FestivalManageInf;
import com.magic.basiccenter.entity.FestivalQueryListInf;
import com.magic.basiccenter.error.FestivalMessageEnum;
import com.magic.basiccenter.model.mapper.FestManageMapper;
import com.magic.basiccenter.model.service.FestivalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


@Slf4j
@Service
public class FestivalServiceImpl implements FestivalService {

    @Autowired(required = false)
    private FestManageMapper festManageMapper;

    @Autowired
    private SequenceFactory sequenceFactory;


    /**
     * 向数据库添加节日
     * @param festivalManageInf
     * @return
     */
    @Override
    public void FestivalAdd(FestivalManageInf festivalManageInf) {
        //添加Id
        festivalManageInf.setFestivalId(sequenceFactory.getSegmentDateId(Constant.FESTIVAL_BIZ_TAG));
        festManageMapper.insert(festivalManageInf);
    }
    /**
     * 冲突查询
     * @param festivalName
     * @param festivalYear
     * @return
     */
    @Override
    public List<FestivalManageInf> FestivalSelectNameYear(String festivalName, String festivalYear) {
        QueryWrapper<FestivalManageInf> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("FESTIVAL_YEAR", festivalYear).eq("FESTIVAL_NAME", festivalName);
        List<FestivalManageInf> festivalManageInfs = festManageMapper.selectList(queryWrapper);
        return festivalManageInfs;
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

    /**
     * 根据Id判断被修改节假日安排是否有效
     * @param festivalId
     * @return
     */
    @Override
    public FestivalManageInf FestivalModifySelectId(String festivalId) {
        FestivalManageInf oldFestival = festManageMapper.selectById(festivalId);
        return oldFestival;
    }

    /**
     * 获取所有有效的节假日安排的日期数据(大于当前系统日期)
     * @param nowDate
     * @return
     */
    @Override
    public List<FestivalManageInf> FestivalModifySelectList(Date nowDate) {
        QueryWrapper<FestivalManageInf> QueryWrapper = new QueryWrapper<>();
        List<FestivalManageInf> selectList = festManageMapper
                .selectList(QueryWrapper.gt("FESTIVAL_START_TIME", nowDate));
        return  selectList;
    }


    /**
     * 修改数据库对应数据
     * @param updateFestivalInf
     * @param festivalId
     */
    @Override
    public void FestivalModifyUpdata(FestivalManageInf updateFestivalInf, String festivalId) {
        QueryWrapper<FestivalManageInf> QueryWrapper = new QueryWrapper<>();
        festManageMapper.update(updateFestivalInf, QueryWrapper.eq("FESTIVAL_ID", festivalId));
    }
}
