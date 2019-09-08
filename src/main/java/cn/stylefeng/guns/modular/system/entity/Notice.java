package cn.stylefeng.guns.modular.system.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * <p>
 * 通知表
 * </p>
 *
 * @author stylefeng
 * @since 2019-04-01
 */
@TableName("activate_info")
public class Notice implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId(value = "activate_id", type = IdType.AUTO)
	private Integer activateId;

	/**
	 * 标题
	 */
	@TableField("title")
	private String title;

	/**
	 * 会议地址
	 */
	@TableField("address")
	private String address;

	/**
	 * 上车地点
	 */
	@TableField("meeting_place")
	private String meetingPlace;

	/**
	 * 活动开始时间
	 */
	@TableField("act_time")
	private Date actTime;

	/**
	 * 活动结束时间
	 */
	@TableField("end_time")
	private Date endTime;

	/**
	 * 创建人
	 */
	@TableField(value = "act_creator", fill = FieldFill.INSERT)
	private String actCreator;

	/**
	 * 内容
	 */
	@TableField("content")
	private String content;

	/**
	 * 参加人数
	 */
	@TableField("participate_num")
	private Integer participateNum = Integer.valueOf(0);

	/**
	 * 已参加人数
	 */
	@TableField("cur_participate_num")
	private Integer curParticipateNum = Integer.valueOf(0);

	/**
	 * 报名费用
	 */
	@TableField("cost")
	private Double cost = Double.valueOf(0);

	/**
	 * 创建时间
	 */
	@TableField(value = "create_time", fill = FieldFill.INSERT)
	private Date createTime;

	/**
	 * 修改时间
	 */
	@TableField(value = "update_time", fill = FieldFill.UPDATE)
	private Date updateTime;

	/**
	 * 状态
	 */
	@TableField("status")
	private String status;

	public Integer getActivateId() {
		return activateId;
	}

	public void setActivateId(Integer activateId) {
		this.activateId = activateId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getActTime() {
		return actTime;
	}

	public void setActTime(Date actTime) {
		this.actTime = actTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getActCreator() {
		return actCreator;
	}

	public void setActCreator(String actCreator) {
		this.actCreator = actCreator;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getParticipateNum() {
		return participateNum;
	}

	public void setParticipateNum(Integer participateNum) {
		this.participateNum = participateNum;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMeetingPlace() {
		return meetingPlace;
	}

	public void setMeetingPlace(String meetingPlace) {
		this.meetingPlace = meetingPlace;
	}

	public Integer getCurParticipateNum() {
		return curParticipateNum;
	}

	public void setCurParticipateNum(Integer curParticipateNum) {
		this.curParticipateNum = curParticipateNum;
	}

	@Override
	public String toString() {
		return "Notice{" + "activateId=" + activateId + ", title=" + title + ", address=" + address + ", meetingPlace="
				+ meetingPlace + ", actTime=" + actTime + ", endTime=" + endTime + ", actCreator=" + actCreator
				+ ", content=" + content + ", participateNum=" + participateNum + ", curParticipateNum="
				+ curParticipateNum + ", cost=" + cost + ", createTime=" + createTime + ", updateTime=" + updateTime
				+ ", status=" + status + "}";
	}

}
