package dao;

import java.sql.SQLException;
import java.util.Date;

import org.joda.time.DateTime;

import entity.User;
import utils.DbUtils;

public class PhoneBookDAO{
	
	public static void add(User user) {
		String sql = "INSERT INTO PhoneBook (id, firstName, lastName, type, email, dateOfBirthday, phoneNumbers_id, "
				+ "address_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			java.sql.PreparedStatement statement = DbUtils.getConnection().prepareStatement(sql);
			
			statement.setLong(1, user.getId());
			statement.setString(2, user.getFirstName());
			statement.setString(3, user.getLastName());
			statement.setString(4, user.getType().name());
			statement.setString(5, user.getEmail());
			
			DateTime dt = user.getDateOfBirthday();
			Date date = new java.sql.Date(dt.getMillis());
			statement.setDate(6, (java.sql.Date) date);
			
			statement.setLong(7, user.getTelNumbers().getId());
			statement.setLong(8, user.getAddress().getId());
			
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("A new phone book was inserted successfully!");
				statement.close();
			}
		} catch (SQLException e) {
			System.out.println("Exception in add(User user)!");
			e.printStackTrace();
		}
	}

}
