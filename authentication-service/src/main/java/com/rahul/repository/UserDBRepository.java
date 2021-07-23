package com.rahul.repository;

import com.rahul.entities.UserDB;
import org.springframework.data.repository.CrudRepository;

public interface UserDBRepository extends CrudRepository<UserDB,Integer> {
}
