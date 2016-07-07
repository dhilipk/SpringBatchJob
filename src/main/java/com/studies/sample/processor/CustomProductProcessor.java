package com.studies.sample.processor;

import org.springframework.batch.item.ItemProcessor;

import com.studies.sample.domain.Product;

public class CustomProductProcessor implements ItemProcessor<Product, Product> {

	public Product process(Product product) throws Exception {
		System.out.println("Processor ...");
		return product;
	}

}
