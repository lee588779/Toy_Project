package me.donghyunLee.springbootdeveloper.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
public class AddUserRequest {
    private String email;
    private String password;
}
