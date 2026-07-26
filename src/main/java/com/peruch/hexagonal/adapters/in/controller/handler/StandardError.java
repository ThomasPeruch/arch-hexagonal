package com.peruch.hexagonal.adapters.in.controller.handler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StandardError {
    private String message;
    private Integer status;
    private String path;
    private Instant timestamp;
}
