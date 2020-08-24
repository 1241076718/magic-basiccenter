package com.magic.basiccenter.serviceimpl;



import com.magic.application.infrastructure.service.dto.MagicDTO;
import com.magic.application.infrastructure.service.dto.MagicOutDTO;
import com.magic.application.infrastructure.service.dto.data.RespHeader;
import com.magic.basiccenter.dto.*;
import com.magic.basiccenter.error.BasicErrorEnum;
import com.magic.basiccenter.model.dto.*;
import com.magic.basiccenter.model.service.DocumentService;
import com.magic.basiccenter.service.BasicService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 前端接口实现
 */
public class BasicServiceImpl implements BasicService {

    /**
     * 公共数据交互端
     */
    @Autowired
    DocumentService documentService;
    /**
     * 文档数据回显
     * @param requestDTO
     * @return
     */
    @Override
    public MagicOutDTO<DocumentFacadeDTO> queryData(MagicDTO<DocumentFacadeIdDTO> requestDTO) {
        DocumentFacadeDTO dto = new DocumentFacadeDTO();
        //创建响应
        MagicOutDTO<DocumentFacadeDTO> documentFacadeDtoMagicDTO = new MagicOutDTO<>(dto);

        //创建请求头
        RespHeader respHead = new RespHeader();
        //封装响应头
        documentFacadeDtoMagicDTO.setHeader(respHead);
        try {
            //获取id
            String docsId = requestDTO.getBody().getDocsId();
            //创建后端调用封装类
            DocumentIdDTO documentDto = new DocumentIdDTO();
            //写入数据
            documentDto.setDocsId(docsId);
            //业务实现
            DocumentDTO documentDto1 = documentService.queryData(documentDto);
            //属性克隆
            BeanUtils.copyProperties(documentDto1,dto);
            //判断业务流程状态
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
        //创建响应
        MagicOutDTO<DocmentFacadeUpdataDTO> documentDTO = new MagicOutDTO<>(dto);

        //创建请求头
        RespHeader respHead = new RespHeader();
        //封装响应头
        documentDTO.setHeader(respHead);
        try {
            //获取请求对象
            DocumentFacadeDTO Document = requestDTO.getBody();
            //创建后端调用封装类
            DocumentDTO documentDto = new DocumentDTO();
            //属性克隆
            BeanUtils.copyProperties(Document,documentDto);

            //业务实现
            DocmentUpdataDTO docmentUpdataDto = documentService.queryModify(documentDto);
            //获取业务流程状态
            dto.setDocumentUpdataStat(docmentUpdataDto.getDocumentUpdataStat());
            //判断业务流程状态
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
        //创建响应
        MagicOutDTO<DocumentFacadeOutDTO> documentDTO = new MagicOutDTO<>(dto);
        //创建请求头
        RespHeader respHead = new RespHeader();
        //封装响应头
        documentDTO.setHeader(respHead);
        try {
            //获取请求对象
            DocumentFacadeInputDTO document = requestDTO.getBody();
            //创建后端调用封装类
            DocumentInputDTO documentDto = new DocumentInputDTO();
            //属性克隆
            BeanUtils.copyProperties(document,documentDto);

            //业务实现
            DocumentOutDTO publish = documentService.publish(documentDto);

            //获取业务流程状态
            dto.setState(publish.getState());
            //判断业务流程状态
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
        //创建响应
        MagicOutDTO<DocmentFacadeUpdataDTO> documentDTO = new MagicOutDTO<>(dto);
        //创建请求头
        RespHeader respHead = new RespHeader();
        //封装响应头
        documentDTO.setHeader(respHead);
        try {
            //获取请求对象
            DocumentFacadeIdDTO body = requestDTO.getBody();
            //创建后端调用封装类
            DocumentIdDTO documentIdDto = new DocumentIdDTO();
            //写入属性
            documentIdDto.setDocsId(body.getDocsId());
            //业务实现
            DocmentUpdataDTO delete = documentService.delete(documentIdDto);
            //获取业务流程状态码
            dto.setDocumentUpdataStat(delete.getDocumentUpdataStat());
            //判断业务流程
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
        //创建响应
        MagicOutDTO<DocmentFacadeUpdataDTO> documentFacadeDtoMagicDTO = new MagicOutDTO<>(dto);
        //创建请求头
        RespHeader respHead = new RespHeader();
        //封装响应头
        documentFacadeDtoMagicDTO.setHeader(respHead);
        try {
            //获取请求对象
            DocumentFacadeDTO body = requestDTO.getBody();
            //创建后端调用封装类
            DocumentDTO documentDto = new DocumentDTO();
            //属性克隆
            BeanUtils.copyProperties(body,documentDto);
            //业务实现
            DocmentUpdataDTO updataDto = documentService.addDocumentState(documentDto);
            //判断业务流程
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
		//创建响应
		MagicOutDTO<QueryDocumentListOutDTO> magicOutDTO = new MagicOutDTO<>(outData);
        //创建请求头
		RespHeader respHead = new RespHeader();
		//封装响应头
		magicOutDTO.setHeader(respHead);
		
		try {
		        //获取后端Dto对象
				QueryDocumentDTO queryDocumentDTO = new QueryDocumentDTO();
				//克隆属性
				BeanUtils.copyProperties(requestDTO.getBody(), queryDocumentDTO);
				//业务实现
				QueryDocumentOutDTO queryDocumentList = documentService.queryDocumentList(queryDocumentDTO);
				//判断业务流程
				if(null == queryDocumentList) {
					respHead.setErrorCode(BasicErrorEnum.REFERFATL.code());
					respHead.setErrorMsg(BasicErrorEnum.REFERFATL.msg());
				}else {
				    //写入数据
					outData.setTurnPageTotalNum(queryDocumentList.getTurnPageTotalNum());
					outData.setDocsList(queryDocumentList.getDocsList());
					outData.setCatalogNameList(queryDocumentList.getCatalogNameList());
					
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