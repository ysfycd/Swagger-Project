package com.yusufyucedag.swagger.dto;

import java.util.Date;


import com.yusufyucedag.swagger.entity.Pet;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
/**
 * 
 * @author Yusuf Yucedag
 * @since 1.0
 * @date 2020-Dec-01
 */
@Getter
@ApiModel(value = "Pet View ",description = "All details about the Pet")
public final class PetViewDTO {
	
	@ApiModelProperty(value = "Pet Name")
	private final String petName;

	@ApiModelProperty(value = "Pet Created Date")
	private final Date createdDate;

	private PetViewDTO(String petName, Date createdDate) {
		this.petName = petName;
		this.createdDate = createdDate;
	}

	public static PetViewDTO of(Pet pet) {
		return new PetViewDTO(pet.getPetName(), pet.getCreatedDate());
	}

}
