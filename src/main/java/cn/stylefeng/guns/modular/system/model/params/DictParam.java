package cn.stylefeng.guns.modular.system.model.params;

import java.io.Serializable;

import cn.stylefeng.roses.kernel.model.validator.BaseValidatingParam;
import lombok.Data;

/**
 * <p>
 * 基础字典
 * </p>
 *
 * @author stylefeng
 * @since 2019-03-13
 */
@Data
public class DictParam implements Serializable, BaseValidatingParam {

	private static final long serialVersionUID = 1L;

	/**
	 * 字典id
	 */
	private Long dictId;

	/**
	 * 所属字典类型的id
	 */
	private Long dictTypeId;

	/**
	 * 字典编码
	 */
	private String code;

	/**
	 * 字典名称
	 */
	private String name;

	/**
	 * 上级代码id
	 */
	private Long parentId;

	/**
	 * 状态（字典）
	 */
	private String status;

	/**
	 * 字典的描述
	 */
	private String description;

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

	public Long getDictId() {
		return dictId;
	}

	public void setDictId(Long dictId) {
		this.dictId = dictId;
	}

	public Long getDictTypeId() {
		return dictTypeId;
	}

	public void setDictTypeId(Long dictTypeId) {
		this.dictTypeId = dictTypeId;
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

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
