package com.aswini.dao;

import java.util.Iterator;
import java.util.List;

import com.aswini.DAO.OrderDetailDAO;
import com.aswini.modal.OrderDetail;

public class TestOrderDetail {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		OrderDetailDAO orderDetailDAO=new OrderDetailDAO();
			
		List<OrderDetail> list = orderDetailDAO.list();
		Iterator<OrderDetail> i = list.iterator();
		while (i.hasNext()) {
			OrderDetail orderDetail = (OrderDetail) i.next();
			System.out.println(orderDetail.getOrderId()+"\t"+orderDetail.getSeatNumber());
		}
	}

}
