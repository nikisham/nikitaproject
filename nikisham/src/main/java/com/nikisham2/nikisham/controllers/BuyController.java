package com.nikisham2.nikisham.controllers;

import com.nikisham2.nikisham.dto.BuyDTO;
import com.nikisham2.nikisham.service.BuyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("buy")
public class BuyController {
    private final BuyService service;

    @GetMapping("all")
    public List<BuyDTO> getAll() {
        return service.getAll();
    }

    @GetMapping("one")
    public BuyDTO getOne(@RequestParam UUID id) {
        return service.getOne(id);
    }

    @PostMapping
    public BuyDTO create(@Valid @RequestBody BuyDTO dto) {
        return service.create(dto);
    }

    @PutMapping
    public BuyDTO update(@Valid @RequestBody BuyDTO dto) {
        return service.update(dto);
    }

    @DeleteMapping
    public void delete(@RequestBody Collection<UUID> ids) {
        service.delete(ids);
    }

}
