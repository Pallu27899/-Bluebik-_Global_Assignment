package com.Bankapp.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Bankapp.Entity.Account;

public interface AccountRepository extends JpaRepository<Account,Long> {

	List<Account> findByUsersUserId(Long userId);

}
