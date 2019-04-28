package com.app.csvdatatodb.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.csvdatatodb.response.JsonResponse;
import com.app.csvdatatodb.service.CsvService;

@RestController
@RequestMapping("/csv")
public class CsvController {

	@Autowired
	CsvService csvService;
	
	@PostMapping("/add")
	public ResponseEntity<?> insertCsvToDb(@RequestParam (value = "file", required = false) MultipartFile file) throws Exception {
		JsonResponse jsonResponse;
		try {
			Date startDate = new Date();
			jsonResponse = csvService.insertCsvToDb(file);
			System.out.println(startDate);
			System.out.println(new Date());
			return ResponseEntity.ok(jsonResponse);
		} catch (Exception e) {
			List<Object> error = new ArrayList<>();
			error.add(1, e.getMessage());
			error.add(2, e.getStackTrace());
			error.add(3, e.getCause());
			return ResponseEntity.badRequest().body(error);
		}
	}
}
