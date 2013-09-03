package com.pan.sample1.dataaccess.repository;
import java.util.*;
import org.springframework.data.repository.CrudRepository;
import com.pan.sample1.dataaccess.model.*;
public interface AccountRepository extends CrudRepository<Account,Long>{
	List<Account> findByCustomer(Customer customer);
	

}
