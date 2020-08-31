package com.magic.basiccenter.service.impl;

import com.magic.application.infrastructure.service.dto.MagicDTO;
import com.magic.application.infrastructure.service.dto.MagicOutDTO;
import com.magic.application.infrastructure.service.dto.data.ReqHeader;
import com.magic.application.infrastructure.service.dto.data.RespHeader;
import com.magic.application.infrastructure.utils.ApplicationServiceUtil;
import com.magic.basiccenter.constants.Constant;
import com.magic.basiccenter.dto.AdvertAddDTO;
import com.magic.basiccenter.dto.AdvertAddOutDTO;
import com.magic.basiccenter.dto.AdvertColumnDTO;
import com.magic.basiccenter.dto.AdvertColumnOutDTO;
import com.magic.basiccenter.dto.AdvertSelDTO;
import com.magic.basiccenter.dto.AdvertSelOutDTO;
import com.magic.basiccenter.dto.AdvertUpdDTO;
import com.magic.basiccenter.dto.AdvertUpdOutDTO;
import com.magic.basiccenter.dto.AdvertDelDTO;
import com.magic.basiccenter.dto.AdvertDelOutDTO;
import com.magic.basiccenter.error.AdvertErrorEnum;
import com.magic.basiccenter.model.dto.AddAdvertInfoDTO;
import com.magic.basiccenter.model.dto.DelAdvertInfoDTO;
import com.magic.basiccenter.model.dto.SelAdvertColInfoDTO;
import com.magic.basiccenter.model.dto.SelAdvertColInfoOutDTO;
import com.magic.basiccenter.model.dto.SelAdvertInfoDTO;
import com.magic.basiccenter.model.dto.SelAdvertInfoOutDTO;
import com.magic.basiccenter.model.dto.UpdAdvertInfoDTO;
import com.magic.basiccenter.model.service.IAdvertService;
import com.magic.basiccenter.service.IAdvertManageService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>广告管理接口实现类</P>
 *
 * @author laiqx@belink.com
 * @version 0.0.1
 * @className AdvertManageServiceImpl
 * @sine 2020/8/19 10:18
 */
public class AdvertManageServiceImpl implements IAdvertManageService {
    /**
     * 广告配置表数据交互服务
     */
    @Autowired
    private IAdvertService advertService;

    /**
     * 广告配置新增
     * @param requestDTO
     * @return
     * @author laiqx@belink.com
     */
    @Override
    public MagicOutDTO<AdvertAddOutDTO> addAdvertInfo(MagicDTO<AdvertAddDTO> requestDTO) {
        AdvertAddOutDTO outData = new AdvertAddOutDTO();
        MagicOutDTO<AdvertAddOutDTO> magicOutDTO = new MagicOutDTO<>(outData);

        RespHeader respHeader = new RespHeader();
        magicOutDTO.setHeader(respHeader);

        try {
            AddAdvertInfoDTO addAdvertInfoDTO = new AddAdvertInfoDTO();
            BeanUtils.copyProperties(requestDTO.getBody(), addAdvertInfoDTO);
            boolean successFlag = advertService.addAdvertInfo(addAdvertInfoDTO);
            if (successFlag) {
                respHeader.setErrorCode(AdvertErrorEnum.SUCCESS.code());
                respHeader.setErrorMsg(AdvertErrorEnum.SUCCESS.msg());
            } else {
                respHeader.setErrorCode(AdvertErrorEnum.ADDFAIL.code());
                respHeader.setErrorMsg(AdvertErrorEnum.ADDFAIL.msg());
            }
        } catch (Exception e) {
            e.printStackTrace();
            respHeader.setErrorCode(AdvertErrorEnum.ERROR.code());
            respHeader.setErrorMsg(AdvertErrorEnum.ERROR.msg());
        }

        return magicOutDTO;
    }

    /**
     * 广告列表查询
     * @param requestDTO
     * @return
     * @author jianggq@belink.com
     */
    @Override
    public MagicOutDTO<AdvertSelOutDTO> selAdvertInfo(MagicDTO<AdvertSelDTO> requestDTO) {
        //定义出参
        AdvertSelOutDTO advertSelOutPageDTO = new AdvertSelOutDTO();
        MagicOutDTO<AdvertSelOutDTO> magicOutDTO = new MagicOutDTO<>(advertSelOutPageDTO);

        //定义返回头
        RespHeader respHeader = new RespHeader();
        magicOutDTO.setHeader(respHeader);

        //获取请求头
        ReqHeader reqHead = requestDTO.getHeader();

        //转换请求DTO
        AdvertSelDTO reqBody = requestDTO.getBody();
        SelAdvertInfoDTO selAdvertInfoDTO = new SelAdvertInfoDTO();
        BeanUtils.copyProperties(reqBody, selAdvertInfoDTO);

        try {
            //执行查询
            SelAdvertInfoOutDTO selAdvertInfoOutDTO = advertService.selAdvertInfo(selAdvertInfoDTO);
            //转换返回DTO
            BeanUtils.copyProperties(selAdvertInfoOutDTO,advertSelOutPageDTO);
            //封装返回的数据
            respHeader.setErrorCode(AdvertErrorEnum.SUCCESS.code());
            respHeader.setErrorMsg(AdvertErrorEnum.SUCCESS.msg());
            magicOutDTO.setBody(advertSelOutPageDTO);
            ApplicationServiceUtil.supplementaryRespHeader(reqHead, respHeader);
        } catch (Exception e) {
            e.printStackTrace();
            respHeader.setErrorCode(AdvertErrorEnum.SELFAIL.code());
            respHeader.setErrorMsg(AdvertErrorEnum.SELFAIL.msg());
        }
        return magicOutDTO;
    }

    /**
     * 通过主键id删除广告
     * @param requestDTO
     * @return
     * @author tangw@belink.com
     */
	@Override
	public MagicOutDTO<AdvertDelOutDTO> delAdvertInfo(MagicDTO<AdvertDelDTO> requestDTO) {
		AdvertDelOutDTO delOutDTO = new AdvertDelOutDTO();
        MagicOutDTO<AdvertDelOutDTO> magicOutDTO = new MagicOutDTO<>(delOutDTO);
        RespHeader respHeader = new RespHeader();
        magicOutDTO.setHeader(respHeader);
		try{
			DelAdvertInfoDTO delAdvertInfoDTO = new DelAdvertInfoDTO();
			delAdvertInfoDTO.setAiAdvId(requestDTO.getBody().getAiAdvId());
			boolean successFlag = advertService.delAdvertInfo(delAdvertInfoDTO);
			if (successFlag) {
                respHeader.setErrorCode(AdvertErrorEnum.SUCCESS.code());
                respHeader.setErrorMsg(AdvertErrorEnum.SUCCESS.msg());
            } else {
                respHeader.setErrorCode(AdvertErrorEnum.DELFAIL.code());
                respHeader.setErrorMsg(AdvertErrorEnum.DELFAIL.msg());
            }
		} catch (Exception e) {
			e.getStackTrace();
            respHeader.setErrorCode(AdvertErrorEnum.ERROR.code());
            respHeader.setErrorMsg(AdvertErrorEnum.ERROR.msg());
		}
		return magicOutDTO;
	}

    /**
     * 广告配置修改
     * @param requestDTO
     * @return
     * @author luolf@belink.com
     */
    @Override
    public MagicOutDTO<AdvertUpdOutDTO> updAdvertInfo(MagicDTO<AdvertUpdDTO> requestDTO) {
        AdvertUpdOutDTO updOutData = new AdvertUpdOutDTO();
        MagicOutDTO<AdvertUpdOutDTO> magicOutDTO = new MagicOutDTO<>(updOutData);

        RespHeader respHeader = new RespHeader();
        magicOutDTO.setHeader(respHeader);

        try {
            //判断执行是否为修改操作，不是直接返回失败信息
            Integer advertStatus = requestDTO.getBody().getAiAdvStatus();
            if (null != advertStatus && Constant.ADVERT_DELETE_STATUS_CODE == advertStatus) {
                respHeader.setErrorCode(AdvertErrorEnum.UPDFAIL.code());
                respHeader.setErrorMsg(AdvertErrorEnum.UPDFAIL.msg());
                return magicOutDTO;
            }
            UpdAdvertInfoDTO updAdvertInfoDTO = new UpdAdvertInfoDTO();
            BeanUtils.copyProperties(requestDTO.getBody(), updAdvertInfoDTO);
            boolean successFlag = advertService.updAdvertInfo(updAdvertInfoDTO);
            if (successFlag) {
                respHeader.setErrorCode(AdvertErrorEnum.SUCCESS.code());
                respHeader.setErrorMsg(AdvertErrorEnum.SUCCESS.msg());
            } else {
                if (null != advertStatus && Constant.ADVERT_PUT_STATUS_CODE == advertStatus) {
                    respHeader.setErrorCode(AdvertErrorEnum.PUTFAIL.code());
                    respHeader.setErrorMsg(AdvertErrorEnum.PUTFAIL.msg());
                } else if (null != advertStatus && Constant.ADVERT_SOLD_STATUS_CODE == advertStatus) {
                    respHeader.setErrorCode(AdvertErrorEnum.SOLDFAIL.code());
                    respHeader.setErrorMsg(AdvertErrorEnum.SOLDFAIL.msg());
                } else {
                    respHeader.setErrorCode(AdvertErrorEnum.UPDFAIL.code());
                    respHeader.setErrorMsg(AdvertErrorEnum.UPDFAIL.msg());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            respHeader.setErrorCode(AdvertErrorEnum.ERROR.code());
            respHeader.setErrorMsg(AdvertErrorEnum.ERROR.msg());
        }

        return magicOutDTO;
    }
    
    /**
     * 广告栏位基础字典查询
     * @param requestDTO
     * @return
     * @author jianggq@belink.com
     */
	@Override
	public MagicOutDTO<AdvertColumnOutDTO> selAdvertColInfo(MagicDTO<AdvertColumnDTO> requestDTO) {
		//定义出参
		AdvertColumnOutDTO advertColumnOutDTO = new AdvertColumnOutDTO();
        MagicOutDTO<AdvertColumnOutDTO> magicOutDTO = new MagicOutDTO<>(advertColumnOutDTO);

        //定义返回头
        RespHeader respHeader = new RespHeader();
        magicOutDTO.setHeader(respHeader);

        //获取请求头
        ReqHeader reqHead = requestDTO.getHeader();
        AdvertColumnDTO reqbody = requestDTO.getBody();
        //参数判断
        String bsCodeType = reqbody.getBsCodeType();
        if(!bsCodeType.equals(Constant.ADVERT_COLUMN_TYPE))
        	throw new RuntimeException("广告栏位类型不匹配");
        
        //转换请求DTO
        SelAdvertColInfoDTO selAdvertColInfoDTO = new SelAdvertColInfoDTO();
        BeanUtils.copyProperties(reqbody, selAdvertColInfoDTO);
        try {
            //执行查询
        	SelAdvertColInfoOutDTO selAdvertColInfoOutDTO = advertService.selAdvertColInfo(selAdvertColInfoDTO);
            //转换返回DTO
            BeanUtils.copyProperties(selAdvertColInfoOutDTO,advertColumnOutDTO);
            //封装返回的数据
            respHeader.setErrorCode(AdvertErrorEnum.SUCCESS.code());
            respHeader.setErrorMsg(AdvertErrorEnum.SUCCESS.msg());
            magicOutDTO.setBody(advertColumnOutDTO);
            ApplicationServiceUtil.supplementaryRespHeader(reqHead, respHeader);
        } catch (Exception e) {
            e.printStackTrace();
            respHeader.setErrorCode(AdvertErrorEnum.SELFAIL.code());
            respHeader.setErrorMsg(AdvertErrorEnum.SELFAIL.msg());
        }
        return magicOutDTO;
	}

}
