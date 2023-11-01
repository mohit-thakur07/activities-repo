package in.org.npci.service;

import java.util.List;

import in.org.npci.beans.Customer;
import in.org.npci.beans.Loan;
import in.org.npci.beans.LoanApplication;
//import in.org.npci.beans.LoanApplication;

public interface CustomerService {
	public Customer registerNewCustomer(Customer customer);
	
	public Customer validateCustomer(String email, String password);
	
	public List<Loan> viewAllTypeOfLoans();
	
	public LoanApplication applyForNewLoan(LoanApplication loanApplication);
	
	public List<LoanApplication> viewLoanApplications(int customerId);
}
