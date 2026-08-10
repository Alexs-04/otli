package com.korebit.dto;

public record Response(String message, Object data, int code) {
    public static Response ok() {
        return new Response("Success", null, 200);
    }
}
