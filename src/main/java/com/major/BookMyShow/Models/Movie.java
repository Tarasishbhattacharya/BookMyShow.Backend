package com.major.BookMyShow.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "movie")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int movieId;
    private String name;
    private int duration;

    @OneToMany(mappedBy = "movie",cascade = CascadeType.ALL)
    private List<Show> showList;



}
