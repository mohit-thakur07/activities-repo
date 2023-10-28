package in.org.npci.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.org.npci.beans.Customer;

public interface CustomerDao extends JpaRepository<Customer, Integer> {
	@Query("select c from Customer c where c.emailId = ?1 and c.password = ?2")
	public Customer findCustomerWithEmailAndPassword(String emailId, String password);
}
