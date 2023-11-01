package in.org.npci.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.org.npci.beans.CreditScore;
import in.org.npci.dao.CreditScoreDao;

@Service("creditScoreService")
public class CreditScoreServiceImpl implements CreditScoreService {

	@Autowired
	private CreditScoreDao creditScoreDao;
	
	@Override
	public int getCreditScore(String pan) {
		Optional<CreditScore> creditScore = creditScoreDao.findById(pan);
		if(creditScore.isPresent()) {
			return creditScore.get().getScore();
		}
		return 0;
	}

}
