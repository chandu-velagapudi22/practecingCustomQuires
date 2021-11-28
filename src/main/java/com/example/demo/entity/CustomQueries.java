package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
public class CustomQueries implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Integer queryId;
	private String queryName;
	private String queryAddress;
	private Boolean queryAxcess;

	public CustomQueries(Integer queryId, String queryName, String queryAddress, Boolean queryAxcess) {
		super();
		this.queryId = queryId;
		this.queryName = queryName;
		this.queryAddress = queryAddress;
		this.queryAxcess = queryAxcess;
	}

}
