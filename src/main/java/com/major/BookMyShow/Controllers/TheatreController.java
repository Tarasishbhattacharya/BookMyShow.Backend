package com.major.BookMyShow.Controllers;

import com.major.BookMyShow.Dtos.TheatreRequest;
import com.major.BookMyShow.Service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TheatreController {
    @Autowired
    TheatreService theatreService;
    @PostMapping("/add_theatre")
    public String addTheatre(@RequestBody()TheatreRequest theatreRequest){
        return theatreService.createTheatre(theatreRequest);
    }
}
