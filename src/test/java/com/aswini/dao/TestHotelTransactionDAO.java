package com.aswini.dao;

import java.util.List;

import com.aswini.DAO.HotelTransactionDAO;
import com.aswini.modal.HotelTransaction;

public class TestHotelTransactionDAO {
	public static void main(String[] args) {
		HotelTransaction hotelTransaction = new HotelTransaction();
		HotelTransactionDAO hotelTransactionDAO = new HotelTransactionDAO();

		List<HotelTransaction> list = hotelTransactionDAO.list();
		for (HotelTransaction i : list) {
			System.out.println(i.getId() + "\t" + i.getOrderId().getOrderId() + "\t" + i.getMenuId().getId() + "\t"
					+ i.getQuantity() + "\t" + i.getOrderTime() + "\t" + i.getOrderDate()+ "\t" + i.getStatus());
		}

		hotelTransaction = hotelTransactionDAO.listById(105);
		System.out.println(hotelTransaction.getId() + "\t" + hotelTransaction.getOrderId().getOrderId() + "\t"
				+ hotelTransaction.getMenuId().getId() + "\t" + hotelTransaction.getQuantity() + "\t"
				+ hotelTransaction.getOrderTime() + "\t" + hotelTransaction.getOrderDate() + "\t" + hotelTransaction.getStatus());

		List<HotelTransaction> listDate = hotelTransactionDAO.listByCurrentDay();
		for (HotelTransaction i : listDate) {
			System.out.println(i.getId() + "\t" + i.getOrderId().getOrderId() + "\t" + i.getMenuId().getId() + "\t"
					+ i.getQuantity() + "\t" + i.getOrderTime() + "\t" + i.getOrderDate() + "\t" + i.getStatus());
		}

	}

}
