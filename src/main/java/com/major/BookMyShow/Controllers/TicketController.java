package com.major.BookMyShow.Controllers;

import com.major.BookMyShow.Dtos.TicketRequest;
import com.major.BookMyShow.Service.TicketService;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Table(name="ticket_table")
@Data
@NoArgsConstructor
public class TicketController {

    @Autowired
    TicketService ticketService;

    @PostMapping("/add_ticket")
    public String addTicket(@RequestBody()TicketRequest ticketRequest){

        return ticketService.createTicket(ticketRequest);
    }
}
