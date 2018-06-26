package com.ucbcba.demo.repository;

import com.ucbcba.demo.Entities.Category;
import com.ucbcba.demo.Entities.City;
import com.ucbcba.demo.Entities.Restaurant;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

@Transactional
public interface RestaurantRepository extends CrudRepository<Restaurant,Integer> {

    @Query("SELECT r FROM Restaurant r WHERE r.name LIKE %:name% and r.city.id = :cityid and r.category.id = :categoryid and ROUND(r.score) >= :score")
    Iterable<Restaurant> getRestaurantLikeNameCityCategoryScore(@Param("name") String name, @Param("cityid") Integer cityid, @Param("categoryid") Integer categoryid, @Param("score") Float score);

    @Query("SELECT r FROM Restaurant r WHERE r.name LIKE %:name% and r.city.id = :cityid and r.category.id = :categoryid")
    Iterable<Restaurant> getRestaurantLikeNameCityCategory(@Param("name") String name, @Param("cityid") Integer cityid, @Param("categoryid") Integer categoryid);

    @Query("SELECT r FROM Restaurant r WHERE r.name LIKE %:name% and r.city.id = :cityid and ROUND(r.score) >= :score")
    Iterable<Restaurant> getRestaurantLikeNameCityScore(@Param("name") String name, @Param("cityid") Integer cityid, @Param("score") Float score);

    @Query("SELECT r FROM Restaurant r WHERE r.name LIKE %:name% and r.category.id = :categoryid and ROUND(r.score) >= :score")
    Iterable<Restaurant> getRestaurantLikeNameCategoryScore(@Param("name") String name, @Param("categoryid") Integer categoryid, @Param("score") Float score);

    @Query("SELECT r FROM Restaurant r WHERE r.city.id = :cityid and r.category.id = :categoryid and ROUND(r.score) >= :score")
    Iterable<Restaurant> getRestaurantLikeCityCategoryScore(@Param("cityid") Integer cityid, @Param("categoryid") Integer categoryid, @Param("score") Float score);

    @Query("SELECT r FROM Restaurant r WHERE r.name LIKE %:name% and r.city.id = :cityid")
    Iterable<Restaurant> getRestaurantLikeNameCity(@Param("name") String name, @Param("cityid") Integer cityid);

    @Query("SELECT r FROM Restaurant r WHERE r.city.id = :cityid and ROUND(r.score) >= :score")
    Iterable<Restaurant> getRestaurantLikeCityScore(@Param("cityid") Integer cityid, @Param("score") Float score);

    @Query("SELECT r FROM Restaurant r WHERE r.name LIKE %:name% and r.category.id = :categoryid")
    Iterable<Restaurant> getRestaurantLikeNameCategory(@Param("name") String name, @Param("categoryid") Integer categoryid);

    @Query("SELECT r FROM Restaurant r WHERE r.name LIKE %:name% and ROUND(r.score) >= :score")
    Iterable<Restaurant> getRestaurantLikeNameScore(@Param("name") String name, @Param("score") Float score);

    @Query("SELECT r FROM Restaurant r WHERE r.city.id = :cityid and r.category.id = :categoryid")
    Iterable<Restaurant> getRestaurantLikeCityCategory(@Param("cityid") Integer cityid, @Param("categoryid") Integer categoryid);

    @Query("SELECT r FROM Restaurant r WHERE r.category.id = :categoryid and ROUND(r.score) >= :score ")
    Iterable<Restaurant> getRestaurantLikeCategoryScore(@Param("categoryid") Integer categoryid, @Param("score") Float score);

    @Query("SELECT r from Restaurant r where r.city.id = :cityid")
    Iterable<Restaurant> getRestaurantByCity(@Param("cityid") Integer cityid);

    @Query("SELECT r from Restaurant r where r.category.id = :categoryid")
    Iterable<Restaurant> getRestaurantByCategory(@Param("categoryid") Integer categoryid);

    @Query("SELECT r from Restaurant r where r.name LIKE %:name%")
    Iterable<Restaurant> getRestaurantByName(@Param("name") String name);

    @Query("SELECT r from Restaurant r where ROUND(r.score) >= :score")
    Iterable<Restaurant> getRestaurantByScore(@Param("score") Float score);

    public Iterable<Restaurant> findTop5ByOrderByScoreDesc();
}
