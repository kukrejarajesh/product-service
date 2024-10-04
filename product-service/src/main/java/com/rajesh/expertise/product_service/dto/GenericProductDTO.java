package com.rajesh.expertise.product_service.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter


public class GenericProductDTO {
	Long id;
    String title;
    float price;
    String category;
    String description;
    String image;
}