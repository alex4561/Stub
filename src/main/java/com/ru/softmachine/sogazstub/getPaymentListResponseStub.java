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
public class getPaymentListResponseStub {

    final Pattern INN = Pattern.compile("<m:GUIDDSP>(.*)<\\/m:GUIDDSP>");
    //final Pattern KPP = Pattern.compile("<per:KPP>(.*)<\\/per:KPP>");


    @RequestMapping(value = "/getPaymentListResponseStub", produces = MediaType.TEXT_XML_VALUE, method = {RequestMethod.GET, RequestMethod.POST})
    public String index(HttpEntity<String> httpEntity) throws InterruptedException {
        String raw = httpEntity.getBody();

        Matcher m1 = INN.matcher(raw);
        m1.find();
        System.out.println(m1.group(1));

        /*Matcher m2 = KPP.matcher(raw);
        m2.find();
        System.out.println(m2.group(1));*/


        if ("00000278-adaf-4a5c-9b56-46555c564874".equals(m1.group(1))) {

            try {
                Resource resource = new ClassPathResource("responses/getPaymentListResponse/getPaymentLisResponse.xml");

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
                Resource resource = new ClassPathResource("responses/getPaymentListResponse/getPaymentLisResponseFail.xml");
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
