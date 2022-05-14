package com.example.webdbs.entity;


import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
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
	
	@OneToMany(mappedBy = "productDetail", cascade = CascadeType.ALL)
	@OrderBy("id ASC")
	private Set<ImageProductDetail> setImage = new TreeSet<ImageProductDetail>();
	
	
	@Transient
	private List<MultipartFile> listFile;
	
	@Column(columnDefinition = "Nvarchar(max)")
	private String bossInfoDecription;
	
	@Column(columnDefinition = "Nvarchar(max)")
	private String typeInfoDecription;
}
