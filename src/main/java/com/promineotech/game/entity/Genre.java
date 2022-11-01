package com.promineotech.game.entity;

import java.util.Comparator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Genre implements Comparable<Genre>{
  private Long genreId;
  private String genreName;
  
  
@JsonIgnore  
  public Long getGenreId() {
    return genreId;
  }


@Override
public int compareTo(Genre that) {
  // @formatter:off
  return Comparator
      .comparing(Genre::getGenreId)
      .thenComparing(Genre::getGenreName)
      .compare(this, that);
  // @formatter:on
};

}
