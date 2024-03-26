package ru.itis.springdatajpaexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.itis.springdatajpaexample.entity.Pet;

import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<Pet,Long> {

    @Query("SELECT p FROM Pet p WHERE p.age BETWEEN :start AND :end AND p.name = :name")
    List<Pet> findAllPetWithAgeBetweenAndName(@Param("start") Integer start, @Param("end") Integer end, @Param("name") String name);
}

