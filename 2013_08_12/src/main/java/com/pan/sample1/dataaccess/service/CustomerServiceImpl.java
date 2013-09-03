package com.pan.sample1.dataaccess.service;

import com.pan.sample1.dataaccess.model.Customer;
import org.springframework.stereotype.Repository;
import javax.persistence.*;
@Repository 
public class CustomerServiceImpl implements CustomerService {

	@PersistenceContext
	private EntityManager em;
	@Override
	public Customer findById(Long id) {
		// TODO Auto-generated method stub
		return em.find(Customer.class, id);
	}

	@Override
	public Customer save(Customer customer) {
		// TODO Auto-generated method stub
		if(customer.getId()==null){
			em.persist(customer);
			return customer;
		}else{
			return em.merge(customer);
		}
	}

}
