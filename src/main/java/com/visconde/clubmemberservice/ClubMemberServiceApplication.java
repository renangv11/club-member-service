package com.visconde.clubmemberservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ClubMemberServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClubMemberServiceApplication.class, args);
	}

}
