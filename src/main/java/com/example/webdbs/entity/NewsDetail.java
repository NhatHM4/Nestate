package com.example.webdbs.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "NewsDetail")
public class NewsDetail extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(columnDefinition = "NVARCHAR(MAX)")
	private String name;
	
	@Column(columnDefinition = "NVARCHAR(MAX)")
	private String decription;
	
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "newsDetail")
	@PrimaryKeyJoinColumn
	private Image image;
	//dung oc cho
	//alo alo
	
	// alooala

}
