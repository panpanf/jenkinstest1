package com.pan.sample1.dataaccess.model.test;
import static org.hamcrest.CoreMatchers.*;

import java.util.*;

import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.runner.RunWith;

import com.pan.sample1.dataaccess.repository.AccountRepository;
import com.pan.sample1.dataaccess.repository.CustomerRepository;
import com.pan.sample1.dataaccess.service.*;
import com.pan.sample1.dataaccess.model.*;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;

import com.pan.sample1.dataaccess.config.*;

import org.springframework.test.context.junit4.*;

//@ContextConfiguration("classpath:before.xml")
@ContextConfiguration(classes=Sample1Config.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class Test1 {
	@Autowired 
	AccountRepository accountRepository;
	@Autowired
	CustomerRepository customerRepository;
	
	@Test
	public void emptyTest(){
		
	}
	@Test
	public void saveAccount(){
		Account account=accountRepository.save(new Account());
		assertThat(account.getId(),is(notNullValue()));
	}
	/*
	@Test
	public void saveModel1(){
		Model1 model1=model1Service.save();
		assertThat(model1.getId(),is(notNullValue()));
	}
	*/
	/*
	@Test
	public void saveAccount(){
		Account account=accountService.save(new Account());
		assertThat(account.getId(), is(notNullValue()));
	}
	*/
	

}
