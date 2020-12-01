package com.yusufyucedag.swagger.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 
 * @author Yusuf Yucedag
 * @since 1.0
 * @date 2020-Dec-01
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "pets")
public class Pet {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	
	@Column(name = "pet_name" , nullable = false)
	private String petName;
	
	@Column(name = "created_date")
	private Date createdDate;

	public Pet(String petName, Date createdDate) {
		this.petName = petName;
		this.createdDate = createdDate;
	}
}
