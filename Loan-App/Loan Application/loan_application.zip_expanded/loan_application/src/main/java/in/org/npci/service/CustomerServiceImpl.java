package in.org.npci.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.org.npci.beans.Customer;
import in.org.npci.beans.Loan;
import in.org.npci.beans.LoanApplication;
import in.org.npci.dao.CustomerDao;
import in.org.npci.dao.LoanDao;
import jakarta.transaction.Transactional;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private LoanService loanService;
	
	@Autowired
	private LoanApplicationService loanApplicationService;
	
//	@Autowired
//	private LoanApplicationDao loanApplication
	
	@Override
	@Transactional
	public Customer registerNewCustomer(Customer customer) {
		return customerDao.save(customer);
	}

	@Override
	public Customer validateCustomer(String email, String password) {
		return customerDao.findCustomerWithEmailAndPassword(email, password);
	}

	@Override
	public List<Loan> viewAllTypeOfLoans() {
		return loanService.getLoanOptions();
	}

	@Override
	public LoanApplication applyForNewLoan(LoanApplication loanApplication) {
		return loanApplicationService.createNewLoanApplication(loanApplication);
	}

	@Override
	public List<LoanApplication> viewLoanApplications(int customerId) {
		return loanApplicationService.getAllLoanApplicationsForCustomer(customerId);
	}

}
