package org.lessons.bestoftheyear.controller;

import java.util.ArrayList;
import java.util.List;
import org.lessons.bestoftheyear.model.Movie;
import org.lessons.bestoftheyear.model.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {

  @GetMapping
  public String home(Model model) {
    model.addAttribute("username", "Costanza");
    return "home";
  }

}
