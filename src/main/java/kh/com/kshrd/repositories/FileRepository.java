package kh.com.kshrd.repositories;

import org.springframework.data.repository.CrudRepository;

import kh.com.kshrd.models.File;

public interface FileRepository extends CrudRepository<File, Long> {

}
