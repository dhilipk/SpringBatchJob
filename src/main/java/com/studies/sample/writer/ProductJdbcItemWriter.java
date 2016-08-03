package com.studies.sample.writer;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.batch.item.ItemWriter;
import org.springframework.jdbc.core.JdbcTemplate;

import com.studies.sample.domain.Product;

public class ProductJdbcItemWriter implements ItemWriter<Product> {

	private JdbcTemplate jdbcTemplate;
	
	private static final String UPDATE_PRODUCT = "update ";

	public ProductJdbcItemWriter(DataSource ds) {
		this.jdbcTemplate = new JdbcTemplate(ds);
	}
	
	public void write(List<? extends Product> items) throws Exception {
		for (Product item : items) {
			System.out.println(item.getName());
		}
		
	}

}
