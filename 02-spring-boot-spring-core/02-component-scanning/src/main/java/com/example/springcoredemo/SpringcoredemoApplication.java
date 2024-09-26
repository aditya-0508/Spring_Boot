package com.example.springcoredemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*
//for explicilty list base packages,this when the files are present in the util ouside springcoredemo
@SpringBootApplication(
	scanBasePackages={"com.example.springcoredemo",
		"com.example.util"}
)*/
@SpringBootApplication
public class SpringcoredemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcoredemoApplication.class, args);
	}

}
