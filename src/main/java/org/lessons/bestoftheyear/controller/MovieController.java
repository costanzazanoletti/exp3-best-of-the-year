package org.lessons.bestoftheyear.controller;

import java.util.ArrayList;
import java.util.List;
import org.lessons.bestoftheyear.model.Movie;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/movies")
public class MovieController {

  @GetMapping
  public String movies(Model model) {
    List<Movie> movies = getBestMovies();
   /* String movieTitles = "";
    for (Movie m : movies) {
      movieTitles += m.getTitle() + ", ";
    }
    movieTitles = movieTitles.substring(0, movieTitles.length() - 2);*/
    model.addAttribute("list", movies);
    return "movies";
  }

  @GetMapping("/{id}")
  public String movieDetail(@PathVariable(name = "id") int movieId, Model model) {
    for (Movie m : getBestMovies()) {
      if (m.getId() == movieId) {
        // questo è il movie richiesto
        model.addAttribute("movie", m);
      }
    }
    return "movie-detail";
  }


  private List<Movie> getBestMovies() {
    List<Movie> movies = new ArrayList<>();
    movies.add(new Movie(1, "Movie 1", "Descripion 1", "Director 1"));
    movies.add(new Movie(2, "Movie 2", "Descripion 2", "Director 2"));
    movies.add(new Movie(3, "Movie 3", "Descripion 3", "Director 3"));
    return movies;
  }
}