package com.paras.mani.bookpublisher;

import com.paras.mani.bookpublisher.config.KafkaConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import({KafkaConfig.class})
@SpringBootApplication
public class GeneralBookStoreKafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(GeneralBookStoreKafkaApplication.class, args);
	}

}
