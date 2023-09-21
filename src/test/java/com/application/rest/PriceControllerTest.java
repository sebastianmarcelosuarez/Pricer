package com.application.rest;

import com.application.model.dto.PriceSearchDto;
import com.application.model.dto.PriceSearchResultDTO;
import com.google.gson.Gson;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MvcResult;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class PriceControllerTest extends AbstractControllerTest {

	//TODO create a should not return found price with 202 OR 204 http message

	@Test
	public void shouldReturnFoundPrice() throws Exception {
		// given
		LocalDateTime creationDate = LocalDateTime.of(2020, 06, 20, 17, 00, 00);
		PriceSearchResultDTO priceSearchResultDto = new PriceSearchResultDTO(123, 1,500.00, creationDate, creationDate , "500.00 EUR");
		PriceSearchDto priceSearchDto = new PriceSearchDto(creationDate, 35455, 1);
		String jsonString = "{\"startDate\":\"2020-06-14T17:00:00\", \"productId\": 35455, \"brandId\": 1}";

		// when
		when(priceService.getPrice(any())).thenReturn(Optional.of(priceSearchResultDto));

		// then
		mockMvc.perform(get("/price/findPrice")
				.contentType(APPLICATION_JSON)
			    .content(jsonString))
					.andExpect(status().isOk())
					.andExpect(content()
						.string("{\"productId\":123,\"brandId\":1,\"price\":500.0,\"startDate\":\"2020-06-20T17:00:00\"," +
							"\"endDate\":\"2020-06-20T17:00:00\",\"finalPrice\":\"500.00 EUR\"}"));

	}

	@Test
	public void shouldNotReturnFoundPrice() throws Exception {
		// given
		LocalDateTime creationDate = LocalDateTime.of(2020, 06, 20, 17, 00, 00);
		PriceSearchResultDTO priceSearchResultDto = new PriceSearchResultDTO(123, 1,500.00, creationDate, creationDate , "500.00 EUR");
		PriceSearchDto priceSearchDto = new PriceSearchDto(creationDate, 35455, 1);
		String jsonString = "{\"startDate\":\"2020-06-14T17:00:00\", \"productId\": 35455, \"brandId\": 1}";

		// when
		when(priceService.getPrice(any())).thenReturn(Optional.empty());

		// then
		mockMvc.perform(get("/price/findPrice")
			.contentType(APPLICATION_JSON)
			.content(jsonString))
				.andExpect(status().isNoContent())
				.andExpect(content().string(""));

	}

}
