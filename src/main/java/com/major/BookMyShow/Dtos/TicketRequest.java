package com.major.BookMyShow.Dtos;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class TicketRequest {

    private List<String> requested_seats;
     private int userId;
     private int showId;
}
