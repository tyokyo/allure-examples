package com.noname.model;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    String email;
    String password;
    String name;
    String surname;
}
