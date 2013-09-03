package com.pan.sample1.dataaccess.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import com.pan.sample1.dataaccess.model.Model1;
@Repository
public class Model1ServiceImpl implements Model1Service {

	@PersistenceContext 
	private EntityManager em;
	@Override
	public Model1 save() {
		// TODO Auto-generated method stub
		Model1 model1=new Model1();
		em.persist(model1);
		return model1;
	}

}
