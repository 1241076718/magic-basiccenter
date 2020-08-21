package com.magic.basiccenter.model.serviceimpl;


import com.magic.application.infrastructure.service.dto.MagicDTO;
import com.magic.application.infrastructure.service.dto.MagicOutDTO;
import com.magic.application.infrastructure.service.dto.data.RespHeader;
import com.magic.basiccenter.dto.*;
import com.magic.basiccenter.error.BasicErrorEnum;
import com.magic.basiccenter.model.dto.*;
import com.magic.basiccenter.model.service.InteractionService;
import com.magic.basiccenter.service.ModifyService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public class ModifyServiceImpl implements ModifyService {

    /**
     * 公共数据交互端
     */
    @Autowired
    InteractionService service;
    /**
     * 数据回显
     * @param requestDTO
     * @return
     */
    @Override
    public MagicOutDTO<DocumentFacadeDto> queryData(MagicDTO<DocumentFacadeIdDto> requestDTO) {
        DocumentFacadeDto dto = new DocumentFacadeDto();
        MagicOutDTO<DocumentFacadeDto> documentFacadeDtoMagicDTO = new MagicOutDTO<>(dto);

        RespHeader respHead = new RespHeader();
        documentFacadeDtoMagicDTO.setHeader(respHead);
        try {

            String Document = requestDTO.getBody().getDocsId();

            DocumentIdDto documentDto = new DocumentIdDto();
            documentDto.setDocsId(Document);

            DocumentDto documentDto1 = service.queryData(documentDto);

            BeanUtils.copyProperties(documentDto1,dto);
            if(dto == null) {
                respHead.setErrorCode(BasicErrorEnum.FAIL.code());
                respHead.setErrorMsg(BasicErrorEnum.FAIL.msg());
            }else {
                respHead.setErrorCode(BasicErrorEnum.SUCCESS.code());
                respHead.setErrorMsg(BasicErrorEnum.SUCCESS.msg());
            }
        } catch (Exception e) {
            e.printStackTrace();
            respHead.setErrorCode("-1");
            respHead.setErrorMsg(e.getMessage());
        }
        return documentFacadeDtoMagicDTO;
    }

    /**
     * 数据修改
     * @param requestDTO
     * @return
     */
    @Override
    public MagicOutDTO<DocmentFacadeUpdataDto> queryModify(MagicDTO<DocumentFacadeDto> requestDTO) {
        DocmentFacadeUpdataDto dto = new DocmentFacadeUpdataDto();
        MagicOutDTO<DocmentFacadeUpdataDto> documentDTO = new MagicOutDTO<>(dto);

        RespHeader respHead = new RespHeader();
        documentDTO.setHeader(respHead);
        try {

            DocumentFacadeDto Document = requestDTO.getBody();

            DocumentDto documentDto = new DocumentDto();
            BeanUtils.copyProperties(Document,documentDto);


            DocmentUpdataDto docmentUpdataDto = service.queryModify(documentDto);

            dto.setDocumentUpdataStat(docmentUpdataDto.getDocumentUpdataStat());
            if (dto.getDocumentUpdataStat() == 2){
                respHead.setErrorCode(BasicErrorEnum.FAIL.code());
                respHead.setErrorMsg(BasicErrorEnum.FAIL.msg());
            }else {
                respHead.setErrorCode(BasicErrorEnum.SUCCESS.code());
                respHead.setErrorMsg(BasicErrorEnum.SUCCESS.msg());
            }
        } catch (Exception e) {
            e.printStackTrace();
            respHead.setErrorCode("-1");
            respHead.setErrorMsg(e.getMessage());
        }
        return documentDTO;
    }

    /**
     * 文档发布
     * @param requestDTO
     * @return
     */
    @Override
    public MagicOutDTO<DocumentFacadeOutDTO> publish(MagicDTO<DocumentFacadeInputDto> requestDTO) {
        DocumentFacadeOutDTO dto = new DocumentFacadeOutDTO();
        MagicOutDTO<DocumentFacadeOutDTO> documentDTO = new MagicOutDTO<>(dto);

        RespHeader respHead = new RespHeader();
        documentDTO.setHeader(respHead);
        try {

            DocumentFacadeInputDto Document = requestDTO.getBody();

            DocumentInputDto documentDto = new DocumentInputDto();
            BeanUtils.copyProperties(Document,documentDto);


            DocumentOutDTO publish = service.publish(documentDto);

            dto.setState(publish.getState());
            if (dto.getState() == 2){
                respHead.setErrorCode(BasicErrorEnum.FAIL.code());
                respHead.setErrorMsg(BasicErrorEnum.FAIL.msg());
            }else {
                respHead.setErrorCode(BasicErrorEnum.SUCCESS.code());
                respHead.setErrorMsg(BasicErrorEnum.SUCCESS.msg());
            }
        } catch (Exception e) {
            e.printStackTrace();
            respHead.setErrorCode("-1");
            respHead.setErrorMsg(e.getMessage());
        }
        return documentDTO;
    }

    /**
     * 文档删除
     * @param requestDTO
     * @return
     */
    @Override
    public MagicOutDTO<DocmentFacadeUpdataDto> delete(MagicDTO<DocumentFacadeIdDto> requestDTO) {
        DocmentFacadeUpdataDto dto = new DocmentFacadeUpdataDto();
        MagicOutDTO<DocmentFacadeUpdataDto> documentDTO = new MagicOutDTO<>(dto);

        RespHeader respHead = new RespHeader();
        documentDTO.setHeader(respHead);
        try {

            DocumentFacadeIdDto body = requestDTO.getBody();
            DocumentIdDto documentIdDto = new DocumentIdDto();
            documentIdDto.setDocsId(body.getDocsId());
            BeanUtils.copyProperties(body,documentIdDto);


            DocmentUpdataDto delete = service.delete(documentIdDto);

            dto.setDocumentUpdataStat(delete.getDocumentUpdataStat());
            if (dto.getDocumentUpdataStat() == 2){
                respHead.setErrorCode(BasicErrorEnum.FAIL.code());
                respHead.setErrorMsg(BasicErrorEnum.FAIL.msg());
            }else {
                respHead.setErrorCode(BasicErrorEnum.SUCCESS.code());
                respHead.setErrorMsg(BasicErrorEnum.SUCCESS.msg());
            }
        } catch (Exception e) {
            e.printStackTrace();
            respHead.setErrorCode("-1");
            respHead.setErrorMsg(e.getMessage());
        }
        return documentDTO;
    }

    /**
     * 查询
     * @param requestDTO
     * @return
     */
    @Override
    public MagicOutDTO<QueryDocumentListOutDTO> queryDocumentList(MagicDTO<QueryDocumentListDTO> requestDTO) {

        QueryDocumentListOutDTO outData = new QueryDocumentListOutDTO();
        MagicOutDTO<QueryDocumentListOutDTO> magicOutDTO = new MagicOutDTO<>(outData);

        RespHeader respHead = new RespHeader();
        magicOutDTO.setHeader(respHead);

        try {

            String docTitle = requestDTO.getBody().getDocsName();
            String docType = requestDTO.getBody().getCatalogName();
            String docPubdate = requestDTO.getBody().getDocumentPubdate();
            Integer currentPage = requestDTO.getBody().getCurrentPage();
            Integer turnPageShowNum = requestDTO.getBody().getTurnPageShowNum();
            if(docTitle != null) {
                //根据标题查询
                QueryDocumentDTO queryDocumentDTO = new QueryDocumentDTO();
                queryDocumentDTO.setDocsName(docTitle);
                queryDocumentDTO.setCurrentPage(currentPage);
                queryDocumentDTO.setTurnPageShowNum(turnPageShowNum);


                QueryDocumentOutDTO queryTitleList = service.queryTitleList(queryDocumentDTO);
                outData.setTotal(queryTitleList.getTotal());
                outData.setDocsList(queryTitleList.getDocsList());
            }
            if(docType != null) {
                //根据类型查询
                QueryDocumentDTO queryDocumentDTO = new QueryDocumentDTO();
                queryDocumentDTO.setCatalogName(docType);
                queryDocumentDTO.setCurrentPage(currentPage);
                queryDocumentDTO.setTurnPageShowNum(turnPageShowNum);

                QueryDocumentOutDTO queryTypeList = service.queryTypeList(queryDocumentDTO);
                outData.setTotal(queryTypeList.getTotal());
                outData.setDocsList(queryTypeList.getDocsList());
            }
            if(docPubdate != null) {
                //根据发布时间查询
                QueryDocumentDTO queryDocumentDTO = new QueryDocumentDTO();
                queryDocumentDTO.setDocumentPubdate(docPubdate);
                queryDocumentDTO.setCurrentPage(currentPage);
                queryDocumentDTO.setTurnPageShowNum(turnPageShowNum);

                QueryDocumentOutDTO queryPubdateList = service.queryPubdateList(queryDocumentDTO);
                outData.setTotal(queryPubdateList.getTotal());
                outData.setDocsList(queryPubdateList.getDocsList());
            }
            if (outData == null){
                respHead.setErrorCode(BasicErrorEnum.FAIL.code());
                respHead.setErrorMsg(BasicErrorEnum.FAIL.msg());
            }else {
                respHead.setErrorCode(BasicErrorEnum.SUCCESS.code());
                respHead.setErrorMsg(BasicErrorEnum.SUCCESS.msg());
            }
        } catch (Exception e) {
            e.printStackTrace();
            respHead.setErrorCode("-1");
            respHead.setErrorMsg(e.getMessage());
        }

        return magicOutDTO;
    }

    /**
     * 新增
     * @param requestDTO
     * @return
     */
    @Override
    public MagicOutDTO<DocmentFacadeUpdataDto> addDocumentState(MagicDTO<DocumentFacadeDto> requestDTO) {
        DocmentFacadeUpdataDto dto = new DocmentFacadeUpdataDto();
        MagicOutDTO<DocmentFacadeUpdataDto> documentFacadeDtoMagicDTO = new MagicOutDTO<>(dto);

        RespHeader respHead = new RespHeader();
        documentFacadeDtoMagicDTO.setHeader(respHead);
        try {
            DocumentFacadeDto body = requestDTO.getBody();

            DocumentDto documentDto = new DocumentDto();
            BeanUtils.copyProperties(body,documentDto);

            DocmentUpdataDto updataDto = service.addDocumentState(documentDto);

            if (updataDto.getDocumentUpdataStat() == 2){
                respHead.setErrorCode(BasicErrorEnum.FAIL.code());
                respHead.setErrorMsg(BasicErrorEnum.FAIL.msg());
            }else {
                respHead.setErrorCode(BasicErrorEnum.SUCCESS.code());
                respHead.setErrorMsg(BasicErrorEnum.SUCCESS.msg());
            }
        } catch (Exception e) {
            e.printStackTrace();
            respHead.setErrorCode("-1");
            respHead.setErrorMsg(e.getMessage());
        }
        return documentFacadeDtoMagicDTO;
    }
}