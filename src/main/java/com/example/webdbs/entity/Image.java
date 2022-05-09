package com.example.webdbs.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Image")
public class Image extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "idHome", nullable = false)
	private Home home;
	
	@OneToOne
	@MapsId
	@JoinColumn(name = "idNewsDetail")
	private NewsDetail newsDetail;

	@ManyToOne
	@JoinColumn(name = "idProductDetail", nullable = false)
	private ProductDetail productDetail;
}
