package in.org.npci.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.org.npci.beans.Loan;
import in.org.npci.dao.LoanDao;

@Service("loanService")
public class LoanServiceImpl implements LoanService {

	@Autowired
	private LoanDao loanDao;
	
	@Override
	public List<Loan> getLoanOptions() {
		return loanDao.findAll();
	}

}
