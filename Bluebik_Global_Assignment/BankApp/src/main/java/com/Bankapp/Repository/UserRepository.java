package com.Bankapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Bankapp.Entity.Account;
import com.Bankapp.Entity.User;

public interface UserRepository extends JpaRepository<User,Long> {
	

}
