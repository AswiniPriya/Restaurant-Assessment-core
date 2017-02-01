package com.aswini.DAO;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.aswini.modal.OrderDetail;
import com.aswini.util.ConnectionUtil;

public class OrderDetailDAO {
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();


	public void save(OrderDetail orderDetail) {

		String sql = "insert into order_detail(seat_number) values(?)";
		Object[] params = { orderDetail.getSeatNumber() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows inserted: " + rows);

	}
	
	public void update(OrderDetail orderDetail) {

		String sql = "update order_detail set seat_number where order_id=?";
		Object[] params = { orderDetail.getSeatNumber(),orderDetail.getOrderId() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows inserted: " + rows);
	}
	
	public void delete(int id) {

		String sql = "delete from order_detail where id=?";
		int rows = jdbcTemplate.update(sql, id);
		System.out.println("No of rows deleted: " + rows);

	}
	public List<OrderDetail> list() {

		String sql = "select order_id,seat_number from order_detail";
		List<OrderDetail> list = jdbcTemplate.query(sql, (rs, rowNum) -> {
			OrderDetail orderDetail=new OrderDetail();
			orderDetail.setOrderId(rs.getInt("order_id"));
			orderDetail.setSeatNumber(rs.getInt("seat_number"));
			
			return orderDetail;

		});
		return list;
	}

}
