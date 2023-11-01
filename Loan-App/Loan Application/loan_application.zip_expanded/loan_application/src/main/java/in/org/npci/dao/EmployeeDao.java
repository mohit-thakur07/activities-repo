package in.org.npci.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.org.npci.beans.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Integer> {
	@Query("select e from Employee e where e.emailId = ?1 and e.password = ?2")
	public Employee findEmployeeWithEmailAndPassword(String emailId, String password);
}
