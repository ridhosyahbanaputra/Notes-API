package com.notes.backend.dto.response;

public record ApiResponse<T>(
        String status,
        String message,
        T data
) {
}
