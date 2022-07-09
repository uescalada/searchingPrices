package com.microservice.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.microservice.entity.Price;

public interface PriceRepository extends CrudRepository<Price, Long> {

	List<Price> findPricesByProductIdAndBrandId(int productId, int brandId);

	List<Price> findByProductId(int productId);

	List<Price> findByPrice(double price);

	List<Price> findByPriority(int i);

	List<Price> findPricesByProductIdAndBrandIdAndStartDate(int productId, int brandId, Date fecha);

	List<Price> findPricesByProductIdAndBrandIdAndStartDateLessThanAndEndDateGreaterThanOrderByPriorityAsc(
			int productId, int brandId, Date startDate, Date endDate);

	// Improvement from last Method - Adding a Limit to Result to obtain a Unique
	// result ;)
	List<Price> findTop1PricesByProductIdAndBrandIdAndStartDateLessThanAndEndDateGreaterThanOrderByPriorityAsc(
			int productId, int brandId, Date startDate, Date endDate);

}
