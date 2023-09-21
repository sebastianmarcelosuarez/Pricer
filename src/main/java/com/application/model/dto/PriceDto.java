package com.application.model.dto;

import java.time.LocalDateTime;

public record PriceDto(Long id, Integer brandId, LocalDateTime startDate,
					   LocalDateTime endDate, Integer priceList, Integer productId,
					   Integer priority, Double price, String curr) {
}
