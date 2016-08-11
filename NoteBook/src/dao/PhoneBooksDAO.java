package dao;

import java.sql.SQLException;

import entity.Owner;
import entity.User;
import utils.DbUtils;

public class PhoneBooksDAO{
	
	public static void add(User user, Owner owner) {
		String sql = "INSERT INTO PhoneBooks (user_id, owner_id) VALUES (?, ?)";
		try {
			java.sql.PreparedStatement statement = DbUtils.getConnection().prepareStatement(sql);
			
			statement.setLong(1, user.getId());
			statement.setLong(2, owner.getId());
		
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("A new phoneBook was inserted successfully!");
				statement.close();
			}
		} catch (SQLException e) {
			System.out.println("Exception in add(User user, Owner owner)!");
			e.printStackTrace();
		}
	}
	
	/**
	 * delete phone book from PhoneBooks table
	 * 
	 * @param id
	 *            - PhoneBook id
	 */
	public static void delete(long id) {
		String sql = "DELETE FROM PhoneBooks WHERE id=?";
		try {
			java.sql.PreparedStatement statement = DbUtils.getConnection().prepareStatement(sql);
			statement.setLong(1, id);
			int rowsDeleted = statement.executeUpdate();
			if (rowsDeleted > 0) {
				System.out.println("A phoneBook was deleted successfully!");
			}
			statement.close();
		} catch (SQLException ex) {
			System.out.println("Exception in delete(long id) - PhoneBooks");
			ex.printStackTrace();
		}
	}

}
