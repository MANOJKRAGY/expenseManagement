package com.example.expensemanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionResponseDto {
    private String message;
    private HttpStatus httpStatus;
}
