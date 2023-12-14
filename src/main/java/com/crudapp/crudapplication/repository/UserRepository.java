package com.crudapp.crudapplication.repository;


import com.crudapp.crudapplication.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer> {
}
