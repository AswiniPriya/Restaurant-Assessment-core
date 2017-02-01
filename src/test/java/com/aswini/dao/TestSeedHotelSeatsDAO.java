package com.aswini.dao;

import java.util.Iterator;
import java.util.List;

import com.aswini.DAO.SeedHotelSeatsDAO;
import com.aswini.modal.SeedHotelSeats;

public class TestSeedHotelSeatsDAO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SeedHotelSeatsDAO seedHotelSeatsDAO=new SeedHotelSeatsDAO();
			
		List<SeedHotelSeats> list = seedHotelSeatsDAO.list();
		Iterator<SeedHotelSeats> i = list.iterator();
		while (i.hasNext()) {
			SeedHotelSeats seedHotelSeat = (SeedHotelSeats) i.next();
			System.out.println(seedHotelSeat.getId()+"\t"+seedHotelSeat.getSeatName());
		}
	}
}
