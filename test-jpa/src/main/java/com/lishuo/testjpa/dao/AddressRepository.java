package com.lishuo.testjpa.dao;

import com.lishuo.testjpa.pojo.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}