package com.nikisham2.nikisham.repository;

import com.nikisham2.nikisham.entity.TelegramUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelegramUserRepository extends JpaRepository<TelegramUser, String> {

}
