package in.org.npci.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.org.npci.beans.LoanApplication;
import in.org.npci.dao.LoanApplicationDao;

@Service("loanApplicationService")
public class LoanApplicationServiceImpl implements LoanApplicationService {
	
	@Autowired
	private LoanApplicationDao loanApplicationDao;

	@Override
	public LoanApplication createNewLoanApplication(LoanApplication application) {
		return loanApplicationDao.save(application);
	}

	@Override
	public LoanApplication updateALoanApplication(LoanApplication loanApplication) {
		return loanApplicationDao.save(loanApplication);
	}

	@Override
	public List<LoanApplication> getAllLoanApplicationsForCustomer(int customerId) {
		return loanApplicationDao.findAllLoanApplicationsForCustomer(customerId);
	}

	@Override
	public List<LoanApplication> getAllLoanApplicationsForEmployee() {
		return loanApplicationDao.findAllLoanApplicationsForEmployee();
	}

}
