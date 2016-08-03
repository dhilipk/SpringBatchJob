package com.studies.sample.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PaymentProgram {

	private Integer id;
	private String programName;
	private Double programAmt;
	private Integer tenure;
}
