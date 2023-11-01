package in.org.npci.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import in.org.npci.beans.CreditScore;

public interface CreditScoreDao extends JpaRepository<CreditScore, String> {

}
