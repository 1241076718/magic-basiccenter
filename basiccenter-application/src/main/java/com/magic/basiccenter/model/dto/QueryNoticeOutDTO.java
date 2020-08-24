package com.magic.basiccenter.model.dto;

import java.io.Serializable;
import java.util.Date;


import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain=true)  //可连输用set().set().set()......
public class QueryNoticeOutDTO implements Serializable {

	private static final long serialVersionUID = 1184931488178595716L;
	/**
	 *公告id
	 */
	private String niNtcId;
	/**
	 *公告名字
	 */
	private String niNtcName;
	/**

	 * 公告状态（1：已删除 2：新建 3:已发布 4：已上架 5：已下架 6：已驳回 ）
	 */

	private Integer niNtcStatus;

	/**
	 * 公告发布时间
	 */

	private Date niNtcIdReleaseTime;
	/**
	 * 公告创建者
	 */
	private String niNtcCreator;
	/**
	 * 公告具体内容
	 */
	private String niNtcText;
	/**
	 * 公告强制提醒开始时间
	 */
	private Date niNtcStartTime;
	/**
	 * 公告强制提醒结束时间
	 */
	private Date niNtcEndTime;
	/**
	 * 提醒次数
	 */
	private Integer niNtcCount;
	/**
	 * 提醒状态（是否提醒）（0：否 1:是）
	 */
	private Integer niNtcRemindStatus;
	/**
	 * 创建时间
	 */

	private Date niNtcGmtCreate;
	/**
	 * 修改时间
	 */

	private Date niNtcGmtModified;
	/**
	 * 修改人
	 */
	private String niNtcGmtModifier;

	
}
