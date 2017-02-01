package com.aswini.DAO;

import java.sql.Types;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import com.aswini.util.ConnectionUtil;

public class ProcedureDAO {
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public String orderFood(int seatNo, String item, int quantity) {

		SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplate);
		call.withProcedureName("pr_order_food");
		call.declareParameters(new SqlParameter("i_seat_no", Types.INTEGER), new SqlParameter("i_item", Types.VARCHAR),
				new SqlParameter("i_quantity", Types.INTEGER), new SqlOutParameter("o_order_message", Types.VARCHAR));
		call.setAccessCallParameterMetaData(false);

		MapSqlParameterSource in = new MapSqlParameterSource();
		in.addValue("i_seat_no", seatNo);
		in.addValue("i_item", item);
		in.addValue("i_quantity", quantity);

		Map<String, Object> execute = call.execute(in);

		String status = (String) execute.get("o_order_message");
		return status;

	}

	public String cancelOrder(int seatNo, String item, String message) {

		SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplate);
		call.withProcedureName("pr_cancel_order");
		call.declareParameters(new SqlParameter("i_seat_no", Types.INTEGER), new SqlParameter("i_item", Types.VARCHAR),
				new SqlOutParameter("o_cancel_message", Types.VARCHAR));
		call.setAccessCallParameterMetaData(false);

		MapSqlParameterSource in = new MapSqlParameterSource();
		in.addValue("i_seat_no", seatNo);
		in.addValue("i_item", item);
		in.addValue("o_cancel_message", message);

		Map<String, Object> execute = call.execute(in);

		String status = (String) execute.get("o_cancel_message");
		return status;

	}

	public String addItem(int id, String item, String scheduleType, String message) {

		SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplate);
		call.withProcedureName("pr_add_item");
		call.declareParameters(new SqlParameter("i_id", Types.INTEGER), new SqlParameter("i_item", Types.VARCHAR),
				new SqlParameter("i_schedule_type", Types.VARCHAR),
				new SqlOutParameter("o_item_message", Types.VARCHAR));
		call.setAccessCallParameterMetaData(false);

		MapSqlParameterSource in = new MapSqlParameterSource().addValue("i_id", id).addValue("i_item", item)
				.addValue("i_schedule_type", scheduleType).addValue("o_item_message", message);

		Map<String, Object> execute = call.execute(in);

		String status = (String) execute.get("o_item_message");
		return status;

	}

}
