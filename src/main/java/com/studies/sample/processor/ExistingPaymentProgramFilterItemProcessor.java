package com.studies.sample.processor;

import org.springframework.batch.item.ItemProcessor;

import com.studies.sample.domain.PaymentProgram;

public class ExistingPaymentProgramFilterItemProcessor implements ItemProcessor<PaymentProgram, PaymentProgram> {

	@Override
	public PaymentProgram process(PaymentProgram paymentProgram) throws Exception {
		return null;
	}

}
