package com.example.webdbs.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	@JoinColumn(name = "id_product_detail", referencedColumnName = "id")
	private ProductDetail productDetail;


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(linkImage, productDetail);
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ImageProductDetail other = (ImageProductDetail) obj;
		return Objects.equals(linkImage, other.linkImage) && Objects.equals(productDetail, other.productDetail);
	}
	
	
}
