package com.chindin.photos.clone.service;

import com.chindin.photos.clone.model.Photo;
import com.chindin.photos.clone.repository.PhotosRepository;
import java.util.Collection;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class PhotosService {

  private final PhotosRepository repository;

  public PhotosService(PhotosRepository repository) {
    this.repository = repository;
  }

  public Iterable<Photo> getAll() {
    return repository.findAll();
  }

  public Photo getById(Long id) {
    return repository.findById(id).orElse(null);
  }

  public Photo save(String fileName, String contentType, byte[] data) {
    Photo photo = new Photo();
    photo.setFileName(fileName);
    photo.setData(data);
    photo.setContentType(contentType);
    repository.save(photo);
    return photo;
  }

  public void remove(Long id) {
    repository.deleteById(id);
  }
}
