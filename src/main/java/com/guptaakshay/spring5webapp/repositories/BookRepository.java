package com.guptaakshay.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.guptaakshay.spring5webapp.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

}
