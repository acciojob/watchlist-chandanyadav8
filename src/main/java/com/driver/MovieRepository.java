package com.driver;

import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class MovieRepository {
    HashMap<String,Movie>movieList=new HashMap<>();
    HashMap<String,Director>directorList=new HashMap<>();
    HashMap<String,String>movieAndDirector=new HashMap<>();
    public String addMovie(Movie movie)
    {
        movieList.put(movie.getName(),movie);
        return "Movie added successfully";
    }
    public String addDirector(Director director)
    {
        directorList.put(director.getName(),director);
        return "Director added successfully";
    }
    public String addMovieDirectorPair(String  movie,String director)
    {
        if(movieList.containsKey(movie)&&directorList.containsKey(director))
        {
            movieAndDirector.put(movie,director);
            return "movie and director is paired";
        }
        return "Not found";
    }
    public Movie getMovieByName(String name)
        {
            if(!movieList.containsKey(name))
                return null;
            return movieList.get(name);
        }
    public Director getDirectorByName(String name)
    {
        if(!directorList.containsKey(name))
            return null;
        return directorList.get(name);
    }
    public List<String> getMoviesByDirectorName(String name)
    {
        List<String>movieName=new ArrayList<>();
        if(!directorList.containsKey(name)) return movieName;
        for(String i : movieAndDirector.keySet()){
            if(movieAndDirector.get(i).equals(name)) movieName.add(i);
        }
        return movieName;

    }
    public List<String> findAllMovies()
    {
        List<String>allmovie=new ArrayList<>();
        for(String i : movieList.keySet()){
            allmovie.add(i);
    }
        return allmovie;
    }
    public String deleteDirectorByName(String name)
    {
        if(directorList.containsKey(name)){
            directorList.remove(name);
            return "Deleted succesfully";
        }

            return "Failure";
           }


        public String deleteAllDirectors() {
        for (String i : movieAndDirector.keySet()) {
            movieList.remove(i);
        }
        movieAndDirector.clear();
        directorList.clear();
        return "Success";
    }
    }
