package com.magic.basiccenter.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gift.domain.sequence.factory.SequenceFactory;
import com.magic.basiccenter.constants.Constant;
import com.magic.basiccenter.dto.entity.DocumentBean;
import com.magic.basiccenter.model.dto.*;
import com.magic.basiccenter.model.entity.BsDocumentInf;
import com.magic.basiccenter.model.service.DocumentService;
import com.magic.basiccenter.model.service.IBsDocumentService;
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
public class DocumentServiceImpl implements DocumentService {
	
    @Autowired
    private IBsDocumentService documentService;
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
        //调用api实现回显
        BsDocumentInf byId = documentService.getById(documentIdDto.getDocsId());
        //克隆对象属性
        BeanUtils.copyProperties(byId,dto);
        return dto;
    }

    /**
     * 数据修改
     * @param documentDto
     * @return
     */
    @Override
    public DocmentUpdataDTO queryModify(DocumentDTO documentDto) {
        DocmentUpdataDTO dto = new DocmentUpdataDTO();
        BsDocumentInf entity = new BsDocumentInf();
        //克隆对象属性
        BeanUtils.copyProperties(documentDto,entity);
        //调用api实现修改
        boolean b = documentService.updateById(entity);
        //生成业务状态码
        dto.setDocumentUpdataStat(b ? 0 : 2);
        return dto;
    }

    /**
     * 文档发布
     * @param documentDto
     * @return
     */
    @Override
    public DocumentOutDTO publish(DocumentInputDTO documentDto) {
        DocumentOutDTO dto = new DocumentOutDTO();
        BsDocumentInf entity = new BsDocumentInf();

        entity.setDocsId(documentDto.getDocsId()).setState(documentDto.getState());
        entity.setDocumentPubdate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        //调用Api实现发布
        boolean b = documentService.updateById(entity);
        //生成业务状态码
        dto.setState(b ? 0 : 2);
        return dto;
        }

    /**
     * 文档删除
     * @param documentDto
     * @return
     */
    @Override
    public DocmentUpdataDTO delete(DocumentIdDTO documentDto) {
        DocmentUpdataDTO dto = new DocmentUpdataDTO();
        BsDocumentInf entity = new BsDocumentInf();
        //获取数据id
        entity.setDocsId(documentDto.getDocsId());
        //设置数据的生命id （0 生存，1 死亡）
        entity.setDocLife("1");
        boolean b = documentService.updateById(entity);
        //生成业务状态码
        dto.setDocumentUpdataStat(b ? 0 : 2);
        return dto;
    }

    /**
     * 新增
     * @param inputDTO
     * @return
     */
    @Override
    public DocmentUpdataDTO addDocumentState(DocumentDTO inputDTO) {

        DocmentUpdataDTO document =new DocmentUpdataDTO();
        BsDocumentInf entity = new BsDocumentInf();
        //获取当前时间
        inputDTO.setDocumentCtime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()))
                .setDocumentMtime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        //设置文档状态
        inputDTO.setState(00);
        //设置数据的生命id （0 生存，1 死亡）
        inputDTO.setDocLife("0");
        //id生成
        String id = sequenceFactory.getSegmentFillZeroId(Constant.DOC_ID);
        inputDTO.setDocsId(id);
        //属性克隆
        BeanUtils.copyProperties(inputDTO,entity);

        boolean b = documentService.save(entity);
        //生成业务状态码
        document.setDocumentUpdataStat(b ? 0 : 2);
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
		/**
		 * 查询文档列表
		 * @param inputDTO
		 * @return
		 */
        BsDocumentInf inf = new BsDocumentInf();
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
                .between(!StringUtils.isEmpty(startTime), BsDocumentInf::getDocumentPubdate, startTime, endTime)
                .orderByDesc(BsDocumentInf::getDocumentPubdate);

		//进行分页查询
		iPage = documentService.page(iPage,queryWrapper);
		
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
        System.out.println(documentBeanList.toString());
        List<String> catalogNameList = documentService.queryCatalogNameList();
        outData.setDocsList(documentBeanList);
		outData.setTurnPageTotalNum(total);
		outData.setCatalogNameList(catalogNameList);
		return outData;
	
	}
}
