package com.yusufyucedag.swagger.service;

import java.util.List;


import com.yusufyucedag.swagger.dto.PetCreateDTO;
import com.yusufyucedag.swagger.dto.PetViewDTO;
/**
 * 
 * @author Yusuf Yucedag
 * @since 1.0
 * @date 2020-Dec-01
 */
public interface PetService {

	List<PetViewDTO> getPets();

	PetViewDTO getPetById(Long id);

	PetViewDTO createPet(PetCreateDTO petCreateDTO);

	void deletePet(Long id);

}
