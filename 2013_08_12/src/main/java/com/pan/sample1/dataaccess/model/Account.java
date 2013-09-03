package com.pan.sample1.dataaccess.model;
import javax.persistence.*;
import java.util.*;
@Entity 
public class Account {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	private Customer customer;
	
	public Customer getCustomer() {
		return customer;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}
    @Temporal(TemporalType.DATE)
	private Date expiryDate;
	
	public Long getId(){
		return id;
	}

}
