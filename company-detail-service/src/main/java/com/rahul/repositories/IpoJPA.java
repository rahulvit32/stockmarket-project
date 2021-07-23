package com.rahul.repositories;

import com.rahul.entities.Company;
import com.rahul.entities.IPO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IpoJPA extends JpaRepository<IPO,Integer> {
    public IPO findByCompanyId(Company companyId);
}
