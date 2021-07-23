package com.rahul.repositories;

import com.rahul.entities.Stock;
import org.springframework.data.repository.CrudRepository;

public interface StockRepository extends CrudRepository<Stock,Integer> {
}
