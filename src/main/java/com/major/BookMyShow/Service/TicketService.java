package com.major.BookMyShow.Service;

import com.major.BookMyShow.Dtos.TicketRequest;
import com.major.BookMyShow.Enums.SeatType;
import com.major.BookMyShow.Models.Show;
import com.major.BookMyShow.Models.ShowSeat;
import com.major.BookMyShow.Models.Ticket;
import com.major.BookMyShow.Models.User;
import com.major.BookMyShow.Repository.ShowRepository;
import com.major.BookMyShow.Repository.TicketRepository;
import com.major.BookMyShow.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TicketService {

    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    ShowRepository showRepository;

    @Autowired
    UserRepository userRepository;
    public String createTicket(TicketRequest ticketRequest){
        User user=userRepository.findById(ticketRequest.getUserId()).get();
        Show show= showRepository.findById(ticketRequest.getShowId()).get();
        List<ShowSeat> showSeatList=show.getShowSeatList();
        List<String> requestedSeats=ticketRequest.getRequested_seats();
            //         If seats are availbale or not
        List<ShowSeat>bookedseat=new ArrayList<>();
        for(ShowSeat showSeat:showSeatList){
            String seatNo=showSeat.getSeatno();
            if(showSeat.isBooked()==false && requestedSeats.contains(seatNo)){
                bookedseat.add(showSeat);
            }
        }
        if(bookedseat.size()!=requestedSeats.size()){
            return "Ticket can not be generated as the seats are not available";
        }
        Ticket ticket=new Ticket();
        int total_Amount=0;
        for(ShowSeat bookseat: bookedseat){
            bookseat.setBooked(true);
            bookseat.setTicket(ticket);
            bookseat.setShow(show);
            if(bookseat.getSeatType()== SeatType.CLASSIC){
                total_Amount*=200;
            }else{
                total_Amount*=400;
            }
        }
        ticket.setShow(show);
        ticket.setUser(user);
        ticket.setBooked_at(new Date());
        ticket.setAmount(total_Amount);
        ticket.setShowSeatList(bookedseat);
        user.getTicketList().add(ticket);
        ticketRepository.save(ticket);

        return "Ticket generated";
    }
}
