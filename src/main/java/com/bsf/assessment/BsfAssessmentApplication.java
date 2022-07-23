package com.bsf.assessment;

import com.bsf.assessment.init.DBDataInitializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
public class BsfAssessmentApplication implements CommandLineRunner {

	@Autowired
	private DBDataInitializer dbDataInitializer;

	public static void main(String[] args) {
		SpringApplication.run(BsfAssessmentApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		dbDataInitializer.initAccounts();
	}
}
