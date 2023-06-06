package com.example.demo.TelegramBot.BotConfiguration;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private Long chatId;
    private Boolean subscribe;

    @Override
    public String toString(){
        return "id = "+id+"\n" +
                "chatId = "+chatId+"\n" +
                "sub = "+subscribe;
    }
}
