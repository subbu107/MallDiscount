package com.sg.mall;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;

@SpringBootApplication
public class MallDiscountApplication implements CommandLineRunner {

	private static final Log log = LogFactory.getLog(MallDiscountApplication.class);

	@Autowired
	private InputProcessor inputProcessor;
	
	
	
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(MallDiscountApplication.class);
		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);

	}

	@Override
	public void run(String... args) throws Exception {
				
		try {
			inputProcessor.processInputs( args[0]);
		} catch (Exception e) {
			System.out.println("An error occurred while reading the input file.");
			log.error("Error : ", e);
		}

	}

}
