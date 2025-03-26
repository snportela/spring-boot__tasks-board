package com.example.taskBoard.infra;

public record ErrorResponse (
        int status,
        String message,
        String details
){
}
