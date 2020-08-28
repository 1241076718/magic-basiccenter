package com.magic.basiccenter.model.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.experimental.Accessors;



/**
 * @author ：goupc1@belink.com
 * @date ：Created in 2020/8/620 9:54
 * @description：  应用层公告通用输入数据DTO
 * @modified By：
 * @version: $1.0.0
 */


@Data
@Accessors(chain=true)
public class QueryNoticeDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7279657644945871746L;

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
	@JsonFormat(
			pattern = "yyyy-MM-dd",
			timezone = "GMT+8"
	)
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
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date niNtcGmtCreate;
	/**
	 * 修改时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date niNtcGmtModified;
	/**
	 * 修改人
	 */
	private String niNtcGmtModifier;
	/**
	 * 当前页数
	 */
	private Long nowsPage;
	/**
	 * 当前页数
	 */
	private Long pageSize;


}