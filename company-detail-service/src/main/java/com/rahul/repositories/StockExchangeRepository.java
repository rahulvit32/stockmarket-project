package com.rahul.repositories;

import com.rahul.entities.StockExchange;
import org.springframework.data.repository.CrudRepository;

public interface StockExchangeRepository extends CrudRepository<StockExchange,String> {
}
