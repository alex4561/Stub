package com.ru.softmachine.sogazstub;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.logging.Logger;



@RestController
public class getConragentListStub {

    final Pattern INN = Pattern.compile("<per:INN>(.*)<\\/per:INN>");
    final Pattern KPP = Pattern.compile("<per:KPP>(.*)<\\/per:KPP>");


    @RequestMapping(
            value = "/getContragentList",
            headers = {"SOAPAction=http://www.perconalcabinet.sogaz.ru#PersonalCabinet:getContragentList"},
            produces = MediaType.TEXT_XML_VALUE, method = {RequestMethod.GET, RequestMethod.POST})

    public String index(HttpEntity<String> httpEntity) throws InterruptedException {
        String raw = httpEntity.getBody();

        Matcher m1 = INN.matcher(raw);
        m1.find();
        System.out.println(m1.group(1));

        Matcher m2 = KPP.matcher(raw);
        m2.find();
        System.out.println(m2.group(1));


        if ("8971426272".equals(m1.group(1))&&"014644855".equals(m2.group(1))) {

            try {
                Resource resource = new ClassPathResource("responses/getContragentList/getContragentLisResponseMobilizacia.xml");

                BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()));

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
                Resource resource = new ClassPathResource("responses/getContragentList/getContragetnListResponseFail.xml");
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
