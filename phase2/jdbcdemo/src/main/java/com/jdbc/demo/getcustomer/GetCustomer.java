package com.jdbc.demo.getcustomer;

import com.jdbc.demo.dao.CustomerDAO;
import com.jdbc.demo.insert.Customer;

public class GetCustomer {

	public static void main(String[] args) {
		CustomerDAO dao=new CustomerDAO();
		Customer customer=dao.getCustomerById(100);
		if(customer!=null) {
			System.out.println("Customer found with below details ");
			System.out.println(customer);
		}else {
			System.out.println("Customer Not found");
		}

	}

}
