package br.com.bookApi.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bookApi.Repositories.BookRepository;
import br.com.bookApi.Models.BookModel;

@RestController
@RequestMapping("/bookApi")
public class BookController {
	@Autowired
	BookRepository bookRepository;
	@GetMapping("/listar")
	public ResponseEntity<List<BookModel>> getAll(){
		List<BookModel> bookModel = bookRepository.findAll();
		if (bookModel.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<List<BookModel>>(bookModel,HttpStatus.OK);
		}
	}
	
	@GetMapping("/listarPorId/{id}")
	public ResponseEntity<BookModel> getOne(@PathVariable(value = "id") Integer id){
		Optional<BookModel> bookModel = bookRepository.findById(id);
		if (!bookModel.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<BookModel>(bookModel.get(),HttpStatus.OK);
		}
	}
	
	@PostMapping("/adicionar")
	public ResponseEntity<BookModel> saveEstoque(@RequestBody BookModel bookModel){
		return new ResponseEntity<BookModel>(bookRepository.save(bookModel),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/book/{id}")
	public ResponseEntity<?> deleteEstoque(@PathVariable(value = "id") Integer id){
		Optional<BookModel> bookModel = bookRepository.findById(id);
		if (!bookModel.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			bookRepository.delete(bookModel.get());
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	
	@PutMapping("/book/{id}")
	public ResponseEntity<BookModel> updateEstoque(@PathVariable(value = "id") Integer id,@RequestBody BookModel bookModel){
		Optional<BookModel> book = bookRepository.findById(id);
		if (!book.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			bookModel.setId(book.get().getId());
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
}
