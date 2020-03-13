package com.ru.softmachine.sogazstub;

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

@RestController
public class getCountInsuredOfContractsStub {

    final Pattern ID_Dog = Pattern.compile("<m0:ID>(.*)<\\/m0:ID>");
    //final Pattern KPP = Pattern.compile("<per:KPP>(.*)<\\/per:KPP>");


    @RequestMapping(value = "/getCountInsuredOfContracts", produces = MediaType.TEXT_XML_VALUE, method = {RequestMethod.GET, RequestMethod.POST})
    public String index(HttpEntity<String> httpEntity) throws InterruptedException {
        String raw = httpEntity.getBody();

        Matcher m1 = ID_Dog.matcher(raw);
        m1.find();
        System.out.println(m1.group(1));

        /*Matcher m2 = KPP.matcher(raw);
        m2.find();
        System.out.println(m2.group(1));*/


        if ("09dd3d65-ad16-42aa-bcb9-9083670e041d".equals(m1.group(1))) {

            try {
                Resource resource = new ClassPathResource("responses/getCountInsuredOfContracts/getCountInsuredOfContractsResponse.xml");
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
                Resource resource = new ClassPathResource("responses/getCountInsuredOfContracts/getCountInsuredOfContractsFail.xml");
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
