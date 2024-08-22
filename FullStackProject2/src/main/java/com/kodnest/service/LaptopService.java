package com.kodnest.service;

import java.util.List;

import com.kodnest.entity.Laptop;

public interface LaptopService {
	
	List<Laptop> getLaptop();

	Laptop getLaptop(int id);

	void postLaptop(Laptop l);

	void deleteLaptop(int id);

	void updateLaptop(int id, Laptop l);
}
