package com.magic.basiccenter.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.magic.basiccenter.dto.DocumentFacadeDto;
import com.magic.basiccenter.model.dto.*;
import com.magic.basiccenter.model.entity.DocumentEntity;
import com.magic.basiccenter.model.service.DocumentService;
import com.magic.basiccenter.model.service.InteractionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class InteractionServiceImpl implements InteractionService {
    @Autowired
    DocumentService documentService;
    /**
     * 数据回显
     * @param documentIdDto
     * @return
     */
    @Override
    public DocumentDto queryData(DocumentIdDto documentIdDto) {
        DocumentDto dto = new DocumentDto();
        DocumentEntity byId = documentService.getById(documentIdDto.getDocsId());
        BeanUtils.copyProperties(byId,dto);
        return dto;
    }

    /**
     * 数据修改
     * @param documentDto
     * @return
     */
    @Override
    public DocmentUpdataDto queryModify(DocumentDto documentDto) {
        DocmentUpdataDto dto = new DocmentUpdataDto();
        DocumentEntity entity = new DocumentEntity();
        BeanUtils.copyProperties(documentDto,entity);
        boolean b = documentService.updateById(entity);
        dto.setDocumentUpdataStat(b ? 0 : 2);
        return dto;
    }

    /**
     * 文档发布
     * @param documentDto
     * @return
     */
    @Override
    public DocumentOutDTO publish(DocumentInputDto documentDto) {
        DocumentOutDTO dto = new DocumentOutDTO();
        DocumentEntity entity = new DocumentEntity();
        entity.setDocsId(documentDto.getDocsId()).setState(documentDto.getState());
        boolean b = documentService.updateById(entity);
        dto.setState(b ? 0 : 2);
        return dto;
        }

    /**
     * 文档删除
     * @param documentDto
     * @return
     */
    @Override
    public DocmentUpdataDto delete(DocumentIdDto documentDto) {
        DocmentUpdataDto dto = new DocmentUpdataDto();
        DocumentEntity entity = new DocumentEntity();
        entity.setDocsId(documentDto.getDocsId());
        boolean b = documentService.removeById(entity);
        dto.setDocumentUpdataStat(b ? 0 : 2);
        return dto;
    }

    /**
     * 根据文档标题查询
     * @param inputDTO
     * @return
     */
    @Override
    public QueryDocumentOutDTO queryTitleList(QueryDocumentDTO inputDTO) {
        QueryDocumentOutDTO outData = new QueryDocumentOutDTO();
        int currentPage = inputDTO.getCurrentPage();
        int turnPageShowNum = inputDTO.getTurnPageShowNum();
        String docTitle = inputDTO.getDocsName();

        Page<DocumentEntity> iPage = new Page<>(currentPage,turnPageShowNum);
        QueryWrapper<DocumentEntity> queryWrapper = new QueryWrapper<DocumentEntity>();
        queryWrapper.eq("DOC_TITLE", docTitle).orderByDesc("DOC_PUBDATE");
        iPage = documentService.page(iPage,queryWrapper);

        int total = (int)iPage.getTotal();
        List<DocumentEntity> docsList = iPage.getRecords();
        DocumentFacadeDto dto = new DocumentFacadeDto();
        List<DocumentFacadeDto> list = null;
        for(int i = 0;i < docsList.size(); i++){
            DocumentEntity entity = docsList.get(i);
            BeanUtils.copyProperties(entity,dto);
            list.add(dto);
        }

        outData.setDocsList(list);
        outData.setTotal(total);

        return outData;
    }

    @Override
    public QueryDocumentOutDTO queryTypeList(QueryDocumentDTO inputDTO) {
        QueryDocumentOutDTO outData = new QueryDocumentOutDTO();
        int currentPage = inputDTO.getCurrentPage();
        int turnPageShowNum = inputDTO.getTurnPageShowNum();
        String docType = inputDTO.getCatalogName();

        Page<DocumentEntity> iPage = new Page<>(currentPage,turnPageShowNum);
        QueryWrapper<DocumentEntity> queryWrapper = new QueryWrapper<DocumentEntity>();
        queryWrapper.eq("DOC_TYPE", docType).orderByDesc("DOC_PUBDATE");
        iPage = documentService.page(iPage,queryWrapper);

        int total = (int)iPage.getTotal();
        List<DocumentEntity> docsList = iPage.getRecords();
        DocumentFacadeDto dto = new DocumentFacadeDto();
        List<DocumentFacadeDto> list = null;
        for(int i = 0;i < docsList.size(); i++){
            DocumentEntity entity = docsList.get(i);
            BeanUtils.copyProperties(entity,dto);
            list.add(dto);
        }
        outData.setDocsList(list);
        outData.setTotal(total);

        return outData;
    }

    @Override
    public QueryDocumentOutDTO queryPubdateList(QueryDocumentDTO inputDTO) {
        QueryDocumentOutDTO outData = new QueryDocumentOutDTO();
        int currentPage = inputDTO.getCurrentPage();
        int turnPageShowNum = inputDTO.getTurnPageShowNum();
        String docPubdate = inputDTO.getDocumentPubdate();

        Page<DocumentEntity> iPage = new Page<>(currentPage,turnPageShowNum);
        QueryWrapper<DocumentEntity> queryWrapper = new QueryWrapper<DocumentEntity>();
        queryWrapper.eq("DOC_PUBDATE", docPubdate).orderByDesc("DOC_PUBDATE");
        iPage = documentService.page(iPage,queryWrapper);

        int total = (int)iPage.getTotal();
        List<DocumentEntity> docsList = iPage.getRecords();
        DocumentFacadeDto dto = new DocumentFacadeDto();
        List<DocumentFacadeDto> list = null;
        for(int i = 0;i < docsList.size(); i++){
            DocumentEntity entity = docsList.get(i);
            BeanUtils.copyProperties(entity,dto);
            list.add(dto);
        }
        outData.setDocsList(list);
        outData.setTotal(total);

        return outData;
    }

    /**
     * 新增
     * @param inputDTO
     * @return
     */
    @Override
    public DocmentUpdataDto addDocumentState(DocumentDto inputDTO) {

        DocmentUpdataDto document =new DocmentUpdataDto();
        DocumentEntity entity = new DocumentEntity();
        inputDTO.setDocumentCtime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()))
                .setDocumentMtime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        BeanUtils.copyProperties(inputDTO,entity);

        boolean b = documentService.save(entity);
        document.setDocumentUpdataStat(b ? 0 : 2);
        return document;
    }
}
