package com.example.demo.TelegramBot.BotConfiguration;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
    boolean existsByChatId(Long chatId);
    UserEntity findByChatId(Long chatId);
}
