package com.aswini.dao;

import java.util.Iterator;
import java.util.List;

import com.aswini.DAO.OrderLimitDAO;
import com.aswini.modal.OrderLimit;

public class TestOrderLimitDAO {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		OrderLimitDAO orderLimitDAO=new OrderLimitDAO();
			
		List<OrderLimit> list = orderLimitDAO.list();
		Iterator<OrderLimit> i = list.iterator();
		while (i.hasNext()) {
			OrderLimit orderLimit = (OrderLimit) i.next();
			System.out.println(orderLimit.getId()+"\t"+orderLimit.getLimits());
		}
	}

}
