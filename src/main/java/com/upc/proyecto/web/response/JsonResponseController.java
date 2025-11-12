package com.upc.proyecto.web.response;

public class JsonResponseController<T> {
    private int code;
    private String message;
    private T data;
}
