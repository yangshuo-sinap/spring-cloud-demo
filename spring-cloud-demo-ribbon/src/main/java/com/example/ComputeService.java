package com.example;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by yangshuo on 2017/1/20.
 */
@Service
public class ComputeService {

    @Autowired
    private RestTemplate template;

    @HystrixCommand(fallbackMethod = "addFallback")
    public String add(Integer a, Integer b) {
        return template.getForEntity(String.format("http://COMPUTE-SERVICE/add?a=%d&b=%d", a, b), String.class).getBody();
    }

    public String addFallback(Integer a, Integer b) {
        return "error";
    }
}
