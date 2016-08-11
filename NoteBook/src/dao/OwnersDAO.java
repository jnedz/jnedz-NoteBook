package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Address;
import entity.Owner;
import utils.DbUtils;

public class OwnersDAO {

	/**
	 * add owner into table owners
	 * 
	 * @param owner
	 */
	public static void add(Owner owner) {

		String sql = "INSERT INTO Owners (login, password) VALUES (?, ?)";
		try {
			java.sql.PreparedStatement statement = DbUtils.getConnection().prepareStatement(sql);

			statement.setString(1, owner.getLogin());
			statement.setString(2, owner.getPassword());

			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("A new owner was inserted successfully!");
				statement.close();
			}
		} catch (SQLException e) {
			System.out.println("Exception in add(Owner owner)!");
			e.printStackTrace();
		}
	}

	/**
	 * delete owner from owners table
	 * 
	 * @param id
	 *            - address id
	 */
	public static void delete(long id) {
		String sql = "DELETE FROM owners WHERE id=?";
		try {
			java.sql.PreparedStatement statement = DbUtils.getConnection().prepareStatement(sql);
			statement.setLong(1, id);
			int rowsDeleted = statement.executeUpdate();
			if (rowsDeleted > 0) {
				System.out.println("An owner was deleted successfully!");
			}
			statement.close();
		} catch (SQLException ex) {
			System.out.println("Exception in delete(long id) - owners");
			ex.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param owner
	 *            owner for update
	 */
	public static void update(Owner owner) {
		String sql = "UPDATE owners SET login = ?, password = ? WHERE id= "
				+ owner.getId();
		try {
			java.sql.PreparedStatement statement = DbUtils.getConnection().prepareStatement(sql);

			statement.setString(1, owner.getLogin());
			statement.setString(2, owner.getPassword());
			
			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated > 0) {
				System.out.println("An existing owner was updated successfully!");
			}
			statement.close();
		} catch (SQLException e) {
			System.out.println("Exception in update(Owner owner)");
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @return list of all owners from Owners table
	 */
	public static List<Owner> getAll() {
		String sql = "SELECT * FROM owners";					
		List<Owner> owners = new ArrayList<>();
		Owner owner = new Owner();
		try {
			Statement statement = (Statement) DbUtils.getConnection().createStatement();
			ResultSet result = statement.executeQuery(sql);
			while (result.next()) {
				
				owner = new Owner();
				owner.setLogin(result.getString("login"));
				owner.setPassword(result.getString("password"));
				
				owners.add(owner);
			}
			statement.close();
			result.close();
		} catch (SQLException ex) {
			System.out.println("Exception in getAll()! (owners)");
			ex.printStackTrace();
		}
		return owners;
	}


}
