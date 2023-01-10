package com.chindin.photos.clone.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@RequiredArgsConstructor
@Table("PHOTOS")
public class Photo {

  @Id
  private Long id;

  @NotEmpty
  private String fileName;

  private String contentType;

  @JsonIgnore
  private byte[] data;

}
