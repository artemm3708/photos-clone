package com.chindin.photos.clone.repository;

import com.chindin.photos.clone.model.Photo;
import org.springframework.data.repository.CrudRepository;

public interface PhotosRepository extends CrudRepository<Photo, Long> {

}
