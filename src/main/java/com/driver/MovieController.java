package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {
    @Autowired
    MovieService movieService;

    @PostMapping("/movies/add-movie")
    public ResponseEntity addMovie(@RequestBody Movie movie) {
        String response = movieService.addMovie(movie);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("movies/add-director")
    public ResponseEntity addDirector(@RequestBody Director director) {
        String response = movieService.addDirector(director);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/movies/add-movie-director-pair")
    public ResponseEntity addMovieDirectorPair(@RequestParam("movie") String movie, @RequestParam("director") String director) {
        String response=movieService.addMovieDirectorPair(movie,director);
        return new ResponseEntity<>(response,HttpStatus.ACCEPTED);

    }
    @GetMapping("movies/get-movie-by-name/{name}")
    public ResponseEntity getMovieByName(@PathVariable("name")String name)
    {
        Movie response=movieService.getMovieByName(name);
        return new ResponseEntity<>(response,HttpStatus.FOUND);
    }
    @GetMapping("/movies/get-director-by-name/{name}")
    public ResponseEntity getDirectorByName(@PathVariable("name")String name)
    {
        Director response=movieService.getDirectorByName(name);
        return new ResponseEntity<>(response,HttpStatus.FOUND);
    }
    @GetMapping("/movies/get-movies-by-director-name/{director}")
    public ResponseEntity getMovieByDirectorName(@PathVariable("director")String director)
    {
        List<String>response=movieService.getMovieByDirectorName(director);
        return new ResponseEntity<>(response,HttpStatus.FOUND);
    }
    @GetMapping("movies/get-all-movies")
    public ResponseEntity findAllMovies()
    {
        List<String>response=movieService.findAllMovies();
        return new ResponseEntity(response,HttpStatus.FOUND);

    }
    @DeleteMapping("/movies/delete-director-by-name")
    public ResponseEntity deleteDirectorByName(@RequestParam("director")String director)
    {
        String response=movieService.deleteDirectorByName(director);
        return new ResponseEntity(response,HttpStatus.ACCEPTED);

    }
    @DeleteMapping("/movies/delete-all-directors")

    public ResponseEntity deleteAllDirectors()
    {
        String response=movieService.deleteAllDirectors();
        return new ResponseEntity(response,HttpStatus.ACCEPTED);
    }



}
