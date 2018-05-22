package com.springrest.userportal.repository;

import com.springrest.userportal.model.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository  extends CrudRepository<User, String> {


}

