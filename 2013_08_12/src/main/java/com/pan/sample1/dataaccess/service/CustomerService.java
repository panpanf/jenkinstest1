package com.pan.sample1.dataaccess.service;
import com.pan.sample1.dataaccess.model.*;
public interface CustomerService {

	Customer findById(Long id);
	
	Customer save(Customer customer);
	
}
