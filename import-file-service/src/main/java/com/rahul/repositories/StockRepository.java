package com.rahul.repositories;

import com.rahul.entity.Stock;
import org.springframework.data.repository.CrudRepository;

public interface StockRepository extends CrudRepository<Stock,Integer> {
}
