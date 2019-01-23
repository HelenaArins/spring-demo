package com.rookie.training.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rookie.training.springdemo.entity.Movie;
import com.rookie.training.springdemo.exception.InvalidMovieException;
import com.rookie.training.springdemo.service.MovieService;

@RestController
@RequestMapping("/movies")
public class MovieRestController {
	
	@Autowired
	private MovieService movieService;
	
	@GetMapping
	public List<Movie> getAll(){
		return movieService.getAllMovie();
	}
	
	@GetMapping("/{id}")
	public Movie get(@PathVariable Long id) {
		return movieService.findMovie(id);
	}
	
	@PostMapping
	public void create(@RequestBody Movie movie) {
		movieService.addMovie(movie);
	}
	
//	@PutMapping("/{id}")
//	public ResponseEntity<?> update(@RequestBody Movie movie, @PathVariable("id") Long movieId) {
//		try {
//			if(movieId == null || !movieId.equals(movie.getId()))
//				throw new IllegalArgumentException("Ops..");
//			return new ResponseEntity<Movie>(movieService.saveMovie(movie.getName(), movie.getYear(), movie.getId()), HttpStatus.OK);
//		} 
//		catch (IllegalArgumentException e) {
//			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
//		}		
//	}
	
	@PutMapping("/{id}")
	public Movie update(@RequestBody Movie movie, @PathVariable("id") Long movieId) {
			if(movieId == null || !movieId.equals(movie.getId()))
				throw new InvalidMovieException();
			return movieService.saveMovie(movie.getName(), movie.getYear(), movie.getId());
	
	}
	
	@DeleteMapping("/{id}")
	public void remove(@PathVariable Long id, @RequestMapping String info) {
		System.out.println(info);
		movieService.deleteMovie(id);
	}
	
}
