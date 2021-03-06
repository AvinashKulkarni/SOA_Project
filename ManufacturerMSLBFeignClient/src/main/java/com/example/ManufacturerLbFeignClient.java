package com.example;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.hateoas.Resources;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.model.Manufacturer;

@FeignClient("manufacturer-microservice")
public interface ManufacturerLbFeignClient {
	
	

	@RequestMapping(value="/datarest", method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	Resources<Manufacturer> findAll();
	/*
	@RequestMapping(value="/datarest/search/{a}", method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	List<Manufacturer> findById(@PathVariable("a") String a);*/
	
	@RequestMapping(value="/datarest/search/findByStartDateBefore",
			method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	Resources<Manufacturer> findByStartDateBefore(
			@RequestParam("startDate") @DateTimeFormat(iso=ISO.DATE) Date startDate);
}
