package com.example;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by yangshuo on 2017/1/20.
 */
@Component
public class ComputeClientHystrix implements ComputeClient{
    @Override
    public String add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b) {
        return "error";
    }
}
