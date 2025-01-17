package com.rajesh.expertise.product_service.service;

import java.util.List;

import com.rajesh.expertise.product_service.dto.GenericProductDTO;
import com.rajesh.expertise.product_service.exception.NotFoundException;

public interface ProductService {
	
	GenericProductDTO getProductById(Long Id) throws Exception;
	List<GenericProductDTO> getProducts() throws Exception;
	GenericProductDTO createProduct(GenericProductDTO genericProductDto) throws Exception;
	GenericProductDTO updateProduct(GenericProductDTO genericProductDto, Long productId);
	GenericProductDTO deleteProduct(Long productId) throws NotFoundException;

}
