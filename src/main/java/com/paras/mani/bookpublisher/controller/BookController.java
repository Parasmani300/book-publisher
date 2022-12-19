package com.paras.mani.bookpublisher.controller;

import com.paras.mani.bookpublisher.model.MyBook;
import com.paras.mani.bookpublisher.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/book")
@CrossOrigin
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/get")
    public String getBook()
    {
        return "Hello World";
    }

    @PostMapping("/postBook")
    public ResponseEntity<MyBook> postBook(@RequestBody MyBook myBook)
    {
        if(bookService.addBook(myBook)){
            return new ResponseEntity<>(myBook,HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(myBook,HttpStatus.EXPECTATION_FAILED);
        }
    }
}
