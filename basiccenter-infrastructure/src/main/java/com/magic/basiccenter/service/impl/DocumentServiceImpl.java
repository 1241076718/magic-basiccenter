package com.magic.basiccenter.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.magic.basiccenter.dto.entity.DocumentBean;
import com.magic.basiccenter.model.dto.*;
import com.magic.basiccenter.model.entity.BsDocumentInf;
import com.magic.basiccenter.model.mapper.BsDocumentInfMapper;
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
	private BsDocumentInfMapper bsDocumentInfMapper;
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
        entity.setDocsId(documentDto.getDocsId());
        boolean b = documentService.removeById(entity);
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
        //属性克隆
        BeanUtils.copyProperties(inputDTO,entity);

        boolean b = documentService.save(entity);
        //生成业务状态码
        document.setDocumentUpdataStat(b ? 0 : 2);
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
			
		QueryDocumentOutDTO outData = new QueryDocumentOutDTO();
		Integer currentPage = inputDTO.getCurrentPage();
		Integer turnPageShowNum = inputDTO.getTurnPageShowNum();
		String docsName = inputDTO.getDocsName();
		String catalogName = inputDTO.getCatalogName();
		String startTime = inputDTO.getStartTime();
		String endTime = inputDTO.getEndTime();
		
		//mybatisPlus 分页API
		Page<BsDocumentInf> iPage = new Page<BsDocumentInf>(currentPage,turnPageShowNum);
		QueryWrapper<BsDocumentInf> queryWrapper = new QueryWrapper<BsDocumentInf>();
		queryWrapper.eq(!StringUtils.isEmpty(docsName), "DOC_TYPE", docsName)
					.like(!StringUtils.isEmpty(catalogName), "DOC_TITLE", catalogName)
					.between(!StringUtils.isEmpty(startTime), "DOC_PUBDATE", startTime, endTime)
					.orderByDesc("DOC_PUBDATE");
		//进行分页查询
		iPage = bsDocumentInfMapper.selectPage(iPage, queryWrapper);
		
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
		outData.setDocsList(documentBeanList);
		outData.setTurnPageTotalNum(total);
		return outData;
	
	}
}
