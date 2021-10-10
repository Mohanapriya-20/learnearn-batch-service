package com.learnearn;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.learnearn.model.Batch;
import com.learnearn.model.PostPriority;
import com.learnearn.model.PostStatus;
import com.learnearn.service.IBatchService;

@SpringBootApplication
public class LearnearnBatchRestapiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LearnearnBatchRestapiApplication.class, args);
	}

	@Autowired
	IBatchService batchService;

	@Override
	public void run(String... args) throws Exception {
		 Batch batch= new Batch("Iconics", "Tom", LocalDateTime.parse("2021-10-07T15:22:56"),LocalDateTime.parse("2022-11-20T15:22:56"),PostStatus.ONHOLD, PostPriority.HIGH);
		 //batchService.addBatch(batch);
		 //System.out.println("Value Added");
	}

}
