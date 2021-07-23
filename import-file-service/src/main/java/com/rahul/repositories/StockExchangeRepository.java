package com.rahul.repositories;

import com.rahul.entity.StockExchange;
import org.springframework.data.repository.CrudRepository;

public interface StockExchangeRepository extends CrudRepository<StockExchange,String> {
}
