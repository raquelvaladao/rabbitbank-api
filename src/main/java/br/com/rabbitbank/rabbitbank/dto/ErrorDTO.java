package br.com.rabbitbank.rabbitbank.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;

import static com.fasterxml.jackson.annotation.JsonInclude.*;

@Data
@AllArgsConstructor
@JsonInclude(Include.NON_NULL)
public class ErrorDTO {
    private String field;
    private String message;
}
