package com.nikisham2.nikisham.service;

import com.nikisham2.nikisham.BaseTest;
import com.nikisham2.nikisham.dto.BuyDTO;
import com.nikisham2.nikisham.entity.Buy;
import com.nikisham2.nikisham.repository.BuyRepository;
import liquibase.pro.packaged.B;
import org.glassfish.grizzly.http.Note;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.testcontainers.shaded.org.awaitility.Awaitility.given;


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
    public void getAll_Return(){
        /*String Buy_id = UUID.randomUUID().toString();
        Mockito.doReturn(IntStream.range(0,3).mapToObj(i -> new Buy()).collect(Collectors.toList()))
                .when(this.buyRepository).findAll(ArgumentMatchers.any());
        Collection<Buy> collection = this.buyRepository.findAll(Buy_id);
        Mockito.verify(this.buyRepository).findAll(ArgumentMatchers.eq(Buy_id));
        Assert.assertNotNull(collection);
        assertEquals(3L,collection.size());
*/
    }

    @Test
    public void getOne() {
        BuyDTO dto = buyService.getOne(buyId_1);
        assertEquals(buyId_1, dto.getId());
        //TODO Добавить проверки.
    }
    @Test
    public void getOne_1() {
        buyService.delete(List.of(buyId_1));
        BuyDTO dto = buyService.getOne(buyId_1);
        assertEquals(buyId_1, dto.getId());
        
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
    public void create_Invalid(){
        BuyDTO dto = new BuyDTO();
        dto.setId(buyId_1);
        dto.setName("Test112");
        dto.setPrice("8882");
        dto.setDate("11/13/2022");
        dto.setNumber(7772);
        dto.setLot("6662");
        dto.setVolume("5552");
        UUID id = buyService.create(dto).getId();
        assertNotEquals(id,buyId_1);
        assertNotNull(buyRepository.findById(id).orElse(null));
       }

    @Test
    public void create_2(){
        BuyDTO dto = new BuyDTO();
        dto.setId(UUID.randomUUID());
        dto.setName("Test112");
        dto.setPrice("8882");
        dto.setDate("11/13/2022");
        dto.setNumber(7772);
        dto.setLot("6662");
        dto.setVolume("5552");
        UUID id = buyService.create(dto).getId();
        BuyDTO buyDTO_DB = buyService.getOne(id);
        assertEquals(buyDTO_DB.getName(),"Test112");

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
    void update_1(){
        BuyDTO dto = buyService.getOne(buyId_1);
        dto.setId(UUID.randomUUID());
        dto.setName("Test112");
        dto.setPrice("8882");
        dto.setDate("11/13/2022");
        dto.setNumber(7772);
        dto.setLot("6662");
        dto.setVolume("5552");
        buyService.update(dto);
        BuyDTO buyDTO_DB = buyService.getOne(buyId_1);
        assertEquals(buyDTO_DB.getId(),"Entity not found");
    }

    @Test
    void delete() {
        assertDoesNotThrow(() -> buyService.delete(List.of(buyId_2)));


        //TODO Добавить проверки.
    }
    @Test
    void delete_1(){
        buyService.delete(List.of(buyId_2));
        BuyDTO dto = buyService.getOne(buyId_2);
        assertNull(dto.getId());
    }

    @Test
    void delete_2(){
        buyService.delete(List.of(buyId_2));
        BuyDTO dto = buyService.getOne(buyId_2);
        System.out.println(buyId_2);
        assertEquals(dto.getId(),"NOT_FOUND");
    }
}
