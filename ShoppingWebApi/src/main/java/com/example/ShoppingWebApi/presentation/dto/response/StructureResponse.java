package com.example.ShoppingWebApi.presentation.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StructureResponse<T> {
    private boolean success;
    private String message;
    private T data;
    private Instant timestamp;

    // Factory method để tạo response thành công
    public static <T> StructureResponse<T> success(String message, T data) {
        return StructureResponse.<T>builder()
                .success(true)
                .message(message)
                .data(data)
                .timestamp(Instant.now())
                .build();
    }

    // Factory method để tạo response thất bại
    public static <T> StructureResponse<T> error(String code, String message) {
        return StructureResponse.<T>builder()
                .success(false)
                .message(message)
                .timestamp(Instant.now())
                .build();
    }
}