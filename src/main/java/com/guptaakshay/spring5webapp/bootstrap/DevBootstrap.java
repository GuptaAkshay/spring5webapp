package com.guptaakshay.spring5webapp.bootstrap;

import org.springframework.boot.ApplicationArguments;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.guptaakshay.spring5webapp.model.Author;
import com.guptaakshay.spring5webapp.model.Book;
import com.guptaakshay.spring5webapp.model.Publisher;
import com.guptaakshay.spring5webapp.repositories.AuthorRepository;
import com.guptaakshay.spring5webapp.repositories.BookRepository;
import com.guptaakshay.spring5webapp.repositories.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{

	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	private PublisherRepository publisherRepository;
	
	
	public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	private void initData() {
		Publisher pb1 = new Publisher("Harper Collins", "abc road");
		publisherRepository.save(pb1);
		
		Author eric = new Author("Eric", "Evans");
		Book ddd = new Book("Domain Driven Design", "1234", pb1);
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		
		authorRepository.save(eric);
		bookRepository.save(ddd);
		
		Publisher pb2 = new Publisher("Work", "1234 road");
		publisherRepository.save(pb2);
		
		Author rod = new Author("Red", "Johnson");
		Book noEjb = new Book("J2EE Development without EJB", "23444", pb2);
		rod.getBooks().add(noEjb);
		noEjb.getAuthors().add(rod);
		
		authorRepository.save(rod);
		bookRepository.save(noEjb);
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		// TODO Auto-generated method stub
		initData();
		
	}
}
