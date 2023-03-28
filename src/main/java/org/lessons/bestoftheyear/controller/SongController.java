package org.lessons.bestoftheyear.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.lessons.bestoftheyear.model.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/songs")
public class SongController {

  @GetMapping
  public String songs(Model model) {
    String songTitles = getBestSongs().stream().map((s) -> s.getTitle())
        .collect(Collectors.joining(", "));
    model.addAttribute("list", songTitles);
    return "songs";
  }

  @GetMapping("/{id}")
  public String songDetail(@PathVariable int id, Model model) {
    for (Song s : getBestSongs()) {
      if (s.getId() == id) {
        model.addAttribute("song", s);
      }
    }
    return "song-detail";
  }


  private List<Song> getBestSongs() {
    List<Song> songs = new ArrayList<>();
    songs.add(new Song(1, "Song 1", "Descripion 1", "Artist 1"));
    songs.add(new Song(2, "Song 2", "Descripion 2", "Artist 2"));
    return songs;
  }
}
