package com.chindin.photos.clone.api;

import com.chindin.photos.clone.model.Photo;
import com.chindin.photos.clone.service.PhotosService;
import java.io.IOException;
import java.util.Collection;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class PhotosController {

  private final PhotosService service;

  public PhotosController(PhotosService service) {
    this.service = service;
  }

  @GetMapping("/photos")
  public Iterable<Photo> get() {
    return service.getAll();
  }

  @GetMapping("/photos/{id}")
  public Photo getById(@PathVariable Long id) {
    Photo photo = service.getById(id);
    if (photo == null) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
    return photo;
  }

  @PostMapping("/photos")
  public Photo create(@RequestPart("data") MultipartFile file) throws IOException {
    return service.save(file.getOriginalFilename(), file.getContentType(), file.getBytes());
  }

  @DeleteMapping("/photos/{id}")
  public void delete(@PathVariable Long id) {
    service.remove(id);
  }

}
