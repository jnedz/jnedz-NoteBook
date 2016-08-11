package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import enums.Group;
import enums.NumbersType;

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
	
	public static void createPhoneBooksTable() {

		Statement statement = null;
		
		try {
			String sql = "create table PhoneBooks (id INT NOT NULL AUTO_INCREMENT, "
		
					+ "user_id int not null, FOREIGN KEY (user_id) REFERENCES Users(id), "

					+ "owner_id int not null, FOREIGN KEY (owner_id) REFERENCES Owners(id), "

					+ "primary key (id) )";

			statement = getConnection().createStatement();
			statement.executeUpdate(sql);
			statement.close();
		} catch (SQLException sqlexc) {
			System.out.println("Exeption in createPhoneBooksTable()");
		}
	}
		
		
	
	public static void createUsersTable() {

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
			String sql = "create table Users (id INT NOT NULL AUTO_INCREMENT, "
																
					+ "firstName varchar(20) not null, lastName varchar(20) not null, type enum('" + sb
					+ "') default 'OTHER', email varchar(40), dateOfBirthday date, "

					+ "address_id int, FOREIGN KEY (address_id) REFERENCES Addresses(id), "

					+ "primary key (id))";

			statement = getConnection().createStatement();
			statement.executeUpdate(sql);
			statement.close();
		} catch (SQLException sqlexc) {
			System.out.println("Exeption in createUsersTable()");
		}
	}

	public static void createPhonesNumbersTable() {

		Statement statement = null;
		StringBuilder sb = new StringBuilder();
		for (NumbersType type : NumbersType.values()) {
			if (sb.length() == 0) {
				sb.append(type.toString());
			} else {
				sb.append("', '" + type.toString());
			}
		}
		try {
			String sql = "create table phonesNumbers (id INT NOT NULL AUTO_INCREMENT, " 
					+ "numbersType enum('" + sb
					+ "'), phoneNumber varchar(12) not null, " 
					+ "user_id int not null, FOREIGN KEY (user_id) REFERENCES Users(id), "
					+ "primary key (id) )";
			statement = getConnection().createStatement();
			statement.executeUpdate(sql);
			statement.close();
		} catch (SQLException sqlexc) {
			System.out.println("Exeption in createPhonesNumbersTable()");
		}
	}

	public static void createAddressesTable() {

		Statement statement = null;
		try {
			String sql = "create table Addresses (id INT NOT NULL AUTO_INCREMENT, " + "zipcode varchar(5), " 
					+ "town varchar(20) not null, " + "street varchar(20), " + "buildNumber varchar(10), "
					+ "primary key (id) )";
			statement = getConnection().createStatement();
			statement.executeUpdate(sql);
			statement.close();
		} catch (SQLException sqlexc) {
			System.out.println("Exeption in createAddressesTable()");
		}

	}

	public static void createOwnersTable() {

		Statement statement = null;
		try {
			String sql = "create table Owners (id int not null auto_increment, " 
					+ "login varchar(20) not null, "
					+ "password varchar(20) not null, " 
					+ "primary key (id) )";
			statement = getConnection().createStatement();
			statement.executeUpdate(sql);
			statement.close();
		} catch (SQLException sqlexc) {
			System.out.println("Exeption in createOwnersTable()");
		}
	}

	public static void dropPhoneBooksTable() {

		Statement statement = null;
		try {
			String sql = "drop table if exists PhoneBooks";
			statement = getConnection().createStatement();
			statement.executeUpdate(sql);
			statement.close();
		} catch (SQLException sqlexc) {
			System.out.println("SQL exception in dropPhoneBooksTable()");
		}
	}
	
	
	public static void dropUsersTable() {

		Statement statement = null;
		try {
			String sql = "drop table if exists Users";
			statement = getConnection().createStatement();
			statement.executeUpdate(sql);
			statement.close();
		} catch (SQLException sqlexc) {
			System.out.println("SQL exception in dropUsersTable()");
		}
	}
	
	public static void dropOwnersTable() {

		Statement statement = null;
		try {
			String sql = "drop table if exists Owners";
			statement = getConnection().createStatement();
			statement.executeUpdate(sql);
			statement.close();
		} catch (SQLException sqlexc) {
			System.out.println("SQL exception in dropOwnersTable()");
		}
	}

	public static void dropPhonesNumbersTable() {

		Statement statement = null;
		try {
			String sql = "drop table if exists PhonesNumbers";
			statement = getConnection().createStatement();
			statement.executeUpdate(sql);
			statement.close();
		} catch (SQLException sqlexc) {
			System.out.println("SQL exception in dropPhonesNumbersTable()");
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

	public static void closeConnection() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
