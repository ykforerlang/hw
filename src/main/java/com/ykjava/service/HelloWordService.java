package com.ykjava.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by baoz on 2017/3/9.
 */
@Service
public class HelloWordService {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    public String geneString() {
        log.info("invoke geneString...");
        return "hws";
    }
}
