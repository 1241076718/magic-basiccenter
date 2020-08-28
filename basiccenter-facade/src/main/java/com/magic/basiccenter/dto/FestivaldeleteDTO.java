package com.magic.basiccenter.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 节假日删除功能传入DTO
 * @author GaoHua
 */
@Data
public class FestivaldeleteDTO implements Serializable {


    private static final long serialVersionUID = 6795076424207975139L;

    /**
     * 删除节假日的配置日期
     */
    private String festivalDeploy;

    /**
     * 删除节假日的Id
     */
    private String festivalId;

    /**
     * eCIFID,用作修改人
     */
    private String eCIFID;

    public String geteCIFID() {
        return eCIFID;
    }

    public void seteCIFID(String eCIFID) {
        this.eCIFID = eCIFID;
    }
}
