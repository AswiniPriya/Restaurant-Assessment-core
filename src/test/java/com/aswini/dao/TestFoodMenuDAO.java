package com.aswini.dao;

import java.util.List;

import com.aswini.DAO.FoodMenuDAO;
//import com.aswini.modal.FoodMenu;

public class TestFoodMenuDAO {
	
	public static void main(String[] args) {
		//FoodMenu foodMenu = new FoodMenu();
		
		FoodMenuDAO foodMenuDAO = new FoodMenuDAO();

		//foodMenuDAO.update(foodMenu);
		//foodMenuDAO.delete(15);

		/*List<FoodMenu> list = foodMenuDAO.list();
		for (FoodMenu i : list) {
			System.out.println(i);
		}*/

		//foodMenu = foodMenuDAO.listByName("Idly");
		//System.out.println(foodMenu);

		//foodMenu = foodMenuDAO.listById(14);
		//System.out.println(foodMenu);

		List<String> itemNames = foodMenuDAO.findItemByNames();
		for (String itemName : itemNames) {
			System.out.println(itemName);
		}

	}


}
