package com.bradygrapentinefirstspringapp.spring5WebApp.bootstrap;

import com.bradygrapentinefirstspringapp.spring5WebApp.models.Author;
import com.bradygrapentinefirstspringapp.spring5WebApp.models.Book;
import com.bradygrapentinefirstspringapp.spring5WebApp.models.Publisher;
import com.bradygrapentinefirstspringapp.spring5WebApp.repositories.AuthorRepository;
import com.bradygrapentinefirstspringapp.spring5WebApp.repositories.BookRepository;
import com.bradygrapentinefirstspringapp.spring5WebApp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");
        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "654321");
        Publisher udemy = new Publisher("Udemy", "123 Fake Street", "Faketown", "FS", "12345");

        publisherRepository.save(udemy);

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        ddd.setPublisher(udemy);
        udemy.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(udemy);

        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        noEJB.setPublisher(udemy);
        udemy.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(udemy);

        System.out.println("Book Count: " + bookRepository.count());

        System.out.println("Author Count: " + authorRepository.count());

        System.out.println("Publisher Count: " + publisherRepository.count());

        System.out.println("Publisher Book Count: " + udemy.getBooks().size());
    }
}
