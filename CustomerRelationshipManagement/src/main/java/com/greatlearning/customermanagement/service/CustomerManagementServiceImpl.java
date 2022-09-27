package com.greatlearning.customermanagement.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.customermanagement.entity.Customer;

@Service
public class CustomerManagementServiceImpl implements CustomerManagementService {

	SessionFactory sessionFactory;
	Session session;
	
	@Autowired
	public CustomerManagementServiceImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		try {
			this.session = sessionFactory.getCurrentSession();
		}catch(Exception e) {
			this.session = sessionFactory.openSession();
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Customer> getCustomerList() {

		List<Customer> custLists = new ArrayList<>();
		custLists = session.createQuery("from Customer").list();
		return custLists;
	}

	@Override
	@Transactional
	public void deleteCustomerById(int id) {
		Transaction tx = session.beginTransaction();
		Customer cutomer = session.get(Customer.class, id);
		session.delete(cutomer);
		tx.commit();
		
	}

	@Override
	public void saveCustomer(Customer customer) {
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(customer);
		tx.commit();
	}
	
	@Override
	public Customer getCustomerById(int id) {
		Customer customer = new Customer();
		Transaction tx = session.beginTransaction();
		customer = session.get(Customer.class, id);
		tx.commit();
		return customer;
	}

}
