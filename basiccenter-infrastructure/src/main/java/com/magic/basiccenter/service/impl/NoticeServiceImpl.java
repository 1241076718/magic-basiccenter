package com.magic.basiccenter.service.impl;

import com.gift.core.utils.SpringContextUtils;
import com.gift.domain.sequence.factory.SequenceFactory;
import com.magic.basiccenter.constants.Constant;
import com.magic.basiccenter.dto.AddNoticeInfoInDTO;
import com.magic.basiccenter.dto.AddNoticeInfoOutDTO;
import com.magic.basiccenter.dto.QueryNoticeInfoDTO;
import com.magic.basiccenter.model.dto.QueryNoticeDTO;
import com.magic.basiccenter.model.dto.QueryNoticeOutDTO;
import com.magic.basiccenter.model.entity.BsNoticeInf;
import com.magic.basiccenter.model.mapper.BsNoticeInfMapper;
import com.magic.basiccenter.model.service.IBsNoticeInfService;
import com.magic.basiccenter.model.service.INoticeService;
import com.magic.basiccenter.model.service.impl.BsNoticeInfServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;



/**
 * @author ：goupc1@belink.com
 * @date ：Created in 2020/8/620 9:54
 * @description：  数据层service实现类
 * @modified By：
 * @version: $1.0.0
 */

@Service
public class NoticeServiceImpl implements INoticeService {


    /**
     * 获取序列id工具类
     *
     */
    @Autowired(required = false)
    SequenceFactory sequenceFactory;


    /**
     * 查询公告方法
     * @param inputDTO
     * @return
     */
    @Override
    public List<QueryNoticeOutDTO> queryNotice(QueryNoticeDTO inputDTO) {

        QueryNoticeOutDTO outData = new QueryNoticeOutDTO();

        BsNoticeInfServiceImpl bean = SpringContextUtils.getBean(BsNoticeInfServiceImpl.class);

        BsNoticeInfMapper baseMapper = bean.getBaseMapper();

        List<QueryNoticeOutDTO> cuNoticeInfs = baseMapper.selectNotice(inputDTO);

        return cuNoticeInfs;

    }


    /**
     * 新增公告方法
     * @param inputDTO
     * @return
     */

    @Override
    public AddNoticeInfoOutDTO addNotice(AddNoticeInfoInDTO inputDTO) {
        AddNoticeInfoOutDTO addNoticeInfoOutDTO = new AddNoticeInfoOutDTO();
        BsNoticeInfServiceImpl bean = SpringContextUtils.getBean(BsNoticeInfServiceImpl.class);
        BsNoticeInfMapper baseMapper = bean.getBaseMapper();
        BsNoticeInf bsNoticeInf = new BsNoticeInf();
        //DTO转换为entity
        BeanUtils.copyProperties(inputDTO, bsNoticeInf);
        String noticeId = sequenceFactory.getSegmentDateId(Constant.CU_NOTICE_ID);
        bsNoticeInf.setNiNtcId(noticeId);
        bsNoticeInf.setNiNtcGmtCreate(new Date());
        int row = baseMapper.insert(bsNoticeInf);
        addNoticeInfoOutDTO.setTotal(row);
        return addNoticeInfoOutDTO;
    }

    @Autowired
    private IBsNoticeInfService iBsNoticeInfService;
    /**
     * 公告删除和上下架方法
     * @param inputDTO
     * @return
     */

    @Override
    public QueryNoticeOutDTO changeNoticeStatus(QueryNoticeInfoDTO inputDTO) {

        QueryNoticeOutDTO changeNoticeStatus = new QueryNoticeOutDTO();
        BsNoticeInfServiceImpl been = SpringContextUtils.getBean(BsNoticeInfServiceImpl.class);
        BsNoticeInfMapper baseMapper = been.getBaseMapper();
        BsNoticeInf bsNoticeInf = new BsNoticeInf();
        BeanUtils.copyProperties(inputDTO, bsNoticeInf);
        int i =baseMapper.updateById(bsNoticeInf);
        changeNoticeStatus.setNiNtcCount(i);
        return changeNoticeStatus;
    }
    /**
     * 修改公告管理列表
     * @param requestDTO
     * @return
     */
    @Override
    public QueryNoticeOutDTO updateNotice(QueryNoticeDTO requestDTO) {
        QueryNoticeOutDTO outDTO = new QueryNoticeOutDTO();
        BsNoticeInfServiceImpl bean = SpringContextUtils.getBean(BsNoticeInfServiceImpl.class);
        BsNoticeInfMapper baseMapper = bean.getBaseMapper();
        BsNoticeInf entity = new BsNoticeInf();
        entity.setNiNtcName(requestDTO.getNiNtcName())
                .setNiNtcId(requestDTO.getNiNtcId())
                .setNiNtcText(requestDTO.getNiNtcText())
                .setNiNtcCount(requestDTO.getNiNtcCount())
                .setNiNtcEndTime(requestDTO.getNiNtcEndTime())
                .setNiNtcStartTime(requestDTO.getNiNtcStartTime())
                .setNiNtcStatus(requestDTO.getNiNtcStatus());
        //3.2.2修改数据库中的数据
        baseMapper.updateById(entity);
        //4.1获取数据库中数据
        BsNoticeInf notice = baseMapper.selectById(requestDTO.getNiNtcId());

        outDTO.setNiNtcName(notice.getNiNtcName())
                .setNiNtcText(notice.getNiNtcText())
                .setNiNtcCount(notice.getNiNtcCount())
                .setNiNtcEndTime(notice.getNiNtcEndTime())
                .setNiNtcStartTime(notice.getNiNtcStartTime())
                .setNiNtcStatus(notice.getNiNtcStatus());
        return outDTO;
    }


}
