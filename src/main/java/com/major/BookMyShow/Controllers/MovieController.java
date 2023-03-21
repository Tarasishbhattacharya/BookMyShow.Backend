package com.major.BookMyShow.Controllers;

import com.major.BookMyShow.Dtos.MovieRequest;
import com.major.BookMyShow.Models.Movie;
import com.major.BookMyShow.Models.Show;
import com.major.BookMyShow.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {

    @Autowired
    MovieService movieService;
    @PostMapping("/add_movie")
    public String addMovie(@RequestBody()MovieRequest movieRequest){
        return movieService.createMovie(movieRequest);
    }

    @GetMapping("/get_movie_by_id")
    public Movie getMovieById(@RequestParam("id") int id){
        return movieService.getMovie(id);
    }
    @GetMapping("/all_show_by_id")
    public List<Show> getAllShow(@RequestParam("id") int movieId,@RequestParam("id") int theatreId){
        return movieService.getShows(movieId,theatreId);
    }

}
