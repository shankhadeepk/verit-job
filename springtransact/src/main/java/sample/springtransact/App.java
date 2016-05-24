package sample.springtransact;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import sample.springtransact.beans.Employee;
import sample.springtransact.dao.EmpDAO;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext ctx=new ClassPathXmlApplicationContext("file:src/main/resources/app-context.xml");
    	
    	/*Employee emp=new Employee();
    	emp.setId(10);
    	emp.setEmpName("Shankha");
    	emp.setEmpSalary(20000.00);*/
    	
    	EmpDAO empDao=(EmpDAO) ctx.getBean("empDaoImpl");
    	//empDao.save(emp);
    	
    	System.out.println("Emp : "+empDao.get(10));
    	
        System.out.println( "Hello World!" );
    }
}
