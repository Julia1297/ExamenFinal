package com.ucbcba.demo.services;


import com.ucbcba.demo.Entities.NivelRestaurant;
import com.ucbcba.demo.repository.NivelRestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service
public class NivelRestaurantServiceImpl implements NivelRestaurantService {

    private NivelRestaurantRepository nivelRestaurantRepository;

    @Autowired
    @Qualifier(value = "nivelRestaurantRepository")
    public void setCommentRepository(NivelRestaurantRepository nivelRestaurantRepository) {
        this.nivelRestaurantRepository = nivelRestaurantRepository;
    }




    @Override
    public Iterable<NivelRestaurant> listAllNiveles() {
        return nivelRestaurantRepository.findAll();
    }

    @Override
    public void saveNivelRestaurant(NivelRestaurant nivelRestaurant) {
            nivelRestaurantRepository.save(nivelRestaurant);
    }

    @Override
    public NivelRestaurant getNivelRestaurant(Integer id) {
        return nivelRestaurantRepository.findOne(id);
    }

    @Override
    public void deleteNivelRestaurant(Integer id) {
        nivelRestaurantRepository.delete(id);
    }
}
