package com.aswini.modal;

import lombok.Data;

@Data
public class FoodStock {
	private int id;
	private FoodMenu itemId;
	private FoodSchedule scheduleId;
	private int quantity;
}
