package com.nikisham2.nikisham.controllers;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.nikisham2.nikisham.DTOBuy.BuyDTO;
import com.nikisham2.nikisham.entities.Buy;
import com.nikisham2.nikisham.repositories.BuyRepositories;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;

@RestController
public class BuyController {
    private final static Logger logger = LoggerFactory.getLogger(BuyRepositories.class);

    @Autowired
    public BuyController(BuyRepositories buyRepositories) {
    }

    private final static String baseFile = "buy.json";

    public static void toJSON(BuyDTO buyDTO) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(baseFile), buyDTO);
        System.out.println("json created!");
    }

    public static BuyDTO toJavaObject() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(baseFile), BuyDTO.class);
    }

    }


