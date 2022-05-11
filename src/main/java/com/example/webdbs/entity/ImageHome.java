package com.example.webdbs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ImageHome")
public class ImageHome extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(columnDefinition = "nvarchar(max)")
	private String linkImage;
	
	@ManyToOne
	@JoinColumn(name = "idHome", nullable = false)
	private Home home;
//	
	
}
