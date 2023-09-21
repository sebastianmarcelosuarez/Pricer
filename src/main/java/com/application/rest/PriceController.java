package com.application.rest;

import com.application.model.dto.PriceSearchDto;
import com.application.model.dto.PriceSearchResultDTO;
import com.application.service.PriceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RestController
@RequestMapping("/price")
public class PriceController {

	private final PriceService priceService;

	public PriceController(PriceService priceService) {
		this.priceService = priceService;
	}

	@GetMapping(value = "/findPrice")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity getPriceAPI(@RequestBody PriceSearchDto priceSearchDto) {
		Optional<PriceSearchResultDTO> priceOptional = priceService.getPrice(priceSearchDto);

		if (priceOptional.isEmpty() ) return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

		return ResponseEntity.status(HttpStatus.OK).body(priceOptional);
	}

}
