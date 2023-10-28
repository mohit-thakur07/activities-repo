package in.org.npci.service;

import java.util.List;

import in.org.npci.beans.Employee;
import in.org.npci.beans.LoanApplication;

public interface EmployeeService {
	public Employee validateEmployee(String email, String password);
	
	public List<LoanApplication> viewAllLoanApplications();
	
	public LoanApplication updateLoanApplicationStatus(LoanApplication loanApplication);
	
	public int viewCreditScoreOfCustomer(String pan);
}
