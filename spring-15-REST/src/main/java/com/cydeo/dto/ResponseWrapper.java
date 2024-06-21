package com.cydeo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.net.http.HttpResponse;

@Getter
@Setter
@NoArgsConstructor
public class ResponseWrapper {
    private boolean success;
    private String message;
    private Integer statusCode;
    private Object data;

    public ResponseWrapper(String message,Object data) {
        this.success = true;
        this.message = message;
        this.statusCode = HttpStatus.OK.value();
        this.data = data;
    }

    public ResponseWrapper(String message) {
        this.success = true;
        this.message = message;
        this.statusCode = HttpStatus.OK.value();
    }


}
