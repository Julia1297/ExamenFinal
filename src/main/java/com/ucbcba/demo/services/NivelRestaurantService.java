package com.ucbcba.demo.services;

import com.ucbcba.demo.Entities.NivelRestaurant;

public interface NivelRestaurantService {
    Iterable<NivelRestaurant> listAllNiveles();

    void saveNivelRestaurant(NivelRestaurant nivelRestaurant);

    NivelRestaurant getNivelRestaurant(Integer id);

    void deleteNivelRestaurant(Integer id);
}
