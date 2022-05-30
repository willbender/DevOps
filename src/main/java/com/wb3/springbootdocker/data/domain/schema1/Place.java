package com.wb3.springbootdocker.data.domain.schema1;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "places")
@Data
public class Place {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "name", columnDefinition = "varchar", length = 150, nullable = false, unique = true)
	private String name;

	@Column(name = "visited", columnDefinition = "boolean")
	private Boolean visited = false;

	@Column(name = "description", columnDefinition = "text")
	private String description;

	@Column(name = "description_pt", columnDefinition = "text")
	private String descriptionPt;

}