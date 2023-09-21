package com.application;

import com.application.service.PriceService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class MyApplicationRunner implements ApplicationRunner {

	private final PriceService priceService;

	public MyApplicationRunner(PriceService priceService) {
		this.priceService = priceService;
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {

		System.out.println("Application started!");
		priceService.initialize();
	}
}
