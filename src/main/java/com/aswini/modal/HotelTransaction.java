package com.aswini.modal;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.Data;

 @Data
public class HotelTransaction {
	private int id;
	private OrderDetail orderId;
	private FoodMenu menuId;
	private int quantity;
	private LocalTime orderTime;
	private LocalDate orderDate;
	private String status;

}
