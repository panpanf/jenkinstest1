package com.pan.sample1.dataaccess.service;
import com.pan.sample1.dataaccess.model.*;
import java.util.List;
public interface AccountService {
	
	Account save(Account account);
	
	List<Account> findByCustomer(Customer customer);
}
