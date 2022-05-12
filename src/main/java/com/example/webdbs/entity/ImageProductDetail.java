package com.example.webdbs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ImageProductDetail")
public class ImageProductDetail extends BaseEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	/**
	 * 
	 */
	
	public ImageProductDetail(String linkImage) {
		this.linkImage = linkImage;
	}
	
	@Column(columnDefinition = "varchar(max)")
	private String linkImage;
	

	@ManyToOne
	@JoinColumn(name = "idProductDetail", nullable = false)
	private ProductDetail productDetail;
}
