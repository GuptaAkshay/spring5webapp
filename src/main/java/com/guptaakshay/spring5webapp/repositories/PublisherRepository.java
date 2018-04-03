package com.guptaakshay.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.guptaakshay.spring5webapp.model.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long>{

}
