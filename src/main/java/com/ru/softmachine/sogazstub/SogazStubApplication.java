package com.ru.softmachine.sogazstub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


@SpringBootApplication
public class SogazStubApplication {

	public static void main(String[] args) {
		SpringApplication.run(SogazStubApplication.class, args);
	}

	private static String readUsingFiles(String Response) throws IOException {
		return new String(Files.readAllBytes(Paths.get(Response)));
	}

	@RestController
	public class SogazStub {

		final Pattern Contracts = Pattern.compile("<m0:ID>(.*)<\\/m0:ID>");
		//final Pattern eventType = Pattern.compile("<eventType>(.*)<\\/eventType>");


		@RequestMapping(value = "/sogazbusstub", produces = MediaType.TEXT_XML_VALUE, method = {RequestMethod.GET, RequestMethod.POST})
		public String index(HttpEntity<String> httpEntity) throws InterruptedException {
			String raw = httpEntity.getBody();

			Matcher m1 = Contracts.matcher(raw);
			m1.find();
			System.out.println(m1.group(1));


			// Matcher m2 = eventType.matcher(raw);
			// m2.find();
			// System.out.println(m2.group(1));

			String file ="/resources/getContractAndLossList_v3Response1.xml";
			try {
				BufferedReader reader = new BufferedReader(new FileReader(file));
				String resp = reader.readLine();

				reader.close();
				return resp;
			}
			catch (IOException e){
				System.out.println("File not found");
			}
			if ("К_5418d523-7e34-11db-8708-003048800b16".equals(m1.group(1))) {
			return resp;

			}

			else{
				return "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\"><soapenv:Body></soapenv:Body></soapenv:Envelope>\n";
			}
		return "Nothing to do here";
		}

	}

}
