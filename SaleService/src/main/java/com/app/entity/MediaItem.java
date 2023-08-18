package com.app.entity;

import com.app.enums.MediaObjectType;
import com.app.enums.MediaType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "media_item")
public class MediaItem extends BaseEntity{
	
	private static final long serialVersionUID = -1226841383690623587L;
	
	private String title;
	private String url;
	private String type;
	
	@Column(name = "media_type")
	@Enumerated(EnumType.STRING)
	private MediaType mediaType;
	@Column(name = "media_object_type")
	@Enumerated(EnumType.STRING)
	private MediaObjectType mediaObjectType;
	private Long objectId;
}
