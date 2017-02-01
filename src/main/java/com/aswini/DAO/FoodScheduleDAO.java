package com.aswini.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.jdbc.core.JdbcTemplate;

import com.aswini.modal.FoodSchedule;
import com.aswini.util.ConnectionUtil;

public class FoodScheduleDAO {
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();
	Logger logger = Logger.getLogger(FoodScheduleDAO.class.getName());
	static final String MSG = "No. of rows changed ";

	public void save(FoodSchedule foodSchedule) {
		String sql = "insert into food_schedule(id,schedule_type,available_from_time,available_to_time) values(?,?,?,?)";
		Object[] params = { foodSchedule.getId(),foodSchedule.getScheduleType(), foodSchedule.getAvailableFromTime(), foodSchedule.getAvailableToTime() };
		int rows = jdbcTemplate.update(sql, params);
		logger.log(Level.INFO, MSG, rows);

	}

	public void updateName(FoodSchedule foodSchedule) {
		String sql = "update food_schedule set name=? where id=?";
		Object[] params = { foodSchedule.getScheduleType(), foodSchedule.getId() };
		int rows = jdbcTemplate.update(sql, params);
		logger.log(Level.INFO, MSG, rows);
	}

	public void updateFromTime(FoodSchedule foodSchedule) {
		String sql = "update food_schedule set from_time=? where id=?";
		Object[] params = { foodSchedule.getAvailableFromTime(), foodSchedule.getId() };
		int rows = jdbcTemplate.update(sql, params);
		logger.log(Level.INFO, MSG, rows);
	}

	public void updateToTime(FoodSchedule foodSchedule) {
		String sql = "update food_schedule set to_time=? where id=?";
		Object[] params = {foodSchedule.getAvailableToTime(), foodSchedule.getId() };
		int rows = jdbcTemplate.update(sql, params);
		logger.log(Level.INFO, MSG, rows);
	}

	public void delete(int id) {
		String sql = "delete from food_schedule where id=?";
		int rows = jdbcTemplate.update(sql, id);
		logger.log(Level.INFO, MSG, rows);
	}

	public List<FoodSchedule> list() {
		String sql = "select id,schedule_type,available_from_time,available_to_time from food_schedule";
		return jdbcTemplate.query(sql, (rs, rowNum) -> convert(rs));
	}

	public List<String> findScheduleNames() {
		String sql = "SELECT schedule_type FROM food_schedule";
		return jdbcTemplate.queryForList(sql, String.class);
	}

	public FoodSchedule listByName(String name) {
		String sql = "select id,schedule_type,available_from_time,available_to_time from food_schedule where schedule_type=?";
		Object[] params = { name };
		return jdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> convert(rs));

	}

	public FoodSchedule listById(int id) {
		String sql = "select id,schedule_type,available_from_time,available_to_time from food_schedule where id=?";
		Object[] params = { id };
		return jdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> convert(rs));
	}

	static FoodSchedule convert(final ResultSet rs) throws SQLException {
		FoodSchedule foodSchedule = new FoodSchedule();
		foodSchedule.setId(rs.getInt("id"));
		foodSchedule.setScheduleType(rs.getString("schedule_type"));
		foodSchedule.setAvailableFromTime(rs.getTime("available_from_time").toLocalTime());
		foodSchedule.setAvailableToTime(rs.getTime("available_to_time").toLocalTime());
		return foodSchedule;
	}
}
