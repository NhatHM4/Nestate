package com.example.webdbs.entity;


import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
	
	@OneToMany(mappedBy = "productDetail", fetch = FetchType.EAGER)
	private Set<ImageProductDetail> setImage;
	
	
	
	@Transient
	private List<MultipartFile> listFile;
	
	@Column(columnDefinition = "Nvarchar(max)")
	private String bossInfoDecription;
	
	@Column(columnDefinition = "Nvarchar(max)")
	private String typeInfoDecription;
}
