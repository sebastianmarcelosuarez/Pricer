package com.application.repository;

import com.application.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.Optional;

public interface PriceRepository extends JpaRepository<Price, Long> {
	@Query("SELECT s FROM Price s WHERE s.productId = ?2 AND s.brandId = ?3 AND s.startDate <= ?1 AND s.endDate >= ?1 ORDER BY s.priority DESC LIMIT 1")
	Optional<Price> findByStartDateInterval(LocalDateTime applicationDate, Integer productId, Integer brandId);

}
