package com.nikisham2.nikisham.service;

import com.nikisham2.nikisham.dto.BuyDTO;
import com.nikisham2.nikisham.entity.Buy;
import com.nikisham2.nikisham.repository.BuyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
@Slf4j
public class BuyService {
    private static final String ENTITY_NOT_FOUND = "Entity not found";
    private static final String ENTITY_EXIST = "Entity already exist";
    private final BuyRepository repository;

    public List<BuyDTO> getAll() {
        return repository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public BuyDTO getOne(Integer id) {
        return toDTO(repository.findById(id).orElseThrow(() -> {
            throw new EntityNotFoundException(ENTITY_NOT_FOUND);
        }));
    }

    @Transactional
    public BuyDTO create(BuyDTO dto) {
        Optional<Buy> entity = repository.findById(dto.getId());
        if (entity.isPresent()) {
            throw new EntityExistsException(ENTITY_EXIST);
        }
        repository.save(toEntity(dto));
        return dto;
    }

    @Transactional
    public BuyDTO update(BuyDTO dto) {
        repository.findById(dto.getId()).ifPresentOrElse(buy -> repository.save(toEntity(dto)), () -> {
            throw new EntityNotFoundException(ENTITY_NOT_FOUND);
        });
        return dto;
    }

    @Transactional
    public void delete(Collection<Integer> ids) {
        ids.forEach(id -> {
            try {
                repository.deleteById(id);
            } catch (Exception e) {
                throw new EntityNotFoundException(ENTITY_NOT_FOUND);
            }
        });
    }

    private BuyDTO toDTO(Buy entity) {
        BuyDTO dto = new BuyDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setPrice(entity.getPrice());
        dto.setNumber(entity.getNumber());
        dto.setLot(entity.getLot());
        dto.setDate(entity.getDate());
        dto.setVolume(entity.getVolume());
        return dto;
    }

    private Buy toEntity(BuyDTO dto) {
        Buy entity = new Buy();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setPrice(dto.getPrice());
        entity.setNumber(dto.getNumber());
        entity.setLot(dto.getLot());
        entity.setDate(dto.getDate());
        entity.setVolume(dto.getVolume());
        return entity;
    }
}
