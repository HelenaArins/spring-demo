package com.rookie.training.springdemo.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.rookie.training.springdemo.entity.Movie;
import com.rookie.training.springdemo.exception.InvalidMovieException;

@Service
public class MovieService {
	private List<Movie> movies;
	
	@PostConstruct
	private void init() {
		movies = new ArrayList<Movie>();
		
		movies.add(new Movie("Jumanji", 1995));
		movies.add(new Movie("Captain Marvel", 2019));
	}
	
	public List<Movie> getAllMovie(){
		return movies;
	}
	
	public Movie getNewMovie() {
		return new Movie("Matrix", 1999);
	}

	public void addMovie(Movie movie) {
		movies.add(movie);
	}
	
	public Movie findMovie(Long id) {
		for(Movie movie: movies) {
			if(movie.getId().equals(id)) {
				return movie;
			}
		}
		throw new InvalidMovieException();
	}

	public Movie saveMovie(String name, int year, Long id) {
		Movie m = findMovie(id);
		m.setName(name);
		m.setYear(year);	
		
		return m;
	}

	public void deleteMovie(Long id) {
		movies.remove(findMovie(id));
	}
}
