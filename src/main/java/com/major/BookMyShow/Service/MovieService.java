package com.major.BookMyShow.Service;

import com.major.BookMyShow.Dtos.MovieRequest;
import com.major.BookMyShow.Models.Movie;
import com.major.BookMyShow.Models.Show;
import com.major.BookMyShow.Models.Theatre;
import com.major.BookMyShow.Repository.MovieRepository;
import com.major.BookMyShow.Repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;
    @Autowired
    TheatreRepository theatreRepository;
    public String createMovie(MovieRequest movieRequest){
        Movie movie=Movie.builder().name(movieRequest.getName()).duration(movieRequest.getDuration()).build();
        movieRepository.save(movie);
        return "movie added succesfully";
    }
    public Movie getMovie(int id){
        Movie movie=movieRepository.findById(id).get();
        return movie;
    }
    public List<Show> getShows(int movieId,int theatreId){
        Movie movie=movieRepository.findById(movieId).get();
        Theatre theatre=theatreRepository.findById(theatreId).get();
        List<Show> showList=theatre.getShowList();
        List<Show>movieshowList=new ArrayList<>();
        for(Show show :showList){
            if(show.getMovie()==movie){
                  movieshowList.add(show);
            }
        }
        return movieshowList;
    }
}
