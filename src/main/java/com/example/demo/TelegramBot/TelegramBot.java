package com.example.demo.TelegramBot;


import com.example.demo.TelegramBot.BotConfiguration.UserEntity;
import com.example.demo.TelegramBot.BotConfiguration.UserService;
import com.example.demo.service.DataBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


@Component
public class TelegramBot extends TelegramLongPollingBot {

    @Autowired
    UserService service = new UserService();

    @Autowired
    private DataBaseService dataBaseService = new DataBaseService();

    @Override
    public String getBotUsername() {
        return "file_torage_bot";
    }
    @Override
    public String getBotToken() {
        return "6191542431:AAE6YVMxaFaLutNWWMqX09nTCW7X8KqRB2o";
    }


    @Async
    @Override
    public void onUpdateReceived(Update update) {
        long chatId = update.getMessage().getChatId();
        boolean hasText = update.hasMessage() && update.getMessage().hasText();
        String command = update.getMessage().getText();
        if (hasText && command.equals("/addMe")){
            if (!service.existsByChatId(chatId)){
                UserEntity entity = new UserEntity();
                entity.setChatId(chatId);
                entity.setSubscribe(false);
                service.save(entity);
                sendMessage(update,"That's OK!");
            }
            else sendMessage(update, "U are in table yet!");
        }
        else if (hasText && command.equals("/me")){
            sendMessage(update, service.inTable(chatId).toString());
        }

    }

    public void sendMessage(Update update, String text){

        try {
            execute(
                    SendMessage.builder()
                            .chatId(String.valueOf((update.hasMessage()) ? update.getMessage().getChatId() : update.getCallbackQuery().getFrom().getId()))
                            .text(text)
                            .build());
        }
        catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

}
