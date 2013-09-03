package com.pan.sample1.dataaccess.model.test;
import org.springframework.test.context.transaction.BeforeTransaction;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
public abstract class AbstractTest extends AbstractTransactionalJUnit4SpringContextTests {

	@BeforeTransaction 
	public void setupData() throws Exception{
		//???
		int a=0;
		a=5;
		
		if(countRowsInTable("customer")==0){
			executeSqlScript("classpath:data.sql",false);
		}
		
	}
	
}
