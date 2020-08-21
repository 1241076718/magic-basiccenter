package com.magic.basiccenter.service;



import com.magic.application.infrastructure.service.dto.MagicDTO;
import com.magic.application.infrastructure.service.dto.MagicOutDTO;
import com.magic.basiccenter.dto.*;

public interface ModifyService {
    /**
     * 数据回显
     * @param requestDTO
     * @return
     */
    MagicOutDTO<DocumentFacadeDto> queryData(MagicDTO<DocumentFacadeIdDto> requestDTO);

    /**
     * 数据修改
     * @param requestDTO
     * @return
     */
    MagicOutDTO<DocmentFacadeUpdataDto> queryModify(MagicDTO<DocumentFacadeDto> requestDTO);

    /**
     * 文档发布
     * @param requestDTO
     * @return
     */
    MagicOutDTO<DocumentFacadeOutDTO> publish(MagicDTO<DocumentFacadeInputDto> requestDTO);

    /**
     * 文档删除
     * @param requestDTO
     * @return
     */
    MagicOutDTO<DocmentFacadeUpdataDto> delete (MagicDTO<DocumentFacadeIdDto> requestDTO);
    /**
     * 查询文档列表
     * @param requestDTO
     * @return
     */

    MagicOutDTO<QueryDocumentListOutDTO> queryDocumentList(MagicDTO<QueryDocumentListDTO> requestDTO);

    /**
     * 新增文档状态
     * @param requestDTO
     * @return
     */
    MagicOutDTO<DocmentFacadeUpdataDto> addDocumentState(MagicDTO<DocumentFacadeDto> requestDTO);


}
