package com.aswini.DAO;

import org.springframework.jdbc.core.JdbcTemplate;

import com.aswini.util.ConnectionUtil;

public class FunctionDAO {
	
JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();
	
	public int getItemId(String item) 
	{
		String sql = "select fn_get_item_id(?)";
		Object[] params = { item };
		int itemID = jdbcTemplate.queryForObject(sql, params, int.class);
		return itemID;
	}
}

