package org.lessons.bestoftheyear.model;

public class Song extends Content {

  private String artist;

  public Song(int id, String title, String description, String artist) {
    super(id, title, description);
    this.artist = artist;
  }

  @Override
  public String toString() {
    return "Song{" +
        super.toString() + '\'' +
        "artist='" + artist + '\'' +
        "} " + super.toString();
  }
}
