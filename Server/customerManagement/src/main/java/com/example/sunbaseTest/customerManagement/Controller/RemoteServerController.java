package com.example.sunbaseTest.customerManagement.Controller;

import com.example.sunbaseTest.customerManagement.Model.Customer;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class RemoteServerController {
    private final RestTemplate restTemplate= new RestTemplate();
    public List<Customer> doWebSearch(String url){
        HttpHeaders headers = new HttpHeaders();

        headers.set("Authorization","Bearer dGVzdEBzdW5iYXNlZGF0YS5jb206VGVzdEAxMjM=");
        String uri = "https://qa2.sunbasedata.com/sunbase/portal/api/assignment.jsp?cmd=get_customer_list";

        HttpEntity entity = new HttpEntity<>(headers);

        ResponseEntity<List<Customer>> response = restTemplate.exchange(uri, HttpMethod.GET,entity, new ParameterizedTypeReference<List<Customer>>() {});
        List<Customer> resBody = response.getBody();
        return resBody;
    }

    public String getAuthToken(String url){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        MultiValueMap<String,String> requestBody = new LinkedMultiValueMap<>();
        requestBody.add("login_id","test@sunbasedata.com");
        requestBody.add("password","Test@123");

        String uri = "https://qa2.sunbasedata.com/sunbase/portal/api/assignment_auth.jsp";

        HttpEntity<MultiValueMap<String,String>> requestEntity = new HttpEntity<>(requestBody,headers);

        ResponseEntity<String> response = restTemplate.exchange(uri,HttpMethod.POST,requestEntity,String.class);
        return response.getBody();
    }
}





