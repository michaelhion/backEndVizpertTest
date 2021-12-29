package br.com.bookApi.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bookApi.Models.BookModel;

public interface BookRepository extends JpaRepository<BookModel, Integer>{

}
