package com.ykjava.service;

import org.springframework.stereotype.Service;

/**
 * Created by baoz on 2017/3/9.
 */
@Service
public class HelloWordService {
    public HelloWordService() {
        System.out.println("HelloWordService");
    }

    public String geneString() {
        return "hws";
    }
}
