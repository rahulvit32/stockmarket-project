package com.rahul.repositories;

import com.rahul.entities.Company;
import org.springframework.data.repository.CrudRepository;

public interface CompanyRepository extends CrudRepository<Company,Integer> {
}


