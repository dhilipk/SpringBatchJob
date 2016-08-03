package com.studies.sample.reader;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

import org.springframework.jdbc.core.RowMapper;

import com.studies.sample.domain.PaymentProgram;

public class PaymentProgramMapper implements RowMapper<PaymentProgram> {

	@Override
	public PaymentProgram mapRow(ResultSet rs, int rowNumber) throws SQLException {
		PaymentProgram pp = new PaymentProgram();
		pp.setId(rs.getInt("ID"));
		pp.setProgramAmt(rs.getDouble("PROGRAM_AMT"));
		pp.setProgramName(rs.getString("PROGRAM_NAME"));
		pp.setTenure(rs.getInt("TENURE"));
		System.out.println(pp.toString());
		return pp;
	}

}
