package com.major.BookMyShow.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Theatre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String city;
    private String address;

    @OneToMany(mappedBy="theatre",cascade=CascadeType.ALL)
    List<TheatreSeat>theatreSeatList;

    @OneToMany(mappedBy="theatre",cascade=CascadeType.ALL)
    List<Show>showList;


}
