package com.nikisham2.nikisham.service;

import com.nikisham2.nikisham.BaseTest;
import com.nikisham2.nikisham.dto.BuyDTO;
import com.nikisham2.nikisham.entity.Buy;
import com.nikisham2.nikisham.repository.BuyRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;


public class BuyServiceTest extends BaseTest {
    @Autowired
    public BuyService buyService;
    @Autowired
    private BuyRepository buyRepository;

    @Test
    public void getAll() {
        List<BuyDTO> list = buyService.getAll();
        assertNotNull(list);
        //TODO Добавить проверки.
    }

    @Test
    public void getOne() {
        BuyDTO dto = buyService.getOne(buyId_1);
        assertEquals(buyId_1, dto.getId());
        //TODO Добавить проверки.
    }

    @Test
    public void create() {
        BuyDTO dto = new BuyDTO();
        dto.setId(UUID.randomUUID());
        dto.setName("Test111");
        dto.setPrice("8881");
        dto.setDate("11/13/2021");
        dto.setNumber(7771);
        dto.setLot("6661");
        dto.setVolume("5551");
        UUID id = buyService.create(dto).getId();
        assertNotNull(buyRepository.findById(id).orElse(null));
        //TODO Добавить проверки. При создании запись уже существует с таким id
    }

    @Test
    void update() {
        BuyDTO dto = buyService.getOne(buyId_1);
        dto.setName("Test123_update");
        buyService.update(dto);
        Buy entity = buyRepository.findById(buyId_1).orElse(null);
        assertNotNull(entity);
        assertEquals("Test123_update", entity.getName());
        //TODO Добавить проверки. Нельзя обновить/создать запись которой нет


    }

    @Test
    void delete() {
        assertDoesNotThrow(() -> buyService.delete(List.of(buyId_2)));
        //TODO Добавить проверки.
    }
}
