package com.paras.mani.bookpublisher.service;

import com.paras.mani.bookpublisher.kafka.BookProducer;
import com.paras.mani.bookpublisher.model.MyBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    BookProducer bookProducer;

    public boolean addBook(MyBook myBook){
        if(bookProducer.produceMessage(myBook)){
            System.out.println("My Book added to file");
            return  true;
        }else{
            return false;
        }

    }
}
