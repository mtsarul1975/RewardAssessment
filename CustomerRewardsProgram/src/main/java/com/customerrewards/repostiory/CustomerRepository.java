package com.customerrewards.repostiory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.customerrewards.Entity.CustomerDetails;


@Repository
public interface CustomerRepository extends JpaRepository<CustomerDetails, Integer> {
	
	public CustomerDetails findByCustomerId(int customer);

}
