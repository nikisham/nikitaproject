package com.nikisham2.nikisham.service;

import com.nikisham2.nikisham.BaseTest;
import com.nikisham2.nikisham.dto.BuyDTO;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class BuyServiceTest extends BaseTest {
    @Test
    void create() throws Exception {
        var dto = new BuyDTO();
        dto.setId(-1000);
        dto.setName("BadTest3");
        dto.setPrice(null);
        dto.setDate("11/13/2021");
        dto.setNumber(null);
        dto.setLot("666");
        dto.setVolume("555");
        var result = mockMvc.perform(post("/buy")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(dto)))
                .andDo(print())
                .andExpect(status().isOk()).andReturn();

        var actual = mapper.readValue(result.getResponse().getContentAsString(), BuyDTO.class);
        assertNull(actual.getNumber(), (String) null);
        assertEquals(actual.getId(),-1000);
        assertEquals(actual.getPrice(), null);
        assertEquals(actual.getName(), "BadTest3");

        dto.setName(null);
        mockMvc.perform(post("/buy")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(dto)))
                .andExpect(status().isBadRequest());

    }
    @Test
    void update() throws Exception {
        var dto = new BuyDTO();
        dto.setId(buyId_1);
        dto.setName("Test 2");
        dto.setPrice("111");
        dto.setDate("11/13/2021");
        dto.setNumber(null);
        dto.setLot("333");
        dto.setVolume("444");
        var result = mockMvc.perform(put("/buy")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(dto)))
                .andDo(print())
                .andExpect(status().isOk()).andReturn();
        var actual = mapper.readValue(result.getResponse().getContentAsString(), BuyDTO.class);
        assertEquals(actual.getId(), buyId_1);
        assertNull(actual.getNumber());
        assertEquals(actual.getName(), "Test 2");

        dto.setId(1200);
        mockMvc.perform(put("/buy")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(dto)))
                .andDo(print())
                .andExpect(status().isBadRequest()).andReturn();
    }
}
