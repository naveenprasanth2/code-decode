package com.example.codedecode.exception;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class BusinessException extends RuntimeException {
    private String errorCode;
    private String errorMessage;
}
