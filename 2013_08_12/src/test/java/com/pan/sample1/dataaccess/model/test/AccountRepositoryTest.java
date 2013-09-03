package com.pan.sample1.dataaccess.model.test;

import static org.hamcrest.CoreMatchers.*;
import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;
import com.pan.sample1.dataaccess.service.*;
import com.pan.sample1.dataaccess.model.*;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import com.pan.sample1.dataaccess.repository.*;
@ContextConfiguration("classpath:after.xml")
public class AccountRepositoryTest extends AbstractTest {
	@Autowired 
	AccountRepository accountRepository;
	@Autowired
	CustomerRepository customerRepository;
	
	@Test
	public void saveAccount(){
		Account account=accountRepository.save(new Account());
		assertThat(account.getId(),is(notNullValue()));
	}
	
	@Test public void findCustomerAccounts(){
		Customer customer =customerRepository.findOne(1L);
		List<Account> accounts=accountRepository.findByCustomer(customer);
		Customer customer1=accounts.get(0).getCustomer();
		assertFalse(accounts.isEmpty());
		assertThat(accounts.get(0).getCustomer(),is(customer));
	}

}
