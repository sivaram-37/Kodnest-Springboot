package com.kodnest.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodnest.entity.Laptop;
import com.kodnest.repository.LaptopRepository;
import com.kodnest.service.LaptopService;

@Service
public class LaptopServiceImpl implements LaptopService {

	@Autowired
	LaptopRepository laptopRepository;
	
	@Override
	public List<Laptop> getLaptop() {
		return laptopRepository.findAll();
	}

	@Override
	public Laptop getLaptop(int id) {
		Optional<Laptop> laptop = laptopRepository.findById(id);
		return laptop.orElse(null);
	}

	@Override
	public void postLaptop(Laptop l) {
		laptopRepository.save(l);		
	}

	@Override
	public void deleteLaptop(int id) {
		laptopRepository.deleteById(id);
	}

	@Override
	public void updateLaptop(int id, Laptop updateL) {
		Optional<Laptop> existL = laptopRepository.findById(id);
		if(existL.isPresent()) {
			Laptop laptop = existL.get();
			laptop.setLname(updateL.getLname());
			laptop.setLcolor(updateL.getLcolor());
			laptopRepository.save(laptop);
			System.out.println("Update successfully");
		}
		else {
			System.out.println("Record not found");
		}
	}

}
