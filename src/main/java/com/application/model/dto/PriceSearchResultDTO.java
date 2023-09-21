package com.application.model.dto;

import java.time.LocalDateTime;

public record PriceSearchResultDTO(Integer productId, Integer brandId, Double price, LocalDateTime startDate,
								   LocalDateTime endDate, String finalPrice) {

}
