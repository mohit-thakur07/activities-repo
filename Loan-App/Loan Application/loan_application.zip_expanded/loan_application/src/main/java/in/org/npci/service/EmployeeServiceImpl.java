package in.org.npci.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.org.npci.beans.Employee;
import in.org.npci.beans.LoanApplication;
import in.org.npci.dao.EmployeeDao;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDao employeeDao;
	
	@Autowired
	private CreditScoreServiceImpl creditScoreService;
	
	@Autowired
	private LoanApplicationServiceImpl loanApplicationService;

	@Override
	public Employee validateEmployee(String email, String password) {
		return employeeDao.findEmployeeWithEmailAndPassword(email, password);
	}

	@Override
	public LoanApplication updateLoanApplicationStatus(LoanApplication loanApplication) {
		return loanApplicationService.updateALoanApplication(loanApplication);
	}

	@Override
	public int viewCreditScoreOfCustomer(String pan) {
		return creditScoreService.getCreditScore(pan);
	}

	@Override
	public List<LoanApplication> viewAllLoanApplications() {
		return loanApplicationService.getAllLoanApplicationsForEmployee();
	}

}
