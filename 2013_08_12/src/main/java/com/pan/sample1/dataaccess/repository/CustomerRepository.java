package com.pan.sample1.dataaccess.repository;

import org.springframework.data.repository.CrudRepository;
import com.pan.sample1.dataaccess.model.*;
import java.util.*;
import org.springframework.data.domain.*;
public interface CustomerRepository extends CrudRepository<Customer, Long> {
	
	List<Customer> findByLastName(String lastName);
	Page<Customer> findByLastName(String lastName,Pageable pageable);
	
	

}
