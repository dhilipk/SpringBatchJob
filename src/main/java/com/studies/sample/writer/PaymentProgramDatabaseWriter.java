package com.studies.sample.writer;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.batch.item.ItemWriter;
import org.springframework.jdbc.core.JdbcTemplate;

import com.studies.sample.domain.PaymentProgram;

public class PaymentProgramDatabaseWriter implements ItemWriter<PaymentProgram> {

	private JdbcTemplate jdbcTemplate;
	
	public PaymentProgramDatabaseWriter(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	@Override
	public void write(List<? extends PaymentProgram> pPrograms) throws Exception {
		for (PaymentProgram paymentProgram : pPrograms) {
			jdbcTemplate.update("INSERT INTO PAYMENT_PROGRAM VALUES (?, ?, ?, ?)", paymentProgram.getId(), paymentProgram.getProgramName(), 
					paymentProgram.getProgramAmt(), paymentProgram.getTenure());
			System.out.println("Insered :: " + paymentProgram.toString());
		}
		
	}

}
