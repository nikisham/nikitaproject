package com.nikisham2.nikisham.service;

import com.nikisham2.nikisham.BaseTest;

import com.nikisham2.nikisham.dto.BuyDTO;

import com.nikisham2.nikisham.entity.Buy;
import com.nikisham2.nikisham.repository.BuyRepository;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;


import com.nikisham2.nikisham.BaseTest;
import com.nikisham2.nikisham.dto.BuyDTO;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.DataInput;
import java.util.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.testcontainers.shaded.org.awaitility.Awaitility.given;


public class BuyServiceTest extends BaseTest {


    @Autowired
    public BuyService buyService;



    @MockBean
    @Autowired
    private BuyRepository buyRepository;

    @Test
    public void getAll() throws Exception{
        List list = buyRepository.findAll();
        assertNull(list);
    }

    @Test
    public void getOne(UUID id) throws Exception{
        BuyDTO dto = buyRepository.findOne();
    }

    @Test
    public void create(UUID id) throws Exception {
        BuyDTO dto = new BuyDTO();
        dto.setName("Test111");
        dto.setPrice("8881");
        dto.setDate("11/13/2021");
        dto.setNumber(7771);
        dto.setLot("6661");
        dto.setVolume("5551");
        buyRepository.save(dto);
        assertNotNull(buyRepository.findById(id).get());
//        when(buyRepository.save(BuyDTO.class)).thenReturn(BuyDTO);
//        BuyDTO saveBuyDTO =buyRepository.save(dto);
//        assertEquals(saveBuyDTO.getName(), "Test111");
    }
    @Test
    void update(UUID id) throws Exception {
        BuyDTO dto = buyRepository.findById(id);
        dto.setName("Test123");
        buyRepository.save(dto);
        assertNotEquals("Test111",buyRepository.findById(id).get().getName());


    }
    @Test
    void delete(UUID id) throws Exception{
        buyRepository.deleteById(buyId_1);
        assertThat(buyRepository.existsById(id));
    }
}
