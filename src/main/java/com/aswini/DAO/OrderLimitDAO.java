package com.aswini.DAO;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.aswini.modal.OrderLimit;
import com.aswini.util.ConnectionUtil;

public class OrderLimitDAO {
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();


	public void save(OrderLimit orderLimit) {

		String sql = "insert into order_limit(id,limits) values(?,?)";
		Object[] params = { orderLimit.getId(),orderLimit.getLimits() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows inserted: " + rows);

	}
	
	public void update(OrderLimit orderLimit) {

		String sql = "update order_limit set limits=? where id=?";
		Object[] params = { orderLimit.getLimits(),orderLimit.getId() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows updated: " + rows);
	}

	public void delete(int id) {

		String sql = "delete from order_limit where id=?";
		int rows = jdbcTemplate.update(sql, id);
		System.out.println("No of rows deleted: " + rows);

	}
	public List<OrderLimit> list() {

		String sql = "select id,limits from order_limit";
		List<OrderLimit> list = jdbcTemplate.query(sql, (rs, rowNum) -> {
			OrderLimit orderLimit=new OrderLimit();
			orderLimit.setId(rs.getInt("id"));
			orderLimit.setLimits(rs.getInt("limits"));
			return orderLimit;

		});
		return list;
	}


}
