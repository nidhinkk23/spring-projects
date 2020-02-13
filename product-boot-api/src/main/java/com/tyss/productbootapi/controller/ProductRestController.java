package com.tyss.productbootapi.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.productbootapi.dto.ProductInfoBean;
import com.tyss.productbootapi.dto.ProductResponse;
import com.tyss.productbootapi.service.ProductService;

@RestController
public class ProductRestController {
	@Autowired
	private ProductService service;
	
	
	@PostMapping(path = "/add-product",
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes =MediaType.APPLICATION_JSON_VALUE )
	public ProductResponse addProduct(@RequestBody ProductInfoBean bean) {
		ProductResponse response = new ProductResponse();
		if(service.addProduct(bean)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Data inserted in to DB ");
		}else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Data is not inserted in to DB ");
			
		}
		return response;
	}
	
	
	@DeleteMapping(path = "/delete/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ProductResponse removeProduct(@PathVariable("id")int id) {
		ProductResponse response = new ProductResponse();
		
		if(service.removeProduct(id)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Product is Removed");
		}else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Product is not removed ");
			
		}
		return response;
		
		
	}
	
	@PostMapping(path = "/update-product",
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes =MediaType.APPLICATION_JSON_VALUE
			)
	public ProductResponse updateProduct(@RequestBody ProductInfoBean bean) {
		ProductResponse response = new ProductResponse();
		System.out.println(bean);
		if(service.updateProduct(bean)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Product is Updated");
			response.setBeans(Arrays.asList(bean));
		}else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Product is not Updated ");
			
		}
		return response;
	}
	
	@GetMapping(path = "/search-by-name",produces = MediaType.APPLICATION_JSON_VALUE)
	public ProductResponse getProductByName(@RequestParam(name="name",required = false)String name) {
		ProductResponse response = new ProductResponse();
		List<ProductInfoBean> beans = service.getProductByName(name);
		if(beans!=null && !beans.isEmpty()) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Data Found in DB foe the requested name");
			response.setBeans(beans);
		}else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Data Not Found in DB foe the requested name");
//			response.setBeans(null);
		}
		return response;
	}
	
	
	@GetMapping(path = "/search",produces = MediaType.APPLICATION_JSON_VALUE)
	public ProductResponse getAllProduct() {
		ProductResponse response = new ProductResponse();
		List<ProductInfoBean> beans = service.getAllProduct();
		if(beans!=null && !beans.isEmpty()) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Data Found in DB ");
			response.setBeans(beans);
		}else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Data Not Found in DB");
//			response.setBeans(null);
		}
		return response;
	}
	
	
}
