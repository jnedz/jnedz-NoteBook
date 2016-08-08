package dao;

import java.sql.SQLException;

import entity.Address;
import utils.DbUtils;

public class AddressesDAO {
	
	public static void add(Address address) {
		String sql = "INSERT INTO Addresses (id, indeks, town, street, buildNumber "
				+ "VALUES (?, ?, ?, ?, ?)";
		try {
			java.sql.PreparedStatement statement = DbUtils.getConnection().prepareStatement(sql);
			
			statement.setLong(1, address.getId());
			statement.setString(2, address.getIndex());
			statement.setString(3, address.getTown());
			statement.setString(4, address.getStreet());
			statement.setString(5, address.getBuildNumber());
			
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

}
