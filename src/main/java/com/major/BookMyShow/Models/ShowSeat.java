package com.major.BookMyShow.Models;

import com.major.BookMyShow.Enums.SeatType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="show_seat")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ShowSeat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String seatno;
    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;

    private boolean booked;

    @ManyToOne
    @JoinColumn
    private Show show;


    @ManyToOne
    @JoinColumn
    private Ticket ticket;


}
