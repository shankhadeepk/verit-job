package sample.springtransact.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import sample.springtransact.beans.EmpRowMapper;
import sample.springtransact.beans.Employee;

@Component("empDaoImpl")
public class EmpDAOImpl implements EmpDAO{
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private DataSource dataSource;
	
	public void save(Employee emp){
		String query="INSERT INTO EMP(EMPID,EMPNAME,EMPSALARY) VALUES(?,?,?)";
		jdbcTemplate = new JdbcTemplate(dataSource);
		
		jdbcTemplate.update(query,new Object[]{emp.getId(),emp.getEmpName(),emp.getEmpSalary()});
		
		System.out.println("Emp is updated");
		
	}
	public Employee get(int empId){
		String query="SELECT EMPID,EMPNAME,EMPSALARY FROM EMP WHERE EMPID = ?";
		jdbcTemplate = new JdbcTemplate(dataSource);
		
		Employee emp=(Employee)jdbcTemplate.queryForObject(query,new Object[]{empId},new EmpRowMapper());
		
		System.out.println("Emp is achieved" + emp);
		
		return emp;
		
	}
}
