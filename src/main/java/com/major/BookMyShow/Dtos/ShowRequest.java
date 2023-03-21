package com.major.BookMyShow.Dtos;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class ShowRequest {
    private LocalDate show_date;
    private LocalTime show_time;

    private int movieId;
    private int theatreId;
}
