package in.org.npci.service;

import java.util.List;

import in.org.npci.beans.LoanApplication;

public interface LoanApplicationService {
	
	public LoanApplication createNewLoanApplication(LoanApplication application);
	
	public LoanApplication updateALoanApplication(LoanApplication application);
	
	public List<LoanApplication> getAllLoanApplicationsForCustomer(int customerId);
	
	public List<LoanApplication> getAllLoanApplicationsForEmployee();
}
