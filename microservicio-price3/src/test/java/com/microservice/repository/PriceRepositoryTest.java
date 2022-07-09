package com.microservice.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.microservice.entity.Price;

@SpringBootTest
public class PriceRepositoryTest {

	@Autowired
	private PriceRepository priceRepository;

	@Test
	void findPricesByProductIdAndBrandIdTest() {
		List<Price> prices = priceRepository.findPricesByProductIdAndBrandId(35455, 1);
		// Assertions.assertEquals("Kirshi", prices.stream().findAny().get().getName());
		assertTrue(4 == prices.size());
	}

	@Test
	void findByPriceTest() {
		List<Price> prices = priceRepository.findByPrice(35.50);
		Assertions.assertNotNull(prices);
		assertTrue(1 == prices.size());
	}

	@Test
	void findByPriorityTest() {
		List<Price> prices = priceRepository.findByPriority(8);
		Assertions.assertTrue(prices.isEmpty());
	}

	// Test 1: petición a las 10:00 del día 14 del producto 35455 para la brand 1 (ZARA)
	@Test
	void findPricesByProductIdAndBrandIdAndStartDateLessThanAndEndDateGreaterThanTest1() throws ParseException {
		Date fechaTest = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2020-06-14 10:00:00");

		List<Price> prices = priceRepository
				.findPricesByProductIdAndBrandIdAndStartDateLessThanAndEndDateGreaterThanOrderByPriorityAsc(35455, 1,
						fechaTest, fechaTest);
		Assertions.assertNotNull(prices);// trajo 1, l primera es la lista 1 (priority 0)
		assertTrue(1 == prices.get(0).getPriceList());
	}

	// Test 2: petición a las 16:00 del día 14 del producto 35455 para la brand 1 (ZARA)
	@Test
	void findPricesByProductIdAndBrandIdAndStartDateLessThanAndEndDateGreaterThanTest2() throws ParseException {
		Date fechaTest = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2020-06-14 16:00:00");

		List<Price> prices = priceRepository
				.findPricesByProductIdAndBrandIdAndStartDateLessThanAndEndDateGreaterThanOrderByPriorityAsc(35455, 1,
						fechaTest, fechaTest);
		Assertions.assertNotNull(prices);// trajo 2 (lista UNO y DOS), l primera es la lista 1 (priority 0)
		assertTrue(1 == prices.get(0).getPriceList());
	}

	// Test 3: petición a las 21:00 del día 14 del producto 35455 para la brand 1 (ZARA)
	@Test
	void findPricesByProductIdAndBrandIdAndStartDateLessThanAndEndDateGreaterThanTest3() throws ParseException {
		Date fechaTest = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2020-06-14 21:00:00");

		List<Price> prices = priceRepository
				.findPricesByProductIdAndBrandIdAndStartDateLessThanAndEndDateGreaterThanOrderByPriorityAsc(35455, 1,
						fechaTest, fechaTest);
		Assertions.assertNotNull(prices);// trajo 1 (lista UNO), l primera es la lista 1 (priority 0)
		assertTrue(1 == prices.get(0).getPriceList());
	}

	// Test 4: petición a las 10:00 del día 15 del producto 35455 para la brand 1 (ZARA)
	@Test
	void findPricesByProductIdAndBrandIdAndStartDateLessThanAndEndDateGreaterThanTest4() throws ParseException {
		Date fechaTest = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2020-06-15 10:00:00");

		List<Price> prices = priceRepository
				.findPricesByProductIdAndBrandIdAndStartDateLessThanAndEndDateGreaterThanOrderByPriorityAsc(35455, 1,
						fechaTest, fechaTest);
		Assertions.assertNotNull(prices); // trajo 2 ((lista UNO y TRES), l primera es la lista 1 (priority 0)
		assertTrue(1 == prices.get(0).getPriceList());
	}

	// Test 5: petición a las 21:00 del día 16 del producto 35455 para la brand 1 (ZARA)
	@Test
	void findPricesByProductIdAndBrandIdAndStartDateLessThanAndEndDateGreaterThanTest5() throws ParseException {
		Date fechaTest = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2020-06-16 21:00:00");

		List<Price> prices = priceRepository
				.findPricesByProductIdAndBrandIdAndStartDateLessThanAndEndDateGreaterThanOrderByPriorityAsc(35455, 1,
						fechaTest, fechaTest);
		Assertions.assertNotNull(prices);// trajo 2 (lista UNO y CUATRO), l primera es la lista 1 (priority 0)
		assertTrue(1 == prices.get(0).getPriceList());
	}

	// Test 5 Improvement: petición a las 21:00 del día 16 del producto 35455 para
	// la brand 1
	// (ZARA)
	@Test
	void findTop1PricesByProductIdAndBrandIdAndStartDateLessThanAndEndDateGreaterThanTest5() throws ParseException {
		Date fechaTest = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2020-06-16 21:00:00");

		List<Price> prices = priceRepository
				.findTop1PricesByProductIdAndBrandIdAndStartDateLessThanAndEndDateGreaterThanOrderByPriorityAsc(35455,
						1, fechaTest, fechaTest);
		Assertions.assertNotNull(prices);// trajo 1 (lista UNO), l primera es la lista 1 (priority 0)
		assertTrue(1 == prices.get(0).getPriceList());
	}

}
