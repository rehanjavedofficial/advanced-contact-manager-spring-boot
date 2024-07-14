package com.rcm.entities.forms;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
public class UserForm {

    private String fullName;
    private String email;
    private String password;
    private String phone;
    private String about;


}
