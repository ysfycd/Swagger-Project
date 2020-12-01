package com.yusufyucedag.swagger.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yusufyucedag.swagger.dto.PetCreateDTO;
import com.yusufyucedag.swagger.dto.PetViewDTO;
import com.yusufyucedag.swagger.service.PetService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;

/**
 * 
 * @author Yusuf Yucedag
 * @since 1.0
 * @date 2020-Dec-01
 */

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
@Api(value = "Pet Api")
public class PetAPI {
	private final PetService petService;

	@GetMapping("/pet")
	@ApiOperation(value = "View a list of available pets", response = List.class)
	public ResponseEntity<List<PetViewDTO>> getPets() {
		final List<PetViewDTO> pets = petService.getPets();
		return ResponseEntity.ok(pets);

	}

	@GetMapping("/pet/{id}")
	@ApiOperation(value = "View a Pet by id")
	public ResponseEntity<PetViewDTO> getPetById(@PathVariable("id") @ApiParam(value = "Pet id from which Pet object will retrieve", required = true) Long id) {
		final PetViewDTO pet = petService.getPetById(id);
		return ResponseEntity.ok(pet);

	}

	@PostMapping("/pet")
	@ApiOperation(value = "Create a Pet")
	public ResponseEntity<PetViewDTO> createPet(
			@Valid @RequestBody @ApiParam(value = "Pet object store in database table", required = true) PetCreateDTO petCreateDTO) {
		final PetViewDTO pet = petService.createPet(petCreateDTO);
		return ResponseEntity.ok(pet);
	}

	@DeleteMapping("/pet/{id}")
	@ApiOperation(value = "Delete a Pet", notes = "Safe use this method!")
	public ResponseEntity<?> deletePet(@PathVariable("id") @ApiParam(value = "Pet id from which Pet object will retrieve", required = true) Long id) {
		petService.deletePet(id);
		return ResponseEntity.ok("Pet deleted!");
	}
}
