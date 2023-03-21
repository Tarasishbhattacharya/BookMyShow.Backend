package com.major.BookMyShow.Service;

import com.major.BookMyShow.Dtos.ShowRequest;
import com.major.BookMyShow.Models.*;
import com.major.BookMyShow.Repository.MovieRepository;
import com.major.BookMyShow.Repository.ShowRepository;
import com.major.BookMyShow.Repository.ShowSeatRepository;
import com.major.BookMyShow.Repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShowService {
    @Autowired
    ShowRepository showRepository;
    @Autowired
    MovieRepository movieRepository;
    @Autowired
    TheatreRepository theatreRepository;
    @Autowired
    ShowSeatRepository showSeatRepository;

    public String createShow(ShowRequest showRequest){
        Show show= Show.builder().show_time(showRequest.getShow_time()).show_date(showRequest.getShow_date()).build();
        Movie movie=movieRepository.findById(showRequest.getMovieId()).get();
        Theatre theatre=theatreRepository.findById(showRequest.getTheatreId()).get();
        show.setMovie(movie);
        show.setTheatre(theatre);
        movie.getShowList().add(show);
        theatre.getShowList().add(show);
        List<ShowSeat>showSeats=createShowSeat(theatre.getTheatreSeatList());
        show.setShowSeatList(showSeats);
        for(ShowSeat showSeat:showSeats){
            showSeat.setShow(show);
        }
        movieRepository.save(movie);
        return "show added successFully";
    }
    public List<ShowSeat> createShowSeat(List<TheatreSeat> theatreSeatList){
        List<ShowSeat> seats=new ArrayList<>();
        for(TheatreSeat theatreSeat:theatreSeatList){
            ShowSeat showSeat=ShowSeat.builder().seatno(theatreSeat.getSeat_no()).seatType(theatreSeat.getSeatType()).build();
            seats.add(showSeat);
        }
        showSeatRepository.saveAll(seats);
        return seats;
    }
}
