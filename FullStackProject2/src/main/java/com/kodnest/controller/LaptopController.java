package com.kodnest.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.kodnest.entity.Laptop;
import com.kodnest.service.LaptopService;

@RestController
public class LaptopController {

	@Autowired
	LaptopService laptopService;
	
	@GetMapping(value = "/laptops")
	public List<Laptop> getLaptop(){
		return laptopService.getLaptop();
	}
	
	@GetMapping(value = "/laptops/{id}")
	public Laptop getLaptopById(@PathVariable int id){
		return laptopService.getLaptop(id);
	}
	
	@PostMapping(value = "/laptops/post")
	public void postLaptop(@RequestBody Laptop l) {
		System.out.println(l);
		laptopService.postLaptop(l);
	}
	
	@DeleteMapping(value = "/laptops/delete/{id}")
	public void deleteLaptop(@PathVariable int id) {
		System.out.println(id);
		laptopService.deleteLaptop(id);
	}
	
	@PutMapping(value = "/laptops/update/{id}")
	public void updateLaptop(@PathVariable int id,@RequestBody Laptop l) {
		System.out.println(id);
		System.out.println(l);
		laptopService.updateLaptop(id,l);
	}
}
