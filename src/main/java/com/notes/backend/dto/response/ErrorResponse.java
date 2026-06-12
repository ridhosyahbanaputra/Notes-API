package com.notes.backend.dto.response;

public record ErrorResponse (
        String status,
        String message
){
}
