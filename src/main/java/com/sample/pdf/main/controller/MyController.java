package com.sample.pdf.main.controller;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sample.pdf.main.model.City;
import com.sample.pdf.main.service.ICityService;
import com.sample.pdf.main.utils.GeneratePdfReport;
	
@Controller
public class MyController {
	
	@Autowired
	private ICityService cityservice;
	
	
	@RequestMapping(value = "/pdfreport", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> getCityReport(){
		
		List<City> cityList = cityservice.findAll();
		
		ByteArrayInputStream input = GeneratePdfReport.citiesReport(cityList);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "inline; filename=citiesreport.pdf");
		
		return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(input));
		
	}

}
