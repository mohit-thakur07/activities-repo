package in.org.npci.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.org.npci.beans.LoanApplication;

public interface LoanApplicationDao extends JpaRepository<LoanApplication, Integer> {
	@Query("select lA from LoanApplication lA where lA.customerId = ?1")
	public List<LoanApplication> findAllLoanApplicationsForCustomer(int customerId);
	
	@Query("select lA from LoanApplication lA where lA.status = 'pending'")
	public List<LoanApplication> findAllLoanApplicationsForEmployee();
}
