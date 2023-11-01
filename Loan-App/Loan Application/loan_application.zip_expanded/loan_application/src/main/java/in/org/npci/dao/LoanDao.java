package in.org.npci.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import in.org.npci.beans.Loan;

public interface LoanDao extends JpaRepository<Loan, Integer> {

}
