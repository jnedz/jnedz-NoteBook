package dao;

import java.sql.SQLException;

import entity.PhonsNumbers;
import utils.DbUtils;

public class MobileNumbersDAO {
	
	public static void add(PhonsNumbers phNumbers) {
		String sql = "INSERT INTO PhoneNumbers (id, workNumber, homeNumber, mobileNumbers_id "
				+ "VALUES (?, ?, ?, ?)";
		try {
			java.sql.PreparedStatement statement = DbUtils.getConnection().prepareStatement(sql);
			
			statement.setLong(1, phNumbers.getId());
			statement.setString(2, phNumbers.getWorkNumber());
			statement.setString(3, phNumbers.getWorkNumber());
			//statement.setLong(4, phNumbers.);
			
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
