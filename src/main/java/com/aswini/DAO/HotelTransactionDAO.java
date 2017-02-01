package com.aswini.DAO;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.aswini.modal.FoodMenu;
import com.aswini.modal.HotelTransaction;
import com.aswini.modal.OrderDetail;
import com.aswini.util.ConnectionUtil;

public class HotelTransactionDAO {
JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();
	
	public List<HotelTransaction> list() 
	{
		String sql = "select id,order_id,menu_id,quantity,order_time,order_date,status from hotel_transaction";
		List<HotelTransaction> list = jdbcTemplate.query(sql, (rs, rowNum) -> 
		{
			HotelTransaction hotelTransaction = new HotelTransaction();
			hotelTransaction.setId(rs.getInt("id"));

			OrderDetail orderDetail=new OrderDetail();
			orderDetail.setOrderId(rs.getInt("order_id"));
			hotelTransaction.setOrderId(orderDetail);
			
			FoodMenu foodMenu=new FoodMenu();
			foodMenu.setId(rs.getInt("menu_id"));
			hotelTransaction.setMenuId(foodMenu);
			
			hotelTransaction.setQuantity(rs.getInt("quantity"));
			hotelTransaction.setOrderTime(rs.getTime("order_time").toLocalTime());
			hotelTransaction.setOrderDate(rs.getDate("order_date").toLocalDate());
			hotelTransaction.setStatus(rs.getString("status"));

			return hotelTransaction;
		});
		
		return list;
	}
	
	public HotelTransaction listById(int id) 
	{
		HotelTransaction hotelTransaction = null;
			String sql = "select id,order_id,menu_id,quantity,order_time,order_date,status from hotel_transaction where id=?";
			Object[] params = { id };
			hotelTransaction = jdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> 
			{
				HotelTransaction hotelTransactions = new HotelTransaction();
				hotelTransactions.setId(rs.getInt("id"));

				OrderDetail orderInfo=new OrderDetail();
				orderInfo.setOrderId(rs.getInt("order_id"));
				hotelTransactions.setOrderId(orderInfo);
				
				FoodMenu foodMenu=new FoodMenu();
				foodMenu.setId(rs.getInt("menu_id"));
				hotelTransactions.setMenuId(foodMenu);
				
				hotelTransactions.setQuantity(rs.getInt("quantity"));
				hotelTransactions.setOrderTime(rs.getTime("order_time").toLocalTime());
				hotelTransactions.setOrderDate(rs.getDate("order_date").toLocalDate());
				
				hotelTransactions.setStatus(rs.getString("status"));

				return hotelTransactions;
			});
			return hotelTransaction;
	}

	public List<HotelTransaction> listByCurrentDay()
	{
		String sql = "select id,order_id,menu_id,quantity,order_time,order_date,status from hotel_transaction where order_date=curdate()";
		List<HotelTransaction> list = jdbcTemplate.query(sql, (rs, rowNum) -> 
		{
			HotelTransaction hotelTransaction = new HotelTransaction();
			hotelTransaction.setId(rs.getInt("id"));

			OrderDetail orderDetail=new OrderDetail();
			orderDetail.setOrderId(rs.getInt("order_id"));
			hotelTransaction.setOrderId(orderDetail);
			
			FoodMenu foodMenu=new FoodMenu();
			foodMenu.setId(rs.getInt("menu_id"));
			hotelTransaction.setMenuId(foodMenu);
			
			hotelTransaction.setQuantity(rs.getInt("quantity"));
			hotelTransaction.setOrderTime(rs.getTime("order_time").toLocalTime());
			hotelTransaction.setOrderDate(rs.getDate("order_date").toLocalDate());
			hotelTransaction.setStatus(rs.getString("status"));

			return hotelTransaction;
		});
		return list;
	}
}
