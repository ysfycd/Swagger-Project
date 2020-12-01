package com.yusufyucedag.swagger.service.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yusufyucedag.swagger.dto.PetCreateDTO;
import com.yusufyucedag.swagger.dto.PetViewDTO;
import com.yusufyucedag.swagger.entity.Pet;
import com.yusufyucedag.swagger.exception.NotFounException;
import com.yusufyucedag.swagger.repository.PetRepository;
import com.yusufyucedag.swagger.service.PetService;

import lombok.RequiredArgsConstructor;

/**
 * 
 * @author Yusuf Yucedag
 * @since 1.0
 * @date 2020-Dec-01
 */

@Service
@RequiredArgsConstructor
public class PetServiceImpl implements PetService {

	private final PetRepository petRepository;

	private Pet getPetByIdCommon(Long id) {
		return petRepository.findById(id)
				.orElseThrow(() -> new NotFounException("Pet not found exception!"));
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<PetViewDTO> getPets() {
		return petRepository.findAll()
				.stream()
				.map(PetViewDTO::of)
				.collect(Collectors.toList());
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public PetViewDTO getPetById(Long id) {
		final Pet pet = getPetByIdCommon(id);
		return PetViewDTO.of(pet);
	}

	@Override
	@Transactional
	public PetViewDTO createPet(PetCreateDTO petCreateDTO) {
		Date createdDate = new Date();
		Pet pet = petRepository.save(new Pet(petCreateDTO.getPetName(),createdDate));
		return PetViewDTO.of(pet);
	}

	@Override
	@Transactional
	public void deletePet(Long id) {
		final Pet pet = getPetByIdCommon(id);
		petRepository.delete(pet);
	}

}
