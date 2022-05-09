package com.example.webdbs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TypeInfo")
public class TypeInfo extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(columnDefinition = "NVARCHAR(MAX)")
	private String decription;
	
	@OneToOne
	@MapsId
	@JoinColumn(name = "idProductDetail")
	private ProductDetail productDetail;

}
