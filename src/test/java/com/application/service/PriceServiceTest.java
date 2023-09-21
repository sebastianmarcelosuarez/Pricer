package com.application.service;

import com.application.model.dto.PriceSearchDto;
import com.application.model.dto.PriceSearchResultDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.util.AssertionErrors.assertNotNull;

@SpringBootTest
public class PriceServiceTest {

	@Autowired
	PriceService priceService;

	@Test
	public void test1() {
		// Test 1: petición a las 10:00 del día 14 del producto 35455   para la brand 1 (ZARA)

		LocalDateTime priceDate = LocalDateTime.of(2020, 06, 14, 10, 00, 00);
		PriceSearchDto priceSearchDto = new PriceSearchDto(priceDate, 35455, 1);

		Optional<PriceSearchResultDTO> priceOptional = priceService.getPrice(priceSearchDto);

		assertNotNull("priceOptional shouldn't be null", priceOptional.isPresent());

		PriceSearchResultDTO priceResult = priceOptional.get();

		assertEquals(35455, priceResult.productId());
		assertEquals(1, priceResult.brandId());
		assertEquals(35.5, priceResult.price());
		assertEquals("2020-06-14T00:00", priceResult.startDate().toString());
		assertEquals("2020-12-31T23:59:59", priceResult.endDate().toString());
		assertEquals("35.5 EUR", priceResult.finalPrice());
	}

	@Test
	public void test2() {
		//Test 2: petición a las 16:00 del día 14 del producto 35455 para la brand 1 (ZARA)

		LocalDateTime priceDate = LocalDateTime.of(2020, 06, 14, 16, 00, 00);
		PriceSearchDto priceSearchDto = new PriceSearchDto(priceDate, 35455, 1);

		Optional<PriceSearchResultDTO> priceOptional = priceService.getPrice(priceSearchDto);

		assertNotNull("priceOptional shouldn't be null", priceOptional.isPresent());

		PriceSearchResultDTO priceResult = priceOptional.get();
		assertEquals(35455, priceResult.productId());
		assertEquals(1, priceResult.brandId());
		assertEquals(25.45, priceResult.price());
		assertEquals("2020-06-14T15:00", priceResult.startDate().toString());
		assertEquals("2020-06-14T18:30", priceResult.endDate().toString());
		assertEquals("25.45 EUR", priceResult.finalPrice());

	}

	@Test
	public void test3() {
		// Test 3: petición a las 21:00 del día 14 del producto 35455   para la brand 1 (ZARA)

		LocalDateTime priceDate = LocalDateTime.of(2020, 06, 14, 21, 00, 00);
		PriceSearchDto priceSearchDto = new PriceSearchDto(priceDate, 35455, 1);

		Optional<PriceSearchResultDTO> priceOptional = priceService.getPrice(priceSearchDto);

		assertNotNull("priceOptional shouldn't be null", priceOptional.isPresent());

		PriceSearchResultDTO priceResult = priceOptional.get();
		assertEquals(35455, priceResult.productId());
		assertEquals(1, priceResult.brandId());
		assertEquals(35.5, priceResult.price());
		assertEquals("2020-06-14T00:00", priceResult.startDate().toString());
		assertEquals("2020-12-31T23:59:59", priceResult.endDate().toString());
		assertEquals("35.5 EUR", priceResult.finalPrice());
	}

	@Test
	public void test4() {
		//  Test 4: petición a las 10:00 del día 15 del producto 35455   para la brand 1 (ZARA)

		LocalDateTime priceDate = LocalDateTime.of(2020, 06, 15, 10, 00, 00);
		PriceSearchDto priceSearchDto = new PriceSearchDto(priceDate, 35455, 1);

		Optional<PriceSearchResultDTO> priceOptional = priceService.getPrice(priceSearchDto);

		assertNotNull("priceOptional shouldn't be null", priceOptional.isPresent());

		PriceSearchResultDTO priceResult = priceOptional.get();
		assertEquals(35455, priceResult.productId());
		assertEquals(1, priceResult.brandId());
		assertEquals(30.5, priceResult.price());
		assertEquals("2020-06-15T00:00", priceResult.startDate().toString());
		assertEquals("2020-06-15T11:00", priceResult.endDate().toString());
		assertEquals("30.5 EUR", priceResult.finalPrice());

	}

	@Test
	public void test5() {
		//Test 5: petición a las 21:00 del día 16 del producto 35455   para la brand 1 (ZARA)

		LocalDateTime priceDate = LocalDateTime.of(2020, 06, 16, 21, 00, 00);
		PriceSearchDto priceSearchDto = new PriceSearchDto(priceDate, 35455, 1);

		Optional<PriceSearchResultDTO> priceOptional = priceService.getPrice(priceSearchDto);

		assertNotNull("priceOptional shouldn't be null", priceOptional.isPresent());

		PriceSearchResultDTO priceResult = priceOptional.get();
		assertEquals(35455, priceResult.productId());
		assertEquals(1, priceResult.brandId());
		assertEquals(38.95, priceResult.price());
		assertEquals("2020-06-15T16:00", priceResult.startDate().toString());
		assertEquals("2020-12-31T23:59:59", priceResult.endDate().toString());
		assertEquals("38.95 EUR", priceResult.finalPrice());

	}
}
