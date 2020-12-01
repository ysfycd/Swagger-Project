package com.yusufyucedag.swagger.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yusufyucedag.swagger.entity.Pet;
/**
 * 
 * @author Yusuf Yucedag
 * @since 1.0
 * @date 2020-Dec-01
 */
public interface PetRepository extends JpaRepository<Pet, Long> {

}
