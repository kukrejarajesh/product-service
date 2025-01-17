package com.rajesh.expertise.product_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.rajesh.expertise.product_service.dto.GenericProductDTO;
import com.rajesh.expertise.product_service.exception.NotFoundException;



@Primary
@Service
public class ProductServiceImpls implements ProductService {

	private RestTemplate restTemplate;
	private String productRequestBaseUrl;
	private String specificProductUrl;
	@Value("$(fakestore.api.url)") 
	private String fakeStoreApiPath;
	@Value("$(fakestore.api.paths.product") 
	private String productPath;

	public ProductServiceImpls()
{
		/*RestTemplate restTemplate, */
		
	
		this.restTemplate=new RestTemplate();
		this.fakeStoreApiPath="https://fakestoreapi.com";
		this.productPath="/products";
	    this.productRequestBaseUrl= fakeStoreApiPath+productPath;
	    this.specificProductUrl= productRequestBaseUrl + "/{id}" ;
	
	
	
}
			
	
	@Override
	public GenericProductDTO getProductById(Long Id) throws Exception {
		// TODO Auto-generated method stub
		
		
		
		ResponseEntity<GenericProductDTO> response= restTemplate.getForEntity(
				specificProductUrl,GenericProductDTO.class,Id);
		GenericProductDTO productDto=response.getBody();
		
		if(response.getBody()==null) throw new Exception("product by " + Id + " Not Found. Search with different Id");
		return productDto;
	}

	public List<GenericProductDTO> getProducts() throws Exception
	{
		String url="https://fakestoreapi.com/products";
		//restTemplate.getForObject(allProductURL, "https://fakestoreapi.com/products");
		
		// exchange is more versatile method
		
		ResponseEntity<List<GenericProductDTO>> response = restTemplate.exchange(
			    url,
			    HttpMethod.GET,
			    null,
			    new ParameterizedTypeReference<List<GenericProductDTO>>() {}
			);
		
		return response.getBody();
		
	}
	
	public GenericProductDTO createProduct(GenericProductDTO genericProductDto) throws Exception
	{
//		ResponseEntity<GenericProductDTO> response= restTemplate.getForEntity(
//				specificProductUrl,GenericProductDTO.class,Id);
		
		ResponseEntity<GenericProductDTO> response =restTemplate.postForEntity(productRequestBaseUrl,genericProductDto, GenericProductDTO.class);
		
		GenericProductDTO productDto=response.getBody();
		
		return productDto;
	}
	
	public GenericProductDTO updateProduct(GenericProductDTO genericProductDto, Long productId)
	{
		System.out.println("productrequest url=" + productRequestBaseUrl+ "/" + productId); 
		ResponseEntity<GenericProductDTO> responseEntity = restTemplate.exchange(
				specificProductUrl,
			    HttpMethod.PUT,
			    new HttpEntity<>(genericProductDto),
			    GenericProductDTO.class,
			    productId
			);

		
		//ResponseEntity<GenericProductDTO> response =restTemplate.put(specificProductUrl,genericProductDto,productId);
		
		//return genericProductDto;
		return responseEntity.getBody();
		
	}
	
	public GenericProductDTO deleteProduct(Long Id) throws NotFoundException {
		// TODO Auto-generated method stub
		
		
		
		ResponseEntity<GenericProductDTO> response= restTemplate.getForEntity(
				specificProductUrl,GenericProductDTO.class,Id);
		GenericProductDTO productDto=response.getBody();
		
		ResponseEntity<GenericProductDTO> responseEntity =restTemplate.exchange(specificProductUrl, HttpMethod.DELETE, null, GenericProductDTO.class,
			    Id);
		
		if(responseEntity.getBody()==null) throw new NotFoundException("product" + Id + "Not Found");
		
		return responseEntity.getBody();
	}

}
