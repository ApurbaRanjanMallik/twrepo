package com.tw.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tw.springboot.entity.AccountDetails;
@Repository
public interface AccountsRepository extends JpaRepository<AccountDetails,Long> {

}
