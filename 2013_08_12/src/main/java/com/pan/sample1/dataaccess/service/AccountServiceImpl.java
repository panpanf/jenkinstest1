package com.pan.sample1.dataaccess.service;

import java.util.List;

import javax.persistence.*;
import com.pan.sample1.dataaccess.model.Account;
import com.pan.sample1.dataaccess.model.Customer;
import org.springframework.stereotype.Repository;
@Repository
public class AccountServiceImpl implements AccountService {
    @PersistenceContext 
	private EntityManager em;
	@Override
	public Account save(Account account) {
		// TODO Auto-generated method stub
		if(account.getId()==null){
			em.persist(account);
			return account;
		}else{
			return em.merge(account);
		}
		
	}

	@Override
	public List<Account> findByCustomer(Customer customer) {
		// TODO Auto-generated method stub
		TypedQuery<Account> query=em.createQuery("select a from Account a where a.customer=?1",Account.class);
		query.setParameter(1, customer);
		return query.getResultList();
	}

}
