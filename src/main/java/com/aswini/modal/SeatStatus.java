package com.aswini.modal;

import java.time.LocalTime;

import lombok.Data;

@Data
public class SeatStatus {
private int id;
private SeedHotelSeats seatId;
private String seatStatus;
private boolean seatState;
private LocalTime takenTime;
}
