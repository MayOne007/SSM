package com.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "t_dict")
public class Dict implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "N_ID")
    private Integer id;

    @Column(name = "C_KEY")
	private String key;
    
	@Column(name = "C_VALUE")
	private String value;
	
	@Column(name = "C_PARENTKEY")
	private String parentkey;
	
	@Column(name = "N_SORT")
	private Integer sort;

	public Integer getId() {
		return id;
	}

	public String getKey() {
		return key;
	}

	public String getParentkey() {
		return parentkey;
	}

	public Integer getSort() {
		return sort;
	}

	public String getValue() {
		return value;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public void setParentkey(String parentkey) {
		this.parentkey = parentkey;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public void setValue(String value) {
		this.value = value;
	}

}