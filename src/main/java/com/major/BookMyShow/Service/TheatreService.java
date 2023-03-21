package com.major.BookMyShow.Service;

import com.major.BookMyShow.Dtos.TheatreRequest;
import com.major.BookMyShow.Enums.SeatType;
import com.major.BookMyShow.Models.Theatre;
import com.major.BookMyShow.Models.TheatreSeat;
import com.major.BookMyShow.Repository.TheatreRepository;
import com.major.BookMyShow.Repository.TheatreSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheatreService {
    @Autowired
    TheatreRepository theatreRepository;

    @Autowired
    TheatreSeatRepository theatreSeatRepository;
    public String createTheatre(TheatreRequest theatreRequest){
        Theatre theatre=Theatre.builder().name(theatreRequest.getName()).city(theatreRequest.getCity()).
                address(theatreRequest.getAddress()).build();

        List<TheatreSeat>theatreSeatList=createTheatreSeat();
        theatre.setTheatreSeatList(theatreSeatList);

        for(TheatreSeat theatreSeat:theatreSeatList){
            theatreSeat.setTheatre(theatre);
        }

        theatreRepository.save(theatre);
        return "Theatre added succesfully";
        
    }
    public List<TheatreSeat> createTheatreSeat(){
        List<TheatreSeat> seats=new ArrayList<>();
        TheatreSeat theatreSeat1=new TheatreSeat("1A",SeatType.CLASSIC,200);
        TheatreSeat theatreSeat2=new TheatreSeat("1B",SeatType.CLASSIC,200);
        TheatreSeat theatreSeat3=new TheatreSeat("1V",SeatType.PLATINUM,450);
        TheatreSeat theatreSeat4=new TheatreSeat("2A",SeatType.PLATINUM,450);
        TheatreSeat theatreSeat5=new TheatreSeat("1C",SeatType.PLATINUM,450);
        seats.add(theatreSeat1);
        seats.add(theatreSeat2);
        seats.add(theatreSeat3);
        seats.add(theatreSeat4);
        seats.add(theatreSeat5);

        theatreSeatRepository.saveAll(seats);
        return seats;
    }
}
