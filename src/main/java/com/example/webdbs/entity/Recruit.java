package com.example.webdbs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Recruit")
public class Recruit extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(columnDefinition = "NVARCHAR(MAX)")
	private String title;
	
	@Column(columnDefinition = "NVARCHAR(MAX)")
	private String address;
	
	@Column(columnDefinition = "NVARCHAR(MAX)")
	private String content;
	
	@Column(columnDefinition = "NVARCHAR(MAX)")
	private String status;
}
