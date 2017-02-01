package com.aswini.DAO;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.aswini.modal.FoodMenu;
import com.aswini.modal.FoodSchedule;
import com.aswini.modal.FoodStock;
import com.aswini.util.ConnectionUtil;

public class FoodStockDAO {
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();



	public void update(FoodStock foodStock) {

		String sql = "update food_stock set quantity=? where item_id=? and schedule_id=?";
		Object[] params = { foodStock.getQuantity(),foodStock.getItemId(),foodStock.getScheduleId() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows updated: " + rows);
	}

	public void delete(int id) {

		String sql = "delete from food_stock where id=?";
		int rows = jdbcTemplate.update(sql, id);
		System.out.println("No of rows deleted: " + rows);

	}
	public List<FoodStock> list() {

		String sql = "select id,item_id,schedule_id,quantity from food_stock";
		List<FoodStock> list = jdbcTemplate.query(sql, (rs, rowNum) -> {
			FoodStock foodStock= new FoodStock();
			foodStock.setId(rs.getInt("id"));
			FoodSchedule foodSchedule=new FoodSchedule();
			foodSchedule.setId(rs.getInt("id"));
			foodStock.setScheduleId(foodSchedule);
			
			FoodMenu foodMenu=new FoodMenu();
			foodMenu.setId(rs.getInt("item_id"));
			foodStock.setItemId(foodMenu);
			
			foodStock.setQuantity(rs.getInt("quantity"));
			return foodStock;

		});
		return list;


}
}
