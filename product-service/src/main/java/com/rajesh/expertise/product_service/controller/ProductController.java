package com.rajesh.expertise.product_service.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rajesh.expertise.product_service.dto.ExceptionDto;
import com.rajesh.expertise.product_service.dto.GenericProductDTO;
import com.rajesh.expertise.product_service.exception.NotFoundException;
import com.rajesh.expertise.product_service.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	
	private ProductService productService;

	public ProductController(ProductService productService)
	{
		this.productService=productService;
	}
		
	@GetMapping("/{id}")
	public GenericProductDTO getProduct(@PathVariable("id") Long productId) throws Exception
	{
		GenericProductDTO productDto= productService.getProductById(productId);
		return productDto;
	}
	
	@GetMapping()
	public List<GenericProductDTO> getProduct() throws Exception
	{
		List<GenericProductDTO> listproductDto= productService.getProducts();
		return listproductDto;
	}
	
	@PostMapping
	public GenericProductDTO createProduct(@RequestBody GenericProductDTO genericProductDto) throws Exception
	{
		
		
		return productService.createProduct(genericProductDto);
	}
	@PutMapping("/{id}")
	public GenericProductDTO updateProduct(@RequestBody GenericProductDTO genericProductDto, @PathVariable("id") Long productId) throws Exception
	{
				return productService.updateProduct(genericProductDto, productId);
	}
	
	@DeleteMapping("/{id}")
	public GenericProductDTO deleteProduct(@PathVariable("id") Long productId) throws Exception
	{
				return productService.deleteProduct(productId);
	}
	
	
	
}
