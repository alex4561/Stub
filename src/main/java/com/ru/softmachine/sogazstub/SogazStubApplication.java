package com.ru.softmachine.sogazstub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@SpringBootApplication
public class SogazStubApplication {

	public static void main(String[] args) {
		SpringApplication.run(SogazStubApplication.class, args);

	}

}
