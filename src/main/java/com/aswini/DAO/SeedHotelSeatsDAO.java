package com.aswini.DAO;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.aswini.modal.SeedHotelSeats;
import com.aswini.util.ConnectionUtil;

public class SeedHotelSeatsDAO {
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public void save(SeedHotelSeats seedHotelSeats) {

		String sql = "insert into seed_hotel_seats(id,seat_name) values(?,?)";
		Object[] params = { seedHotelSeats.getId(), seedHotelSeats.getSeatName() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows inserted: " + rows);

	}

	public void update(SeedHotelSeats seedHotelSeats) {

		String sql = "update seed_hotel_seats set seat_name=? where id=?";
		Object[] params = { seedHotelSeats.getSeatName(), seedHotelSeats.getId() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows updated: " + rows);

	}

	public void delete(int id) {

		String sql = "delete from seed_hotel_seats where id=?";
		int rows = jdbcTemplate.update(sql, id);
		System.out.println("No of rows deleted: " + rows);

	}

	public List<SeedHotelSeats> list() {

		String sql = "select id,seat_name from seed_hotel_seats";
		List<SeedHotelSeats> list = jdbcTemplate.query(sql, (rs, rowNum) -> {
			SeedHotelSeats seedHotelSeats = new SeedHotelSeats();
			seedHotelSeats.setId(rs.getInt("id"));
			seedHotelSeats.setSeatName(rs.getString("seat_name"));
			return seedHotelSeats;

		});
		return list;
	}

}
