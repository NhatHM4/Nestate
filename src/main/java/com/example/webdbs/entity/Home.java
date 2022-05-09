package com.example.webdbs.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "Home")
public class Home extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(columnDefinition = "NVARCHAR(MAX)")
	private String title;
	
	@Column(columnDefinition = "NVARCHAR(MAX)")
	private String decription;
	
	@Column(columnDefinition = "NVARCHAR(MAX)")
	private String linkAudio;
	
	@OneToMany(mappedBy = "home")
	private Set<Image> setImage;
}
