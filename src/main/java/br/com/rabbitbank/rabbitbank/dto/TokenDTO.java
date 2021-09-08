package br.com.rabbitbank.rabbitbank.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.ResponseEntity;

@Data
@AllArgsConstructor
public class TokenDTO {
    private String token;
    private String type;
}
