package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Address;
import utils.DbUtils;

public class AddressesDAO {
	
	/**
	 * add address into table Addresses
	 * @param address
	 */
	public static void add(Address address) {
		
		String sql = "INSERT INTO Addresses (zipcode, town, street, buildNumber) VALUES (?, ?, ?, ?)";
		try {
			java.sql.PreparedStatement statement = DbUtils.getConnection()
					.prepareStatement(sql);
			
			statement.setString(1, address.getIndex());
			statement.setString(2, address.getTown());
			statement.setString(3, address.getStreet());
			statement.setString(4, address.getBuildNumber());
			
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("A new address was inserted successfully!");
				statement.close();
			}
		} catch (SQLException e) {
			System.out.println("Exception in add(Address address)!");
			e.printStackTrace();
		}
	}
	
	/**
	 * delete address from addresses table
	 * @param id - address id
	 */
	public static void delete(long id) {
		String sql = "DELETE FROM addresses WHERE id=?";
		try {
			java.sql.PreparedStatement statement = DbUtils.getConnection().prepareStatement(sql);
			statement.setLong(1, id);
			int rowsDeleted = statement.executeUpdate();
			if (rowsDeleted > 0) {
				System.out.println("An address was deleted successfully!");
			}
			statement.close();
		} catch (SQLException ex) {
			System.out.println("Exception in delete(long id) - address");
			ex.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param address
	 *            address for update
	 */
	public static void update(Address address) {
		String sql = "UPDATE addresses SET zipcode = ?, town = ?, street = ?, buildNumber = ? WHERE id= "
				+ address.getId();
		try {
			java.sql.PreparedStatement statement = DbUtils.getConnection().prepareStatement(sql);
			statement.setString(1, address.getIndex());
			statement.setString(2, address.getTown());
			statement.setString(3, address.getStreet());
			statement.setString(4, address.getBuildNumber());

			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated > 0) {
				System.out.println("An existing address was updated successfully!");
			}
			statement.close();
		} catch (SQLException e) {
			System.out.println("Exception in update(Address address)");
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @return list of all address from Addresses table
	 */
	public static List<Address> getAll() {
		String sql = "SELECT * FROM addresses";						
		List<Address> addresses = new ArrayList<>();
		Address address = new Address();
		try {
			Statement statement = (Statement) DbUtils.getConnection().createStatement();
			ResultSet result = statement.executeQuery(sql);
			while (result.next()) {
				
				address = new Address();
				address.setIndex(result.getString("zipcode"));
				address.setTown(result.getString("town"));
				address.setStreet(result.getString("street"));
				address.setBuildNumber(result.getString("buildNumber"));
				
				addresses.add(address);
			}
			statement.close();
			result.close();
		} catch (SQLException ex) {
			System.out.println("Exception in getAll()! (addresses)");
			ex.printStackTrace();
		}
		return addresses;
	}


}
