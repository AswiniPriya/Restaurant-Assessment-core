package com.aswini.DAO;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.aswini.modal.FoodMenu;
import com.aswini.util.ConnectionUtil;

public class FoodMenuDAO {

	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public void update(FoodMenu foodMenu) {
		String sql = "update food_menu set item=? where id=?";
		Object[] params = { foodMenu.getItem(), foodMenu.getId() };
	
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No. of row(s) updated : " + rows);

	}

	public void delete(int id) {
		String sql = "delete from food_menu where id=?";
		int rows = jdbcTemplate.update(sql, id);
		System.out.println("No. of row(s) deleted : " + rows);
	}

	public List<FoodMenu> list() {
		String sql = "select id,item from food_menu";
		List<FoodMenu> list = jdbcTemplate.query(sql, (rs, rowNum) -> {
			FoodMenu foodMenu = new FoodMenu();
			foodMenu.setId(rs.getInt("id"));
			foodMenu.setItem(rs.getString("item"));
			return foodMenu;
		});
		return list;
	}

	public List<String> findItemByNames() {
		String sql = "SELECT item FROM food_menu";
		List<String> itemList = jdbcTemplate.queryForList(sql, String.class);
		return itemList;
	}

	public FoodMenu listByName(String item) {
		FoodMenu foodmenu = null;
			String sql = "select id,item from food_menu where item=?";
			Object[] params = { item };
			foodmenu = (FoodMenu) jdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> {
				FoodMenu i = new FoodMenu();
				i.setId(rs.getInt("id"));
				i.setItem(rs.getString("item"));
				return i;
			});
		return foodmenu;
	}

	public FoodMenu listById(int id) {
		FoodMenu foodmenu = null;
			String sql = "select id,item from food_menu where id=?";
			Object[] params = { id };
			foodmenu = (FoodMenu) jdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> {
				FoodMenu i = new FoodMenu();
				i.setId(rs.getInt("id"));
				i.setItem(rs.getString("item"));
				return i;
			});
		return foodmenu;
	}

}
