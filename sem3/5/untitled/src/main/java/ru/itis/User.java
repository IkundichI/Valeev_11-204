package ru.itis;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class User {

    private String name;
    private List<String> messages;

    public void addMessage(String message) {
        this.messages.add(message);
    }
}
