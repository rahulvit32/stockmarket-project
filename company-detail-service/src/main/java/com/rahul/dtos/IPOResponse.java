package com.rahul.dtos;

import lombok.Data;

@Data
public class IPOResponse {
    private boolean status;
    private String error;
    private String message;
}
