package com.rahul.repository;

import com.rahul.entities.StockExchange;
import org.springframework.data.repository.CrudRepository;

public interface StockRepository extends CrudRepository<StockExchange, String> {
}
