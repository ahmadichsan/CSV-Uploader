package com.app.csvdatatodb.serviceimpl;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;

import au.com.bytecode.opencsv.CSVReader;
import org.apache.commons.lang.StringUtils;

public class CSVLoaderImpl {

	private static final String SQL_INSERT = "INSERT INTO ${table} (${keys}) VALUES (${values});";
	private static final String TABLE_REGEX = "\\$\\{table\\}";
	private static final String KEYS_REGEX = "\\$\\{keys\\}";
	private static final String VALUES_REGEX = "\\$\\{values\\}";

	private Connection connection;
	private char seprator;


	/**
	 * Public constructor to build CSVLoader object with
	 * Connection details. The connection is closed on success
	 * or failure.
	 * @param connection
	 * @return 
	 */
	
	public CSVLoaderImpl(Connection connection) {
		this.connection = connection;
		this.seprator = ',';
	}

	public void loadCSV(String csvFile, String tableName, boolean truncateBeforeLoad) throws Exception {
		CSVReader csvReader = null;
		Connection con = null;
		PreparedStatement ps = null;
		try {
			if(null == this.connection) {
				throw new Exception("Not a valid connection.");
			}
			
			csvReader = new CSVReader(new FileReader(csvFile), this.seprator);
			
			// read the first row which is the column header
			String[] headerRow = csvReader.readNext();

			if (null == headerRow) {
				throw new FileNotFoundException("No columns defined in given CSV file. Please check the CSV file format.");
			}
			
			String questionmarks = StringUtils.repeat("?,", headerRow.length);
			questionmarks = (String) questionmarks.subSequence(0, questionmarks.length() - 1);

			String query = SQL_INSERT.replaceFirst(TABLE_REGEX, tableName);
			query = query.replaceFirst(KEYS_REGEX, StringUtils.join(headerRow, ","));
			query = query.replaceFirst(VALUES_REGEX, questionmarks);

			System.out.println("Query: " + query);
			
			String[] nextLine;
			
			try {
				con = this.connection;
				con.setAutoCommit(false);
				ps = con.prepareStatement(query);

				// beware for this function. This will delete data in table first before load the csv
				if(truncateBeforeLoad) {
					//delete data from table before loading csv
					con.createStatement().execute("DELETE FROM " + tableName);
				}

				final int batchSize = 1000;
				int count = 0;
				while ((nextLine = csvReader.readNext()) != null) {
					ps.setString(1, nextLine[0]);
					ps.setString(2, nextLine[1]);
					ps.setString(3, nextLine[2]);
					ps.setString(4, nextLine[3]);
					ps.setString(5, nextLine[4]);
					ps.setString(6, nextLine[5]);
					ps.setString(7, nextLine[6]);
					ps.setString(8, nextLine[7]);
					ps.setString(9, nextLine[8]);
					ps.setString(10, nextLine[9]);
					ps.setString(11, nextLine[10]);
					ps.setString(12, nextLine[11]);
					ps.setString(13, nextLine[12]);
					ps.setString(14, nextLine[13]);
					ps.setString(15, nextLine[14]);
					ps.setString(16, nextLine[15]);
					ps.setString(17, nextLine[16]);
					ps.setString(18, nextLine[17]);
					ps.addBatch();
					
					if (++count % batchSize == 0) {
						ps.executeBatch();
					}
				}
				
				// insert remaining records
				ps.executeBatch();
				con.commit();
				
			} catch (Exception e) {
				con.rollback();
				e.printStackTrace();
				throw new Exception("Error occured while loading data from file to database, error message: " + e.getMessage());
			}
		} catch (Exception e) {
			
		} finally {
			if (null != ps) {
				ps.close();	
			}
			
			if (null != con) {
				con.close();
			}
			
			if (null != csvReader) {
				csvReader.close();
			}
		}
	}
	
	public char getSeprator() {
		return seprator;
	}

	public void setSeprator(char seprator) {
		this.seprator = seprator;
	}
}
