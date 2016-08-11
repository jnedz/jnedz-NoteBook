package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;

import entity.PhoneNumber;
import entity.User;
import enums.Group;
import enums.NumbersType;
import utils.DbUtils;

public class UsersDAO {
	
	public static void add(User user) {
		String sql = "INSERT INTO Users (id, firstName, lastName, type, email, dateOfBirthday, "
				+ "address_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
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
		
			statement.setLong(7, user.getAddress().getId());
			
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("A new user was inserted successfully!");
				statement.close();
			}
		} catch (SQLException e) {
			System.out.println("Exception in add(User user)!");
			e.printStackTrace();
		}
	}
	
	/**
	 * delete user from Users table
	 * 
	 * @param id
	 *            - Users id
	 */
	public static void delete(long id) {
		String sql = "DELETE FROM Users WHERE id=?";
		try {
			java.sql.PreparedStatement statement = DbUtils.getConnection().prepareStatement(sql);
			statement.setLong(1, id);
			int rowsDeleted = statement.executeUpdate();
			if (rowsDeleted > 0) {
				System.out.println("An user was deleted successfully!");
			}
			statement.close();
		} catch (SQLException ex) {
			System.out.println("Exception in delete(long id) - Userss");
			ex.printStackTrace();
		}
	}

	
	/**
	 * 
	 * @return list of all users from Users table
	 */
	public static List<User> getAll() {
		String sql = "SELECT * FROM Users";						  //join table1 on table1.param = table2.param
		List<User> users = new ArrayList<>();
		User user = new User();
		try {
			Statement statement = (Statement) DbUtils.getConnection().createStatement();
			ResultSet result = statement.executeQuery(sql);
			while (result.next()) {
				
				user = new User();
				user.setFirstName(result.getString("firstName"));
				user.setLastName(result.getString("lastName"));
				user.setEmail(result.getString("email"));
				user.setType(Group.valueOf(result.getString("type")));
				
				
				
				
				users.add(user);
			}
			statement.close();
			result.close();
		} catch (SQLException ex) {
			System.out.println("Exception in getAll()! (Users)");
			ex.printStackTrace();
		}
		return users;
	}


}
