package com.app.csvdatatodb.serviceimpl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.app.csvdatatodb.response.JsonResponse;
import com.app.csvdatatodb.service.CsvService;

@Service
public class CsvServiceImpl implements CsvService {
	
	private static String JDBC_CONNECTION_URL = "jdbc:postgresql://localhost:5432/csvreader";
	
	@Override
	public JsonResponse insertCsvToDb(MultipartFile file) {
		JsonResponse jsonResponse = new JsonResponse();
		File newFile = null;
		try {
			newFile = convert(file);
			String path = newFile.getAbsolutePath();
			
			try {
				CSVLoaderImpl loader = new CSVLoaderImpl(getCon());
				loader.loadCSV(path, "csv", true);
				jsonResponse.setMessage("Aman");
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}
			
			return jsonResponse;
		} catch (Exception e) {
			jsonResponse.setMessage(e.getMessage());
			return jsonResponse;
		} finally {
			if (newFile.exists()) {
				newFile.delete();
			}
		}
	}
	
	private static Connection getCon() {
		Connection connection = null;
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(JDBC_CONNECTION_URL, "postgres", "ichsan13");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	public static File convert(MultipartFile file) throws IOException {
	    File convFile = new File(file.getOriginalFilename());
	    convFile.createNewFile();
	    FileOutputStream fos = new FileOutputStream(convFile);
	    fos.write(file.getBytes());
	    fos.close();
	    return convFile;
	}
}
