package com.aswini.dao;

import java.util.Iterator;
import java.util.List;

import com.aswini.DAO.FoodStockDAO;
import com.aswini.modal.FoodStock;

public class TestFoodStockDAO {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FoodStockDAO foodStockDAO=new FoodStockDAO();
		
	

		//foodStockDAO.update(10,1,1);
		//foodStockDAO.delete(15);

		List<FoodStock> list = foodStockDAO.list();
		Iterator<FoodStock> i = list.iterator();
		while (i.hasNext()) {
			FoodStock foodStock = (FoodStock) i.next();
			System.out.println(foodStock.getId()+"\t"+foodStock.getItemId().getId()+"\t"+foodStock.getScheduleId().getId()+"\t"+foodStock.getQuantity());
		}
	}

}
