package com.showapp.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.showapp.model.Movie;

//this is the client for movie service
//pass the name of the service you want to call
@FeignClient(name = "movie-catalog", url = "${movie-catalog.service.url}")
public interface IMovieFeignClient {

    @GetMapping("/movies-service/v1/movies/movieId")
    Movie getByMovieId(@RequestParam int movieId);
}
