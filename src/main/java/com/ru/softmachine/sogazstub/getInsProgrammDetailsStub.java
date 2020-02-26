package com.ru.softmachine.sogazstub;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
public class getInsProgrammDetailsStub {

    final Pattern ProgID1 = Pattern.compile("<m0:ID>(.*)<\\/m0:ID>");

    @RequestMapping(value = "/getInsProgrammDetailsStub", produces = MediaType.TEXT_XML_VALUE, method = {RequestMethod.GET, RequestMethod.POST})
    public String index(HttpEntity<String> httpEntity) throws InterruptedException {
        String raw = httpEntity.getBody();

        Matcher m1 = ProgID1.matcher(raw);
        m1.find();
        System.out.println(m1.group(1));

        if ("9999978b-c0b6-4fa5-8aec-77028fb0dc63".equals(m1.group(1))) {

            try {
                Resource resource = new ClassPathResource("responses/getInsProgrammDetails/getInsProgrammDetailsResponseMobilizacia.xml");

                File file = resource.getFile();

                BufferedReader reader = new BufferedReader(new FileReader(file));

                String resp;
                while((resp = reader.readLine()) != null) {

                    return resp;
                }
                reader.close();
            }
            catch (IOException e){
                System.out.println("File not found");
            }

        }
        else if ("9999954c-9571-4015-8029-ec83f4f335b9".equals(m1.group(1))) {

            try {
                Resource resource = new ClassPathResource("responses/getInsProgrammDetails/getInsProgrammDetailsResponseMobilizacia.xml");

                File file = resource.getFile();


                BufferedReader reader = new BufferedReader(new FileReader(file));

                String resp;
                while((resp = reader.readLine()) != null) {

                    return resp;
                }
                reader.close();
            }
            catch (IOException e){
                System.out.println("File not found");
            }

        }

        else{
            try {
                Resource resource = new ClassPathResource("responses/getInsProgrammDetails/getInsProgrammDetailsFail.xml");
                File file = resource.getFile();

                BufferedReader reader = new BufferedReader(new FileReader(file));

                String resp;
                while((resp = reader.readLine()) != null) {

                    return resp;
                }
                reader.close();
            }
            catch (IOException e){
                System.out.println("File not found");
            }
        }
        return "NULL";
    }

}
