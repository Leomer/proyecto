package com.upc.proyecto.infrastructure.web.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JsonResponseController<T> {
    private int code;
    private String message;
    private T data;
}
