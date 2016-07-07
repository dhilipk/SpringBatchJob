package com.studies.sample.domain;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Product {
	
	private Integer productId;
	
	private String name;
	
	private String description;

	private BigDecimal price;
}
