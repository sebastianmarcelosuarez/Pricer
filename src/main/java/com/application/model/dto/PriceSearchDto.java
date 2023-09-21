package com.application.model.dto;

import java.time.LocalDateTime;

public record PriceSearchDto(LocalDateTime startDate, Integer productId, Integer brandId) {
}
