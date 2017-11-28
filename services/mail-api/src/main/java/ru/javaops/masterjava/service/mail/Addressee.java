package ru.javaops.masterjava.service.mail;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Addressee {
    private @NonNull String email;
    private String name;

    public Addressee(String email) {
        this(email, null);
    }
}
