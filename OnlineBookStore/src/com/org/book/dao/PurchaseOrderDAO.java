package com.org.book.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.org.book.model.Poitem;
import com.org.book.model.PurchaseOrder;

public class PurchaseOrderDAO {

	/**
	 * A method to add Purchase Order into Database table PurchaseOrder
	 * The queries are referred from purchaseorder.hbm.xml file
	 * 
	 * @param status of the order
	 * @param customerid to identify the user
	 * @param address where the order is sent
	 * @param amount of the order including shipping and tax
	 * @return Purchaseorder created
	 *
	 */
	public PurchaseOrder addPurchaseOrderDetails(String status, String customerid, int address, double amount ) {
		try {

			PurchaseOrder purchaseorder = new PurchaseOrder();
			purchaseorder.setStatus(status);
			purchaseorder.setAddress(address);
			Integer custId = Integer.parseInt(customerid);
			purchaseorder.setCustomerid(custId);
			purchaseorder.setAmount(amount);

			Session session = HibernateConnection.getSession();
			Transaction transaction = session.beginTransaction();

			session.save(purchaseorder); 

			HibernateConnection.endTransaction(transaction);

			return purchaseorder;
		}
		catch(HibernateException e)
		{

			System.out.println(e.getMessage());
			System.out.println("error");
			return null;

		}

	}

	/**
	 * A method to get Purchase Order details given the purchase order ID
	 * The queries are referred from purchaseorder.hbm.xml file
	 * 
	 * @param purchaseorder id
	 * @return Purchase order corresponding to the id provided
	 * 
	 */
	public PurchaseOrder getPurchaseOrderByPOID(int POID) {
		try
		{
			String purchaseorderid = Integer.toString(POID);
			Session session = HibernateConnection.getSession();
			Transaction transaction = session.beginTransaction();

			Query query = session.getNamedQuery("findPurchaseOrderByPOid").setString("poid", purchaseorderid);
			PurchaseOrder PO = (PurchaseOrder) query.uniqueResult();

			HibernateConnection.endTransaction(transaction);
			return PO;
		}
		catch(HibernateException e)
		{

			System.out.println(e.getMessage());
			return null;

		}
	}
	
	/**
	 * A method to update the status of the purchase order
	 * The queries are referred from purchaseorder.hbm.xml file
	 * 
	 * @param status of the order to be set
	 * @return status set or not
	 */
	public int setPurcahseOrderStatus(int POID, String status) {
		try {
			String purchaseorderid = Integer.toString(POID);
			Session session = HibernateConnection.getSession();
			Transaction transaction = session.beginTransaction();
			
			int updated = session.getNamedQuery("updateStatusByPOID").setString("poid", purchaseorderid).setString("status", status).executeUpdate();
		
			HibernateConnection.endTransaction(transaction);
			return updated;
			
		}
		catch(HibernateException e)
		{
			System.out.println(e.getMessage());
			return 0;

		}

	}
	
	/**
	 * A method to count the total number of orders in the purchaseorder table
	 * The queries are referred from purchaseorder.hbm.xml file
	 * 
	 * @return count
	 */
	public long getCountOfPurchaseOrder() {
		try {
			Session session = HibernateConnection.getSession();
			
			Query query = session.getNamedQuery("countRowsInPO");
			long count = (long) query.uniqueResult();
			
			return count;
			
		}
		catch(HibernateException e)
		{
			System.out.println(e.getMessage());
			return 0;

		}

	}
}
