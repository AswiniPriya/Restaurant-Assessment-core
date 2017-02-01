package com.aswini.modal;

import java.time.LocalTime;

import lombok.Data;

@Data
public class FoodSchedule {
	private int id;
	private String scheduleType;
	private LocalTime availableFromTime;
	private LocalTime availableToTime;
}
