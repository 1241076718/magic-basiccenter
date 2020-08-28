package com.magic.basiccenter.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gift.domain.sequence.factory.SequenceFactory;
import com.magic.basiccenter.constants.Constant;
import com.magic.basiccenter.dto.entity.DocumentBean;
import com.magic.basiccenter.dto.entity.DocumentTypeBean;
import com.magic.basiccenter.model.dto.*;
import com.magic.basiccenter.model.entity.BsDocumentInf;
import com.magic.basiccenter.model.entity.BsDocumentType;
import com.magic.basiccenter.model.service.DocumentManageService;
import com.magic.basiccenter.model.service.IBsDocumentService;
import com.magic.basiccenter.model.service.IBsDocumentTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 后端接口实现
 */
@Service
public class DocumentManageServiceImpl implements DocumentManageService {
	
    @Autowired
    private IBsDocumentService bsDocumentService;

    @Autowired
    private IBsDocumentTypeService bsDocumentTypeService;

    @Autowired
    SequenceFactory sequenceFactory;
    /**
     * 数据回显
     * @param documentIdDto
     * @return
     */
    @Override
    public DocumentDTO queryData(DocumentIdDTO documentIdDto) {
        DocumentDTO dto = new DocumentDTO();
        BsDocumentInf entity = new BsDocumentInf();
        BsDocumentInf byId1 = bsDocumentService.getById(entity.getDocsId());
        if (byId1.getDocLife().equals(LifeDTO.DEATH)){
            return null;
        }else {
            //调用api实现回显
            BsDocumentInf byId = bsDocumentService.getById(entity.getDocsId());
            //克隆对象属性
            BeanUtils.copyProperties(byId, dto);
            return dto;
        }
    }

    /**
     * 数据修改
     * @param documentDto
     * @return
     */
    @Override
    public DocumentStateDTO queryModify(DocumentDTO documentDto) {
        DocumentStateDTO dto = new DocumentStateDTO();
        BsDocumentInf entity = new BsDocumentInf();
        //克隆对象属性
        BeanUtils.copyProperties(documentDto, entity);
        BsDocumentInf byId1 = bsDocumentService.getById(entity.getDocsId());
        if (byId1.getDocLife().equals(LifeDTO.DEATH)){
            dto.setState(3);
            return dto;
        }else {
            //调用api实现修改
            boolean b = bsDocumentService.updateById(entity);
            //生成业务状态码
            dto.setDocsId(entity.getDocsId());
            dto.setState(b ? 0 : 2);
            return dto;
        }
    }

    /**
     * 文档发布
     * @param documentDto
     * @return
     */
    @Override
    public DocumentStateDTO publish(DocumentInputDTO documentDto) {
        DocumentStateDTO dto = new DocumentStateDTO();
        BsDocumentInf entity = new BsDocumentInf();
        entity.setDocsId(documentDto.getDocsId()).setState(documentDto.getState());
        BsDocumentInf byId1 = bsDocumentService.getById(entity.getDocsId());
        if (byId1.getDocLife().equals(LifeDTO.DEATH)){
            dto.setState(3);
            return dto;
        }else {
            //非空校验
            if (null == documentDto.getState()) {
                dto.setState(4);
                return dto;
            } else {
                entity.setDocumentPubdate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
                //调用Api实现发布
                boolean b = bsDocumentService.updateById(entity);
                //生成业务状态码
                dto.setState(b ? 0 : 2);
                return dto;
            }
        }
    }

    /**
     * 文档删除
     * @param documentDto
     * @return
     */
    @Override
    public DocumentStateDTO delete(DocumentIdDTO documentDto) {
        DocumentStateDTO dto = new DocumentStateDTO();
        BsDocumentInf entity = new BsDocumentInf();
        //获取数据id
        entity.setDocsId(documentDto.getDocsId());
        BsDocumentInf byId1 = bsDocumentService.getById(entity.getDocsId());
        if (byId1.getDocLife().equals(LifeDTO.DEATH)){
            dto.setState(2);
        }if (byId1.getState().equals(ReleaseDTO.THESHELVES)){
                //设置数据的生命id （0 生存，1 死亡）
                entity.setDocLife("1");
                boolean b = bsDocumentService.updateById(entity);
                //生成业务状态码
                dto.setState(b ? 0 : 2);
        }
        return dto;
    }

    /**
     * 新增
     * @param inputDTO
     * @return
     */
    @Override
    public DocumentStateDTO addDocumentState(DocumentDTO inputDTO) {

        DocumentStateDTO document =new DocumentStateDTO();
        BsDocumentInf entity = new BsDocumentInf();
        //获取当前时间
        inputDTO.setDocumentCtime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()))
                .setDocumentMtime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()))
                .setDocumentPubdate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        //设置文档状态
        inputDTO.setState(00);
        //设置数据的生命id （0 生存，1 死亡）
        inputDTO.setDocLife("0");
        //id生成
        String id = sequenceFactory.getSegmentFillZeroId(Constant.DOC_ID);
        inputDTO.setDocsId(id);
        //属性克隆
        BeanUtils.copyProperties(inputDTO,entity);

        boolean b = bsDocumentService.save(entity);
        //生成业务状态码
        document.setState(b ? 0 : 2);
        document.setDocsId(id);
        return document;
    }
    
    /**
     * 查询
     * @param inputDTO
     * @return
     */
	@Override
	public QueryDocumentOutDTO queryDocumentList(QueryDocumentDTO inputDTO) {
        QueryDocumentOutDTO outData = new QueryDocumentOutDTO();
        Integer currentPage = inputDTO.getCurrentPage();
        Integer turnPageShowNum = inputDTO.getTurnPageShowNum();
        String docsName = inputDTO.getDocsName();
        String catalogName = inputDTO.getCatalogName();
        String startTime = inputDTO.getStartTime();
        String endTime = inputDTO.getEndTime();

        //mybatisPlus 分页API
        Page<BsDocumentInf> iPage = new Page<BsDocumentInf>(currentPage,turnPageShowNum);
        LambdaQueryWrapper<BsDocumentInf> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapper.eq(!StringUtils.isEmpty(docsName), BsDocumentInf::getDocsName, docsName)
                .eq(BsDocumentInf::getDocLife, "0")
                .like(!StringUtils.isEmpty(catalogName), BsDocumentInf::getCatalogName, catalogName)
                .ge((!StringUtils.isEmpty(startTime)) && (StringUtils.isEmpty(endTime)), BsDocumentInf::getDocumentPubdate, startTime)
                .le((StringUtils.isEmpty(startTime)) && (!StringUtils.isEmpty(endTime)), BsDocumentInf::getDocumentPubdate, endTime)
                .between((!StringUtils.isEmpty(startTime)) && (!StringUtils.isEmpty(endTime)), BsDocumentInf::getDocumentPubdate, startTime, endTime)
                .orderByDesc(BsDocumentInf::getDocumentPubdate);

        //进行分页查询
        iPage = bsDocumentService.page(iPage,queryWrapper);

        //获取文档列表总数和列表信息
        int total = (int) iPage.getTotal();
        List<BsDocumentInf> docsList = iPage.getRecords();
        //遍历将数据放入DocumentBean
        List<DocumentBean> documentBeanList = new ArrayList<DocumentBean>();
        for(int i=0;i<docsList.size();i++) {
            DocumentBean documentBean = new DocumentBean();
            BeanUtils.copyProperties(docsList.get(i), documentBean);
            documentBeanList.add(documentBean);
        }
        //查询文档类型列表
        LambdaQueryWrapper<BsDocumentType> queryTypeWrapper = new LambdaQueryWrapper<>();
        queryTypeWrapper.eq(BsDocumentType::getInvalid, LifeDTO.SURVIVAL);
        List<BsDocumentType> documentTypeList = bsDocumentTypeService.list(queryTypeWrapper);
        //遍历将数据放入BsDocumentType
        ArrayList<DocumentTypeBean> typeBeanList = new ArrayList<>();
        for (BsDocumentType bsDocumentType : documentTypeList) {
            DocumentTypeBean documentTypeBean = new DocumentTypeBean();
            BeanUtils.copyProperties(bsDocumentType, documentTypeBean);
            typeBeanList.add(documentTypeBean);
        }

        outData.setDocsList(documentBeanList);
        outData.setTurnPageTotalNum(total);
        outData.setCatalogNameList(typeBeanList);
        return outData;
	
	}
}