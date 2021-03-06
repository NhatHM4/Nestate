package com.example.webdbs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ImageNewsDetail")
public class ImageNewsDetail extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ImageNewsDetail(String image) {
		this.linkImage = image;
	}
	
	
	@Column(columnDefinition = "nvarchar(max)")
	private String linkImage;
	
	
	
	@OneToOne
	@MapsId
	@JoinColumn(name = "idNewsDetail")
	private NewsDetail newsDetail;

	
}
