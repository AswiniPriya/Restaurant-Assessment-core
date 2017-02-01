package com.aswini.dao;

import java.util.Iterator;
import java.util.List;

import com.aswini.DAO.SeatStatusDAO;
import com.aswini.modal.SeatStatus;

public class TestSeatStatusDAO {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SeatStatusDAO seatStatusDAO=new SeatStatusDAO();
			
		List<SeatStatus> list = seatStatusDAO.list();
		Iterator<SeatStatus> i = list.iterator();
		while (i.hasNext()) {
			SeatStatus seatStatus = (SeatStatus) i.next();
			System.out.println(seatStatus.getId()+"\t"+seatStatus.getSeatId()+"\t"+seatStatus.getSeatStatus()+"\t"+seatStatus.isSeatState()+"\t"+seatStatus.getTakenTime());
		}
	}

}
