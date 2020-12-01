package com.yusufyucedag.swagger.dto;


import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 
 * @author Yusuf Yucedag
 * @since 1.0
 * @date 2020-Dec-01
 */

@Data
@ApiModel(value = "Pet Create ",description = "All details about the Pet Create")
public class PetCreateDTO {
	
	@NotNull
	@Size(min = 3, max = 16)
	@ApiModelProperty(value = "Pet Name")
	private String petName;

}
