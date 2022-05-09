package com.example.webdbs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "CEO")
public class CEO extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(columnDefinition = "NVARCHAR(MAX)")
	private String title;
	
	@Column(columnDefinition = "NVARCHAR(MAX)")
	private String name;
	
	@Column(columnDefinition = "NVARCHAR(MAX)")
	private String image;
	
	@Column(columnDefinition = "NVARCHAR(MAX)")
	private String content;
}
