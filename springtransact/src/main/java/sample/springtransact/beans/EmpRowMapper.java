package sample.springtransact.beans;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class EmpRowMapper implements RowMapper {

	public Object mapRow(ResultSet result, int rowNum) throws SQLException {
		Employee emp=new Employee();
		emp.setId(result.getInt("EMPID"));
		emp.setEmpName(result.getString("EMPNAME"));
		emp.setEmpSalary(result.getDouble("EMPSALARY"));
		return emp;
	}

}
