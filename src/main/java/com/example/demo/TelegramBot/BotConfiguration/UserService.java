package com.example.demo.TelegramBot.BotConfiguration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public void save(UserEntity entity){
        userRepository.save(entity);
    }
    public boolean existsByChatId(Long chatId){
        return userRepository.existsByChatId(chatId);
    }
    public UserEntity inTable (Long chatId){
        return userRepository.findByChatId(chatId);
    }

}

