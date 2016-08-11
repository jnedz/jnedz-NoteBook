package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Owner;
import entity.PhoneNumber;
import entity.User;
import enums.NumbersType;
import utils.DbUtils;

public class PhonesNumbersDAO {

	/**
	 * add phoneNumber into table PhonesNumbers
	 * 
	 * @param phoneNumber
	 */
	public static void add(PhoneNumber phoneNumber, User user) {

		String sql = "INSERT INTO PhonesNumbers (numbersType, phoneNumber, user_id) VALUES (?, ?, ?)";
		try {
			java.sql.PreparedStatement statement = DbUtils.getConnection().prepareStatement(sql);

			statement.setString(1, phoneNumber.getNumbersType().name());
			statement.setString(2, phoneNumber.getPhoneNumber());
			statement.setLong(3, user.getId());

			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("A new phoneNumber was inserted successfully!");
				statement.close();
			}
		} catch (SQLException e) {
			System.out.println("Exception in add(PhoneNumber phoneNumber)!");
			e.printStackTrace();
		}
	}

	/**
	 * delete phone number from PhonesNumbers table
	 * 
	 * @param id
	 *            - phoneNumber id
	 */
	public static void delete(long id) {
		String sql = "DELETE FROM phonesNumbers WHERE id=?";
		try {
			java.sql.PreparedStatement statement = DbUtils.getConnection().prepareStatement(sql);
			statement.setLong(1, id);
			int rowsDeleted = statement.executeUpdate();
			if (rowsDeleted > 0) {
				System.out.println("A phoneNumber was deleted successfully!");
			}
			statement.close();
		} catch (SQLException ex) {
			System.out.println("Exception in delete(long id) - PhonesNumbers");
			ex.printStackTrace();
		}
	}
	
	//TODO
	/**
	 * 
	 * @param owner
	 *            owner for update
	 */
	public static void update(PhoneNumber phoneNumber) {
		String sql = "UPDATE phonesNumbers SET numbersType = ?, phoneNumber = ? WHERE id= "
				+ phoneNumber.getId();
		try {
			java.sql.PreparedStatement statement = DbUtils.getConnection().prepareStatement(sql);

			/*statement.setString(1, owner.getLogin());
			statement.setString(2, owner.getPassword());*/
			
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
	 * @return list of all phonesNumbers from PhonesNumbers table
	 */
	public static List<PhoneNumber> getAll() {
		String sql = "SELECT * FROM PhonesNumbers";						
		List<PhoneNumber> phonesNumbers = new ArrayList<>();
		PhoneNumber phoneNumber = new PhoneNumber();
		try {
			Statement statement = (Statement) DbUtils.getConnection().createStatement();
			ResultSet result = statement.executeQuery(sql);
			while (result.next()) {
				
				phoneNumber = new PhoneNumber();
				phoneNumber.setNumbersType(NumbersType.valueOf(result.getString("numbersType")));
				phoneNumber.setPhoneNumber(result.getString("phoneNumber"));
				
				phonesNumbers.add(phoneNumber);
			}
			statement.close();
			result.close();
		} catch (SQLException ex) {
			System.out.println("Exception in getAll()! (PhonesNumbers)");
			ex.printStackTrace();
		}
		return phonesNumbers;
	}


}
