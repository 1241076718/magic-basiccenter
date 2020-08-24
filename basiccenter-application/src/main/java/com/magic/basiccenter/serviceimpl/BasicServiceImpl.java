package com.magic.basiccenter.serviceimpl;


import com.gift.domain.sequence.factory.SequenceFactory;
import com.magic.application.infrastructure.service.dto.MagicDTO;
import com.magic.application.infrastructure.service.dto.MagicOutDTO;
import com.magic.application.infrastructure.service.dto.data.RespHeader;
import com.magic.basiccenter.dto.*;
import com.magic.basiccenter.error.BasicErrorEnum;
import com.magic.basiccenter.model.dto.*;
import com.magic.basiccenter.model.dto.constart.Constart;
import com.magic.basiccenter.model.service.DocumentService;
import com.magic.basiccenter.service.BasicService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 前端接口实现
 */
public class BasicServiceImpl implements BasicService {

    /**
     * 公共数据交互端
     */
    @Autowired
    DocumentService documentService;
    @Autowired
    SequenceFactory sequenceFactory;
    /**
     * 文档数据回显
     * @param requestDTO
     * @return
     */
    @Override
    public MagicOutDTO<DocumentFacadeDTO> queryData(MagicDTO<DocumentFacadeIdDTO> requestDTO) {
        DocumentFacadeDTO dto = new DocumentFacadeDTO();
        MagicOutDTO<DocumentFacadeDTO> documentFacadeDtoMagicDTO = new MagicOutDTO<>(dto);

        RespHeader respHead = new RespHeader();
        documentFacadeDtoMagicDTO.setHeader(respHead);
        try {

            String docsId = requestDTO.getBody().getDocsId();

            DocumentIdDTO documentDto = new DocumentIdDTO();

            documentDto.setDocsId(docsId);

            DocumentDTO documentDto1 = documentService.queryData(documentDto);

            BeanUtils.copyProperties(documentDto1,dto);
            if(null == dto.getDocsId()) {
                respHead.setErrorCode(BasicErrorEnum.REFERFATL.code());
                respHead.setErrorMsg(BasicErrorEnum.REFERFATL.msg());
            }else {
                respHead.setErrorCode(BasicErrorEnum.REFER.code());
                respHead.setErrorMsg(BasicErrorEnum.REFER.msg());
            }
        } catch (Exception e) {
            e.printStackTrace();
            respHead.setErrorCode("-1");
            respHead.setErrorMsg(e.getMessage());
        }
        return documentFacadeDtoMagicDTO;
    }

    /**
     * 文档数据修改
     * @param requestDTO
     * @return
     */
    @Override
    public MagicOutDTO<DocmentFacadeUpdataDTO> queryModify(MagicDTO<DocumentFacadeDTO> requestDTO) {
        DocmentFacadeUpdataDTO dto = new DocmentFacadeUpdataDTO();
        MagicOutDTO<DocmentFacadeUpdataDTO> documentDTO = new MagicOutDTO<>(dto);

        RespHeader respHead = new RespHeader();
        documentDTO.setHeader(respHead);
        try {

            DocumentFacadeDTO Document = requestDTO.getBody();

            DocumentDTO documentDto = new DocumentDTO();
            BeanUtils.copyProperties(Document,documentDto);


            DocmentUpdataDTO docmentUpdataDto = documentService.queryModify(documentDto);

            dto.setDocumentUpdataStat(docmentUpdataDto.getDocumentUpdataStat());

            if (2 == dto.getDocumentUpdataStat()){
                respHead.setErrorCode(BasicErrorEnum.MODIFYFATL.code());
                respHead.setErrorMsg(BasicErrorEnum.MODIFYFATL.msg());
            }else {
                respHead.setErrorCode(BasicErrorEnum.MODIFY.code());
                respHead.setErrorMsg(BasicErrorEnum.MODIFY.msg());
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
    public MagicOutDTO<DocumentFacadeOutDTO> publish(MagicDTO<DocumentFacadeInputDTO> requestDTO) {
        DocumentFacadeOutDTO dto = new DocumentFacadeOutDTO();
        MagicOutDTO<DocumentFacadeOutDTO> documentDTO = new MagicOutDTO<>(dto);

        RespHeader respHead = new RespHeader();
        documentDTO.setHeader(respHead);
        try {

            DocumentFacadeInputDTO document = requestDTO.getBody();

            DocumentInputDTO documentDto = new DocumentInputDTO();
            BeanUtils.copyProperties(document,documentDto);


            DocumentOutDTO publish = documentService.publish(documentDto);

            dto.setState(publish.getState());
            if (2 == dto.getState()){
                if (20 == document.getState()) {
                    respHead.setErrorCode(BasicErrorEnum.SHELVESFATL.code());
                    respHead.setErrorMsg(BasicErrorEnum.SHELVESFATL.msg());
                }{
                    respHead.setErrorCode(BasicErrorEnum.THESHELVESFATL.code());
                    respHead.setErrorMsg(BasicErrorEnum.THESHELVESFATL.msg());
                }
            }else {
                if (20 == document.getState()) {
                    respHead.setErrorCode(BasicErrorEnum.SHELVES.code());
                    respHead.setErrorMsg(BasicErrorEnum.SHELVES.msg());
                }{
                    respHead.setErrorCode(BasicErrorEnum.THEAHWLVES.code());
                    respHead.setErrorMsg(BasicErrorEnum.THEAHWLVES.msg());
                }
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
    public MagicOutDTO<DocmentFacadeUpdataDTO> delete(MagicDTO<DocumentFacadeIdDTO> requestDTO) {
        DocmentFacadeUpdataDTO dto = new DocmentFacadeUpdataDTO();
        MagicOutDTO<DocmentFacadeUpdataDTO> documentDTO = new MagicOutDTO<>(dto);

        RespHeader respHead = new RespHeader();
        documentDTO.setHeader(respHead);
        try {

            DocumentFacadeIdDTO body = requestDTO.getBody();
            DocumentIdDTO documentIdDto = new DocumentIdDTO();
            documentIdDto.setDocsId(body.getDocsId());
            BeanUtils.copyProperties(body,documentIdDto);


            DocmentUpdataDTO delete = documentService.delete(documentIdDto);

            dto.setDocumentUpdataStat(delete.getDocumentUpdataStat());
            if (2 == dto.getDocumentUpdataStat()){
                respHead.setErrorCode(BasicErrorEnum.DeleteFATL.code());
                respHead.setErrorMsg(BasicErrorEnum.DeleteFATL.msg());
            }else {
                respHead.setErrorCode(BasicErrorEnum.DELETE.code());
                respHead.setErrorMsg(BasicErrorEnum.DELETE.msg());
            }
        } catch (Exception e) {
            e.printStackTrace();
            respHead.setErrorCode("-1");
            respHead.setErrorMsg(e.getMessage());
        }
        return documentDTO;
    }



    /**
     * 文档新增
     * @param requestDTO
     * @return
     */
    @Override
    public MagicOutDTO<DocmentFacadeUpdataDTO> addDocumentState(MagicDTO<DocumentFacadeDTO> requestDTO) {
        DocmentFacadeUpdataDTO dto = new DocmentFacadeUpdataDTO();
        MagicOutDTO<DocmentFacadeUpdataDTO> documentFacadeDtoMagicDTO = new MagicOutDTO<>(dto);

        RespHeader respHead = new RespHeader();
        documentFacadeDtoMagicDTO.setHeader(respHead);
        try {
            String id = sequenceFactory.getSegmentFillZeroId(Constart.DOC_ID);
            DocumentFacadeDTO body = requestDTO.getBody();
            body.setDocsId(id);
            DocumentDTO documentDto = new DocumentDTO();
            BeanUtils.copyProperties(body,documentDto);

            DocmentUpdataDTO updataDto = documentService.addDocumentState(documentDto);

            if (2 == updataDto.getDocumentUpdataStat()){
                respHead.setErrorCode(BasicErrorEnum.ADDFATL.code());
                respHead.setErrorMsg(BasicErrorEnum.ADDFATL.msg());
            }else {
                respHead.setErrorCode(BasicErrorEnum.ADD.code());
                respHead.setErrorMsg(BasicErrorEnum.ADD.msg());
            }
        } catch (Exception e) {
            e.printStackTrace();
            respHead.setErrorCode("-1");
            respHead.setErrorMsg(e.getMessage());
        }
        return documentFacadeDtoMagicDTO;
    }
    
    /**
     * 文档查询
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
				QueryDocumentDTO queryDocumentDTO = new QueryDocumentDTO();
				BeanUtils.copyProperties(requestDTO.getBody(), queryDocumentDTO);
				QueryDocumentOutDTO queryDocumentList = documentService.queryDocumentList(queryDocumentDTO);
				
				if(null == queryDocumentList) {
					respHead.setErrorCode(BasicErrorEnum.REFERFATL.code());
					respHead.setErrorMsg(BasicErrorEnum.REFERFATL.msg());
				}else {
					outData.setTurnPageTotalNum(queryDocumentList.getTurnPageTotalNum());
					outData.setDocsList(queryDocumentList.getDocsList());
					
					respHead.setErrorCode(BasicErrorEnum.REFER.code());
					respHead.setErrorMsg(BasicErrorEnum.REFER.msg());
				}
		} catch (Exception e) {
			e.printStackTrace();
			respHead.setErrorCode("-1");
			respHead.setErrorMsg(e.getMessage());
		}
		return magicOutDTO;
	}
}