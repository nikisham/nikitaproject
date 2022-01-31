package com.nikisham2.nikisham.service;

import com.nikisham2.nikisham.dto.TelegramDTO;
import com.nikisham2.nikisham.entity.TelegramUser;
import com.nikisham2.nikisham.repository.TelegramUserRepository;
import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@Service
public class TelegramUserService {

    private final TelegramUserRepository telegramUserRepository;

    @Autowired
    public TelegramUserService(TelegramUserRepository telegramUserRepository) {
        this.telegramUserRepository = telegramUserRepository;
    }

    public void save(TelegramUser telegramUser){
        telegramUserRepository.save(telegramUser);
    }

    public Optional<TelegramUser> findByChatId(String chatId) {
        return telegramUserRepository.findById(chatId);
    }

    private TelegramDTO toTelegramDto(TelegramUser entity){
        TelegramDTO dto = new TelegramDTO();
        dto.setChatId(entity.getChatId());
        dto.setActive(entity.getActive());
        dto.setTool(entity.getTool());
        dto.setPrice(entity.getPrice());
        dto.setLot(entity.getLot());
        dto.setPrice(entity.getPrice());
        return dto;
    }
    private TelegramUser toTelegramEntity(TelegramDTO dto){
        TelegramUser entity = new TelegramUser();
        entity.setChatId(dto.getChatId());
        entity.setActive(dto.getActive());
        entity.setTool(dto.getTool());
        entity.setPrice(dto.getPrice());
        entity.setLot(dto.getLot());
        entity.setPrice(dto.getPrice());
        return entity;
    }
}
