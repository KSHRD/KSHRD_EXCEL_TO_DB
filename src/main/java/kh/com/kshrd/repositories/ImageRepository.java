package kh.com.kshrd.repositories;

import org.springframework.data.repository.CrudRepository;

import kh.com.kshrd.models.Image;

public interface ImageRepository extends CrudRepository<Image, Long> {

}
