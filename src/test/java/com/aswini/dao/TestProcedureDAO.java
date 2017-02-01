package com.aswini.dao;

import com.aswini.DAO.ProcedureDAO;

public class TestProcedureDAO {
	public static void main(String[] args) {
		ProcedureDAO dao = new ProcedureDAO();

		
		String status=dao.orderFood(2,"Coffee", 5);
		 System.out.println(status);
		 
		String status1 = dao.cancelOrder(2, "Coffee", "@message");
		System.out.println(status1);
		
		String status2 = dao.addItem(17, "Coffee", "Lunch","@message");
		System.out.println(status2);

	}

}
