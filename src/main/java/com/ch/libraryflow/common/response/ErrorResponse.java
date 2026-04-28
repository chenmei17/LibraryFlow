package com.ch.libraryflow.common.response;

public record ErrorResponse (
    String errorCode,
    String message
){}
