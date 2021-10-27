package com.nikisham2.nikisham.controllers;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nikisham2.nikisham.DTOBuy.BuyDTO;
import com.nikisham2.nikisham.repositories.BuyRepositories;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

@RestController
public class BuyController {

    private final static Logger logger = LoggerFactory.getLogger(BuyRepositories.class);
    private BuyRepositories buyRepositories;
    @Autowired
    public BuyController(BuyRepositories buyRepositories) {
    this.buyRepositories = buyRepositories;
    }

    @RequestMapping("json")
    public void json(){
        URL url= this.getClass().getClassLoader().getResource("buy.json");
        File jsonFile = new File(url.getFile());
        if(url!=null) {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                List<BuyDTO> buys = objectMapper.readValue(jsonFile, new TypeReference<List<BuyDTO>>() {
                });
                buyRepositories.saveAll(buys);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}


