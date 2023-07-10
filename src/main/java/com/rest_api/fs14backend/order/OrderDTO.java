package com.rest_api.fs14backend.order;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class OrderDTO {
    private UUID userId;
}