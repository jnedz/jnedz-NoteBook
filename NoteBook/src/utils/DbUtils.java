package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import enums.Group;

public class DbUtils {

	static final String DB_URL = "jdbc:mysql://localhost/test";
	static final String USER = "root";
	static final String PASS = "root";
	private static Connection conn = null;

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Connection false");
		}
	}

	public static Connection getConnection() {
		return conn;
	}

	/*
	public static void createPhoneBookTable() {

		Statement statement = null;
		StringBuilder sb = new StringBuilder();
		for (Group type : Group.values()) {
			if (sb.length() == 0) {
				sb.append(type.toString());
			} else {
				sb.append("', '" + type.toString());
			}
		}
		try {
			String sql = "create table PhoneBook (id INT NOT NULL, "//AUTO_INCREMENT, "
					+ "firstName  varchar(20) not null, lastName varchar(20) not null, type enum('" + sb
					+ "') default 'OTHER', email varchar(40), dateOfBirthday date, " + "homePhoneNumber varchar(12), "
					+ "workPhoneNumber varchar(12), "

					+ "mobileNumbers_id int, FOREIGN KEY (mobileNumbers_id) REFERENCES MobileNumbers(id), "
					
					+ "address_id int, FOREIGN KEY (address_id) REFERENCES Addresses(id), "

					+ "primary key (id))";

			statement = getConnection().createStatement();
			statement.executeUpdate(sql);
			statement.close();
		} catch (SQLException sqlexc) {
			System.out.println("Exeption in createPhoneBookTable()");
		}
	}
	*/
	
	public static void createPhoneBookTable() {

		Statement statement = null;
		StringBuilder sb = new StringBuilder();
		for (Group type : Group.values()) {
			if (sb.length() == 0) {
				sb.append(type.toString());
			} else {
				sb.append("', '" + type.toString());
			}
		}
		try {
			String sql = "create table PhoneBook (id INT NOT NULL, "//AUTO_INCREMENT, "
					+ "firstName  varchar(20) not null, lastName varchar(20) not null, type enum('" + sb
					+ "') default 'OTHER', email varchar(40), dateOfBirthday date, "

					+ "phoneNumbers_id int, FOREIGN KEY (phoneNumbers_id) REFERENCES PhoneNumbers(id), "
					
					+ "address_id int, FOREIGN KEY (address_id) REFERENCES Addresses(id), "

					+ "primary key (id))";

			statement = getConnection().createStatement();
			statement.executeUpdate(sql);
			statement.close();
		} catch (SQLException sqlexc) {
			System.out.println("Exeption in createPhoneBookTable()");
		}
	}
	
	public static void createPhoneNumbersTable() {

		Statement statement = null;
		try {
			String sql = "create table phoneNumbers (id INT NOT NULL AUTO_INCREMENT, " 
		+ "workNumber varchar(12), "
		+ "homeNumber varchar(12), "
		+ "mobileNumbers_id int, FOREIGN KEY (mobileNumbers_id) REFERENCES MobileNumbers(id), "
		+ "primary key (id) )";
			statement = getConnection().createStatement();
			statement.executeUpdate(sql);
			statement.close();
		} catch (SQLException sqlexc) {
			System.out.println("Exeption in createPhoneNumbersTable()");
		}
	}

	public static void createMobileNumbersTable() {

		Statement statement = null;
		try {
			String sql = "create table MobileNumbers (id INT NOT NULL AUTO_INCREMENT, " + "mobileNumber varchar(12), "
					+ "primary key (id) )";
			statement = getConnection().createStatement();
			statement.executeUpdate(sql);
			statement.close();
		} catch (SQLException sqlexc) {
			System.out.println("Exeption in createMobileNumbersTable()");
		}
	}
	


	public static void createAddressesTable() {

		Statement statement = null;
		try {
			String sql = "create table Addresses (id INT NOT NULL AUTO_INCREMENT, " + "indeks varchar(5), " // why
																											// not
																											// indeX?!!
					+ "town varchar(20) not null, " + "street varchar(20), " + "buildNumber varchar(10), "
					+ "primary key (id) )";
			statement = getConnection().createStatement();
			statement.executeUpdate(sql);
			statement.close();
		} catch (SQLException sqlexc) {
			System.out.println("Exeption in createAddressesTable()");
		}

	}

	public static void dropPhoneBookTable() {

		Statement statement = null;
		try {
			String sql = "drop table if exists PhoneBook";
			statement = getConnection().createStatement();
			statement.executeUpdate(sql);
			statement.close();
		} catch (SQLException sqlexc) {
			System.out.println("SQL exception in dropPhoneBookTable()");
		}
	}

	public static void dropAddressesTable() {

		Statement statement = null;
		try {
			String sql = "drop table if exists Addresses";
			statement = getConnection().createStatement();
			statement.executeUpdate(sql);
			statement.close();
		} catch (SQLException sqlexc) {
			System.out.println("SQL exception in dropAddressesTable()");
		}
	}
	
	public static void dropPhoneNumbersTable() {

		Statement statement = null;
		try {
			String sql = "drop table if exists PhoneNumbers";
			statement = getConnection().createStatement();
			statement.executeUpdate(sql);
			statement.close();
		} catch (SQLException sqlexc) {
			System.out.println("SQL exception in dropPhoneNumbersTable()");
		}
	}

	public static void dropMobileNumbersTable() {

		Statement statement = null;
		try {
			String sql = "drop table if exists MobileNumbers";
			statement = getConnection().createStatement();
			statement.executeUpdate(sql);
			statement.close();
		} catch (SQLException sqlexc) {
			System.out.println("SQL exception in dropMobileNumbersTable()");
		}
	}

	public static void closeConnection() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
