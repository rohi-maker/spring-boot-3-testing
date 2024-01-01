package com.kaamDekho.models.response;


import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
public class ApplicationResponse {
    private int statusCode;
    private Object Data;
    private String errorMessage;
}
