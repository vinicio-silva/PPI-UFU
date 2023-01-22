package com.example.lab06;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product")
public class ProductRESTController {
	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping
	public List<Product> findAllProduct(){
		//Implement
		return productRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> findproductById(@PathVariable(value = "id") long id) {
		//Implement
		Optional<Product> product = productRepository.findById(id);
		if(product.isPresent()){
			return ResponseEntity.ok().body(product.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping
	public Product saveProduct(@Validated @RequestBody Product product){
		//Implement
		return productRepository.save(product);
	}
	
	@PutMapping("/{id}")
	public Product updateProduct(@PathVariable(value = "id") long id, @Validated @RequestBody Product product){
		//Implement
		Optional<Product> updateProduct = productRepository.findById(id);
		
		if (updateProduct.isPresent()) {
			updateProduct.get().setName(product.getName());
			updateProduct.get().setQuantidade(product.getQuantidade());
			return updateProduct.get();
		}
		
		return null;
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteProductById(@PathVariable(value = "id") long id){
		//Implement
		Optional<Product> product = productRepository.findById(id);
		if(product.isPresent()){
			productRepository.deleteById(id);
			return ResponseEntity.ok().body("Deleted");
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}