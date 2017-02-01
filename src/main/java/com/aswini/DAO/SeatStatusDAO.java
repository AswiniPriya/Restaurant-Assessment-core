package com.aswini.DAO;

import java.sql.Time;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.aswini.modal.SeatStatus;
import com.aswini.modal.SeedHotelSeats;
import com.aswini.util.ConnectionUtil;

public class SeatStatusDAO {
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public void save(SeatStatus seatStatus) {

		String sql = "insert into seat_status(id,seat_id,seat_status,taken_time) values(?,?,?,?)";
		Object[] params = { seatStatus.getId(), seatStatus.getSeatId(), seatStatus.getSeatStatus(),
				seatStatus.getTakenTime() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows inserted: " + rows);

	}

	public void update(SeatStatus seatStatus) {

		String sql = "update seat_status set seat_status=? where seat_id=?";
		Object[] params = { seatStatus.getSeatStatus(), seatStatus.getSeatId() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows updated: " + rows);

	}

	public void delete(int id) {

		String sql = "delete from seat_status where seatid=?";
		int rows = jdbcTemplate.update(sql, id);
		System.out.println("No of rows deleted: " + rows);

	}

	public List<SeatStatus> list() {

		String sql = "select id,seat_id,seat_status,seat_state,taken_time from seat_status";
		List<SeatStatus> list = jdbcTemplate.query(sql, (rs, rowNum) -> {
			SeatStatus seatStatus = new SeatStatus();
			seatStatus.setId(rs.getInt("id"));

			SeedHotelSeats seedHotelSeats = new SeedHotelSeats();
			seedHotelSeats.setId(rs.getInt("seat_id"));
			seatStatus.setSeatId(seedHotelSeats);

			seatStatus.setSeatStatus(rs.getString("seat_status"));
			seatStatus.setSeatState(rs.getBoolean("seat_state"));

			// seatStatus.setSeatState(rs.getString("seat_state"));
			Time takenTime = rs.getTime("taken_time");
			seatStatus.setTakenTime(takenTime.toLocalTime());

			return seatStatus;

		});
		return list;
	}

}
