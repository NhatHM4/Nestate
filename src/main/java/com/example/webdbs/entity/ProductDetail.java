package com.example.webdbs.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "ProductDetail")
public class ProductDetail extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(columnDefinition = "NVARCHAR(MAX)")
	private String name;
	
	@Column(columnDefinition = "NVARCHAR(MAX)")
	private String address;
	
	@Column
	private long price;
	
	@Column(columnDefinition = "NVARCHAR(MAX)")
	private String status;
	
	@Column(columnDefinition = "NVARCHAR(MAX)")
	private String boss;
	
	@Column(columnDefinition = "NVARCHAR(MAX)")
	private String type;
	
	@Column(columnDefinition = "NVARCHAR(MAX)")
	private String phone;
	
	@Column(columnDefinition = "NVARCHAR(MAX)")
	private String decription;
	
	@Column(columnDefinition = "NVARCHAR(MAX)")
	private String infoProject;
	
	@Column(columnDefinition = "NVARCHAR(MAX)")
	private String buildDensity;
	
	@Column(columnDefinition = "NVARCHAR(MAX)")
	private String pinkBook;
	
	@Column(columnDefinition = "NVARCHAR(MAX)")
	private String linkMap;
	
	@OneToMany(mappedBy = "productDetail")
	private Set<Image> setImage;
	
	@OneToOne(mappedBy = "productDetail", cascade =  CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private BossInfo bossInfo;
	
	@OneToOne(mappedBy = "productDetail", cascade =  CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private TypeInfo typeInfo;
	
}
