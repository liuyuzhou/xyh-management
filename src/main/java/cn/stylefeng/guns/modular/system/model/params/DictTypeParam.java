package cn.stylefeng.guns.modular.system.model.params;

import java.io.Serializable;

import cn.stylefeng.roses.kernel.model.validator.BaseValidatingParam;
import lombok.Data;

/**
 * <p>
 * 字典类型表
 * </p>
 *
 * @author stylefeng
 * @since 2019-03-13
 */
@Data
public class DictTypeParam implements Serializable, BaseValidatingParam {

	private static final long serialVersionUID = 1L;

	/**
	 * 字典类型id
	 */
	private Long dictTypeId;

	/**
	 * 是否是系统字典，Y-是，N-否
	 */
	private String systemFlag;

	/**
	 * 字典类型编码
	 */
	private String code;

	/**
	 * 字典类型名称
	 */
	private String name;

	/**
	 * 字典描述
	 */
	private String description;

	/**
	 * 状态(字典)
	 */
	private String status;

	/**
	 * 查询条件
	 */
	private String condition;

	/**
	 * 排序
	 */
	private Integer sort;

	@Override
	public String checkParam() {
		return null;
	}

	public Long getDictTypeId() {
		return dictTypeId;
	}

	public void setDictTypeId(Long dictTypeId) {
		this.dictTypeId = dictTypeId;
	}

	public String getSystemFlag() {
		return systemFlag;
	}

	public void setSystemFlag(String systemFlag) {
		this.systemFlag = systemFlag;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

}
