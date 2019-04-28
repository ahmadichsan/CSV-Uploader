package com.app.csvdatatodb.service;

import org.springframework.web.multipart.MultipartFile;

import com.app.csvdatatodb.response.JsonResponse;

public interface CsvService {

	public JsonResponse insertCsvToDb(MultipartFile file);
}
