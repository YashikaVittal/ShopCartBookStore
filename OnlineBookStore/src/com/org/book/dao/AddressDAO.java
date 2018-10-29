package com.org.book.dao;

import java.util.List;
import java.util.Random;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletConfig;
import javax.servlet.*;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.org.book.model.*;

public class AddressDAO implements AddressDAOInterface{
	
	/**
	 * Method to add default Address details of the user when registering in the website
	 * The queries are referred from address.hbm.xml file
	 * 
	 * @return boolean True if Address added in Database Table Address Successfully, False Otherwise
	 */
	public boolean addAddressDetails(int customerid,String street, String city,String province, String country,String zip, String phone) {

		try {
			Address address = new Address();
			address.setStreet(street);
			address.setProvince(province);
			address.setCountry(country);
			address.setZip(zip);
			address.setCity(city);
			address.setPhone(phone);
			address.setCustomerid(customerid);

			Session session = HibernateConnection.getSession();
			Transaction transaction = session.beginTransaction();

			session.save(address);

			HibernateConnection.endTransaction(transaction);
			return true;
		}
		catch(HibernateException e) {
			System.out.println(e.getMessage());
			System.out.println("error");
			return false;
		}
	}
	
	/**
	 * Retrieves the default Address of the User whose customerId is taken as the input
	 * The queries are referred from address.hbm.xml file
	 * 
	 * @param CustomerId: Identifies the user whose Address details are retrived
	 * @return Address: Default Address of the user
	 */
	public Address getAddressDetails(String customerid){
		try {

			Session session = HibernateConnection.getSession();
			Transaction transaction = session.beginTransaction();

			Query query = session.getNamedQuery("getAddressByCustomerid").setString("customerid", customerid);

			@SuppressWarnings("unchecked")
			List<Address> address = query.list();			
			HibernateConnection.endTransaction(transaction);
			return address.iterator().next();
		}
		catch(HibernateException e) {
			System.out.println(e.getMessage());
			System.out.println("error");
			return null;
		}
	}
}
