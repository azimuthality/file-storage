package com.example.demo.TelegramBot.BotConfiguration;

import com.example.demo.TelegramBot.TelegramBot;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;


@Configuration
@ComponentScan("com.example.demo")
public class BotConfig {
    @Bean
    public TelegramBot registration(){
        TelegramBot bot = new TelegramBot();
        try {
            new TelegramBotsApi(DefaultBotSession.class).registerBot(bot);
            System.out.println("Бот @"+bot.getBotUsername()+" успешно запущен!!!");
        } catch (Exception e){
            e.printStackTrace();
        }
        return bot;
    }
}
