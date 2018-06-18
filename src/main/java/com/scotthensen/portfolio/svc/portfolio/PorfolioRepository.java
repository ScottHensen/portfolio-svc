package com.scotthensen.portfolio.svc.portfolio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PorfolioRepository extends JpaRepository<Portfolio, Long>{


}
