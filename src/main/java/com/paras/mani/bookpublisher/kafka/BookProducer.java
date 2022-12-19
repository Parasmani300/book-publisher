package com.paras.mani.bookpublisher.kafka;

import com.paras.mani.bookpublisher.model.MyBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class BookProducer {
    String topic = "BOOK-STORE-SAMPLE";

    @Autowired
    KafkaTemplate<String,Object> kafkaTemplate;

    public boolean produceMessage(MyBook myBook){
        try {
            kafkaTemplate.send(topic, String.valueOf(myBook.getUuid()), myBook);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
