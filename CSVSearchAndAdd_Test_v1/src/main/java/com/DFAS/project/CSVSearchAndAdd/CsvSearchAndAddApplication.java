package com.DFAS.project.CSVSearchAndAdd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CsvSearchAndAddApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext =SpringApplication.run(CsvSearchAndAddApplication.class, args);
		
		MainCSV_noOpenCSV service = applicationContext.getBean(MainCSV_noOpenCSV.class);
		service.App();
		return;
		
	}



}
