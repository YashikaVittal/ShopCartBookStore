package com.org.book.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import com.org.book.cart.CartItem;
import com.org.book.dao.AddressDAO;
import com.org.book.dao.PoitemDAO;
import com.org.book.dao.PurchaseOrderDAO;
import com.org.book.dao.UserDAO;
import com.org.book.model.Address;
import com.org.book.model.PurchaseOrder;
import com.org.book.model.User;

@Path("/OrderProcess")
public class OrderProcessService {

	/**
	 * This Method is used to register a user with email, password and default Address details.
	 * 
	 * @param fname: First name of the user
	 * @param lname: Last name of the user
	 * @param pwd: Password for the user
	 * @param email: email id to register with
	 * @param street: Number and Street Name of default address
	 * @param city: City of the default address
	 * @param province: Province of the default address
	 * @param country: country of the default address
	 * @param zip: zip of the default address
	 * @param: phone Number of the user
	 * @returns: A valid registered user, Null Otherwise
	 * 
	 */
	@GET
	@Path("/registerUser")
	@Produces(MediaType.APPLICATION_JSON)
	public User registerUser(@QueryParam("fname") String fname, @QueryParam("lname") String lname,
			@QueryParam("pwd") String pwd, @QueryParam("email") String email,
			@QueryParam("street") String street, @QueryParam("city") String city,@QueryParam("province") String province,
			@QueryParam("country") String country, @QueryParam("zip") String zip, @QueryParam("phone") String phone) 
	{

		UserDAO userdao = new UserDAO();
		User user,newUser;
		AddressDAO addressdao = new AddressDAO();
		boolean result = false;
		
		//Check if the user if the same email id exists or not
		user = userdao.getUserDetails(email);
		
		if(user == null)
		{
			//Add the user details into the DB through userDAO
			result = userdao.addUserDetails(fname, lname, pwd, email);

			//Check if the user details are added successfully
			if (result == true) {
				//Get the customerid(Primary key) from the user table
				newUser = userdao.getUserDetails(email);

				//Add the address details for the corresponding user(customerid) to the address table
				@SuppressWarnings("null")
				boolean addResult = addressdao.addAddressDetails(newUser.getCustomerid(), street, city, province, country, zip, phone);
				if (addResult == true) {
					return newUser;
				}
			} else
				return null;
		}
		else
		{
			//Customer with the same email ID already exists
			return null;
		}
		return null;
	}


	/**
	 * This method checks if the user has already registered or not
	 * 
	 * @param: email id of the user
	 * @returns: user corresponding to email id, Null Otherwise
	 * 
	 */
	@GET
	@Path("/isValidUser")
	@Produces(MediaType.APPLICATION_JSON)
	public User validateUser(@QueryParam("email") String email) {
		UserDAO userdao = new UserDAO();
		User user = userdao.getUserDetails(email);
		return user;
	}


	// Status of the Order placed by the user
	String[] status = new String[] { "ORDERED", "DENIED", "CREATED" };

	/**
	 * This method creates a new order in the Database table Purchaseorder
	 * 
	 * @param customerid: customer who is placing the order
	 * @param cartTotal: The total price of books that the user has ordered
	 * @returns purchaseOrder: A purchaseorderId is generated with status as "created"
	 * 
	 */
	@GET
	@Path("/order")
	@Produces(MediaType.APPLICATION_JSON)
	public PurchaseOrder orderIt(@QueryParam(value = "customerid") String customerid, @QueryParam(value = "cart_total") double cartTotal) {
		AddressDAO addressdao = new AddressDAO();
		PurchaseOrderDAO purchaseorderdao = new PurchaseOrderDAO();

		//Get Address to display in order details
		Address customerAddr = addressdao.getAddressDetails(customerid);

		double shipping = 10.50; //Standard shipping
		double taxAmt = cartTotal * 0.13; //13% Tax  

		double grandTotal = shipping + taxAmt + cartTotal;

		//Create an order in Purchase order table
		PurchaseOrder PO = purchaseorderdao.addPurchaseOrderDetails(status[2] ,customerid, customerAddr.getId(), grandTotal);
		PO.setAddr(customerAddr);
		return PO;
	}

	/**
	 * This method places all the items from the cart into poitems for a specified PurchaseOrder ID
	 * Changes the status of the Purchase order from "created" to "ordered" or "denied"
	 * 
	 * @param POID: purchase order ID
	 * @param cart: all the books added by the user in the cart
	 * @returns order_done: True if all items are added succesfully, false otherwise
	 * 
	 */
	@PUT
	@Path("/confirmOrder/{POID}")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public Boolean placeorder(@PathParam("POID") int POID, List<CartItem> cart) {

		PoitemDAO poitemdao = new PoitemDAO();
		PurchaseOrderDAO purchaseorderdao = new PurchaseOrderDAO();
		boolean done = false;

		//check if the entry in Purchase Order table is multiples of 5
		long count = purchaseorderdao.getCountOfPurchaseOrder();
		if((count % 5) == 0) {
			//5th entry in table PurchaseOrder, deny the order
			purchaseorderdao.setPurcahseOrderStatus(POID, status[1]);
		}
		//not the 5th entry, confirm the order
		else {
			for(CartItem cartitem : cart) {
				int bookid = cartitem.getBookid();
				int price = cartitem.getPrice();
				int quantity = cartitem.getQuantity();
				done = poitemdao.addPoitemDetails(POID, bookid, price, quantity);
			}
			if(done == true) {
				purchaseorderdao.setPurcahseOrderStatus(POID, status[0]);
			}
		}
		return done;
	}


}