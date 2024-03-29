package com.cash.model;

import com.cash.util.RandomIdGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.Instant;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {

    private Integer id;
    private String guid;
    private String changed;
    private String deleted;
    private String login;

    public User(String deleted, String login) {
        this.id = RandomIdGenerator.getRandomID();
        this.guid = UUID.randomUUID().toString();
        this.changed = String.valueOf(Instant.now().getEpochSecond());
        this.deleted = deleted;
        this.login = login;
    }
}
