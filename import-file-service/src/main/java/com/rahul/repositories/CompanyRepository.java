package com.rahul.repositories;

import com.rahul.entity.Company;
import org.springframework.data.repository.CrudRepository;

public interface CompanyRepository  extends CrudRepository<Company,Integer> {
}


