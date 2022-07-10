This test was really challenging.

I have decided, in addition owas orginnaly reqeuset in the test,
a Swagger plugin to enhance visualziation of the Rest microservices
http://localhost:8080/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config#/price-controller


Microservices REST.

This one return the String of the Price requested.
@Operation(summary = "Obtain String Data Price by productId & brandId & dateValue")
The method which is uses for the 5 test es:
PriceRepository.findTop1PricesByProductIdAndBrandIdAndStartDateLessThanAndEndDateGreaterThanOrderByPriorityAsc(
			int productId, int brandId, Date startDate, Date endDate);

and in 
PriceController.searchByProductIdAndBrandIdAndDateString(@PathVariable("productId") int productId,
			@PathVariable("brandId") int brandId, @PathVariable("dateValue") String dateValue)

This one return a Price Object
@Operation(summary = "Obtain Object Data Price by productId & brandId & dateValue")
	public ResponseEntity<List<Price>> searchByProductIdAndBrandIdAndDate(@PathVariable("productId") int productId,
			@PathVariable("brandId") int brandId, @PathVariable("dateValue") String dateValue) throws ParseException {


Also add some other Methods to:
-list Prices
-Search by Id
-delete  price by id
-create new price


In PriceRepositoryTest are all the test requested:
// Test 1: petición a las 10:00 del día 14 del producto 35455 para la brand 1 (ZARA)
void findPricesByProductIdAndBrandIdAndStartDateLessThanAndEndDateGreaterThanTest1

etc
