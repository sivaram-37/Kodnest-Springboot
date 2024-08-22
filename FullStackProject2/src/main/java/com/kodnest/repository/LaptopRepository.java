package com.kodnest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kodnest.entity.Laptop;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Integer>{

}
