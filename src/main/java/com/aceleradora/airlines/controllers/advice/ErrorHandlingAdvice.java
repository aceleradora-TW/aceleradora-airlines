package com.aceleradora.airlines.controllers.advice;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

import static java.util.stream.Collectors.toList;

@ControllerAdvice
public class ErrorHandlingAdvice {

    @ExceptionHandler(BindException.class)
    public ResponseEntity<Map<String, Object>> resolveBindingException(BindException ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("error", "Invalid parameters received");
        body.put("invalidParameters", ex.getBindingResult().getFieldErrors().stream()
                .map(fe -> new InvalidParameter(fe.getField(), fe.getRejectedValue()))
                .collect(toList()));

        return ResponseEntity.badRequest().body(body);
    }

    @ExceptionHandler(HttpMessageNotWritableException.class)
    public ResponseEntity<Map<String, Object>> resolveJsonWriteException(HttpMessageNotWritableException ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("error", ex.getMessage());
        body.put("cause", ex.getCause().getMessage());

        return ResponseEntity.badRequest().body(body);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Map<String, Object>> resolveJsonReadException(HttpMessageNotReadableException ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("error", ex.getMessage());
        body.put("cause", ex.getCause().getMessage());

        return ResponseEntity.badRequest().body(body);
    }


}
