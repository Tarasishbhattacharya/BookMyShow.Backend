package com.major.BookMyShow.Controllers;

import com.major.BookMyShow.Dtos.ShowRequest;
import com.major.BookMyShow.Service.ShowService;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShowController {

    @Autowired
    ShowService showService;

    @PostMapping("/add_show")
    public String addShow(@RequestBody()ShowRequest showRequest){
        return showService.createShow(showRequest);
    }

}
