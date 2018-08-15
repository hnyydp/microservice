package org.pu.dept.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@SuppressWarnings("serial")
@Data
//@Accessors(chain=true) //链式风格
public class Dept implements Serializable {
	private Integer deptId;
	private String deptName;

	@JsonInclude(JsonInclude.Include.NON_NULL)  //忽略null
	private Integer port;
	
}