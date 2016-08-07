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
					+ "firstName  varchar(20) not null, lastName varchar(20) not null, type enum('" + sb
					+ "') default 'OTHER', email varchar(40), dateOfBirthday date, "
					+ "address_id int, FOREIGN KEY (address_id) REFERENCES Addresses(id), "
				//	+ "phoneNumbers_id int, FOREIGN KEY (phoneNumbers_id) REFERENCES PhoneNumbers(id), "
					+ "primary key (id))";

			statement = getConnection().createStatement();
			statement.executeUpdate(sql);
			statement.close();
		} catch (SQLException sqlexc) {
			System.out.println("Exeption in createUsersTable()");
		}
	}
	
	public static void createAddressesTable() {

		Statement statement = null;
		try {
			String sql = "create table Addresses (id INT NOT NULL AUTO_INCREMENT, "
					+ "index varchar(5), town varchar(20), street varchar(20), buildNumber varchar(10), "
					+ "primary key (id))";
			statement = getConnection().createStatement();
			statement.executeUpdate(sql);
			statement.close();
		} catch (SQLException sqlexc) {
			System.out.println("Exeption in createAddressesTable()");
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
