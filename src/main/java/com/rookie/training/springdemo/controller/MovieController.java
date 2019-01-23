package com.rookie.training.springdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rookie.training.springdemo.entity.Movie;
import com.rookie.training.springdemo.service.MovieService;

//@Controller
@Controller
@RequestMapping("/movies/old")
public class MovieController {
	
	@Autowired
	public MovieService movieService;
	
	@RequestMapping("/get")
//	@ResponseBody
	public Movie getMovie() {
		return movieService.getNewMovie();
	}
	
	@RequestMapping("/moviesPage")
	public String getMoviePage(Model model) {
		model.addAttribute("movies", movieService.getAllMovie());
		return "movie";
	}
	
	@PostMapping("/create")
//	@RequestMapping(value="/create", method = RequestMethod.POST)
	public String createMovie(Model model, @RequestParam String name, @RequestParam int year) {
		movieService.addMovie(new Movie(name, year));
		model.addAttribute("movies", movieService.getAllMovie());
		return "movie";
	}
	
	@GetMapping("/edit")
	public String editMovie(Model model, @RequestParam("id") Long moveId) {
		model.addAttribute("movie", movieService.findMovie(moveId));
		return "movie"; 
	}
	
	@PostMapping("/save")
	public String saveMovie(Model model,  @RequestParam String name, @RequestParam int year, @RequestParam Long id) {

		movieService.saveMovie(name, year, id);
		model.addAttribute("movies", movieService.getAllMovie());
		return "movie"; //Chama o html
	}
	
	@GetMapping("/delete")
	public String deleteMovie(Model model, @RequestParam Long id) {
		movieService.deleteMovie(id);
		model.addAttribute("movies", movieService.getAllMovie());
		return "movie";
	}
}
