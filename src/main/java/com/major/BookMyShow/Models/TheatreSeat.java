package com.major.BookMyShow.Models;

import com.major.BookMyShow.Enums.SeatType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "theatre_seat")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TheatreSeat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String seat_no;
    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;
    private int base_price;

    @ManyToOne
    @JoinColumn
    private Theatre theatre;

    public TheatreSeat(String seat_no, SeatType seatType, int base_price) {
        this.seat_no = seat_no;
        this.seatType = seatType;
        this.base_price = base_price;
    }
}
