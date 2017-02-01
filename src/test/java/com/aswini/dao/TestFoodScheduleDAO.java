package com.aswini.dao;

import java.util.Iterator;
import java.util.List;

import com.aswini.DAO.FoodScheduleDAO;
import com.aswini.modal.FoodSchedule;

public class TestFoodScheduleDAO {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FoodScheduleDAO foodScheduleDAO=new FoodScheduleDAO();
			
		List<FoodSchedule> list = foodScheduleDAO.list();
		Iterator<FoodSchedule> i = list.iterator();
		while (i.hasNext()) {
			FoodSchedule foodSchedule = (FoodSchedule) i.next();
			System.out.println(foodSchedule.getId()+"\t"+foodSchedule.getScheduleType()+"\t"+foodSchedule.getAvailableFromTime()+"\t"+foodSchedule.getAvailableToTime());
		}
	}
	
		}
