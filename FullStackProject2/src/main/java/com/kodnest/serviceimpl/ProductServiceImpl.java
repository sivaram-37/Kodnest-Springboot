package com.kodnest.serviceimpl;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kodnest.entity.Product;
import com.kodnest.repository.ProductRepository;
import com.kodnest.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;
	
	@Override
	public List<Product> getProduct() {
		return productRepository.findAll();
	}

	@Override
	public Product getProductById(int id) {
		Optional<Product> product = productRepository.findById(id);
		return product.orElse(null);
	}

	@Override
	public void postProduct(Product p) {
		productRepository.save(p);
	}

	@Override
	public void deleteProduct(int id) {
		productRepository.deleteById(id);
	}

	@Override
	public void updateProduct(int id, Product updateP) {
		Optional<Product> existP = productRepository.findById(id);
		if(existP.isPresent()) {
			Product product = existP.get();
			product.setPname(updateP.getPname());
			productRepository.save(product);
			System.out.println("Update Successfully");
		}
		else {
			System.out.println("Record not found");
		}
	}

}
