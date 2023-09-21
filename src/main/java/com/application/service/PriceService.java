package com.application.service;

import com.application.model.Price;
import com.application.model.dto.PriceSearchDto;
import com.application.model.dto.PriceSearchResultDTO;
import com.application.repository.PriceRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PriceService {

	private final PriceRepository priceRepository;

	public PriceService(PriceRepository postRepository) {
		this.priceRepository = postRepository;
	}

	//Acepte como parámetros de entrada: fecha de aplicación, identificador de producto, identificador de cadena.
	//Devuelva como datos de salida: identificador de producto, identificador de cadena, tarifa a aplicar,
	// fechas de aplicación y precio final a aplicar.


	public Optional<PriceSearchResultDTO> getPrice(PriceSearchDto priceSearchDto) {
		Optional<Price> priceOptional = priceRepository.findByStartDateInterval(priceSearchDto.startDate(),
			priceSearchDto.productId(), priceSearchDto.brandId());

		if (priceOptional.isEmpty()) return Optional.empty();

		PriceSearchResultDTO priceSearchResultDTO = new PriceSearchResultDTO(priceOptional.get().getProductId(),
			priceOptional.get().getBrandId(), priceOptional.get().getPrice(),priceOptional.get().getStartDate(),
			priceOptional.get().getEndDate(), priceOptional.get().getPrice()+" "+priceOptional.get().getCurr());

		Optional.of(priceSearchResultDTO);

		return Optional.of(priceSearchResultDTO);

	}

	public void initialize() {

		List priceList = new ArrayList<Price>();

		Price price1 = new Price();

		price1.setBrandId(1);
		price1.setStartDate(LocalDateTime.of(2020,06,14,00,00,00));
		price1.setEndDate(LocalDateTime.of(2020,12,31,23,59,59));
		price1.setPriceList(1);
		price1.setProductId(35455);
		price1.setPriority(0);
		price1.setPrice(35.50);
		price1.setCurr("EUR");

		Price price2 = new Price();

		price2.setBrandId(1);
		price2.setStartDate(LocalDateTime.of(2020,06,14,15,00,00));
		price2.setEndDate(LocalDateTime.of(2020,06,14,18,30,00));
		price2.setPriceList(2);
		price2.setProductId(35455);
		price2.setPriority(1);
		price2.setPrice(25.45);
		price2.setCurr("EUR");

		Price price3 = new Price();

		price3.setBrandId(1);
		price3.setStartDate(LocalDateTime.of(2020,06,15,00,00,00));
		price3.setEndDate(LocalDateTime.of(2020,06,15,11,00,00));
		price3.setPriceList(3);
		price3.setProductId(35455);
		price3.setPriority(1);
		price3.setPrice(30.50);
		price3.setCurr("EUR");

		Price price4 = new Price();

		price4.setBrandId(1);
		price4.setStartDate(LocalDateTime.of(2020,06,15,16,00,00));
		price4.setEndDate(LocalDateTime.of(2020,12,31,23,59,59));
		price4.setPriceList(4);
		price4.setProductId(35455);
		price4.setPriority(1);
		price4.setPrice(38.95);
		price4.setCurr("EUR");


		priceList.add(price1);
		priceList.add(price2);
		priceList.add(price3);
		priceList.add(price4);

		priceRepository.saveAll(priceList);


	}
}

//	BRAND_ID         START_DATE                                    END_DATE                        PRICE_LIST                   PRODUCT_ID  PRIORITY                 PRICE           CURR
//1         2020-06-14-00.00.00                        2020-12-31-23.59.59                        1                        35455                0                        35.50            EUR
//	1         2020-06-14-15.00.00                        2020-06-14-18.30.00                        2                        35455                1                        25.45            EUR
//	1         2020-06-15-00.00.00                        2020-06-15-11.00.00                        3                        35455                1                        30.50            EUR
//	1         2020-06-15-16.00.00                        2020-12-31-23.59.59                        4                        35455                1                        38.95            EUR
