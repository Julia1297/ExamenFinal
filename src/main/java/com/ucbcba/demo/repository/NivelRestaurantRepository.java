package com.ucbcba.demo.repository;

import com.ucbcba.demo.Entities.NivelRestaurant;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface NivelRestaurantRepository extends CrudRepository<NivelRestaurant, Integer> {
}
