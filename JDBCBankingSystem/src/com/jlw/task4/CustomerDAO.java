package com.jlw.task4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CustomerDAO {

	public void createAccount(Customer customer) {

        String sql =
                "INSERT INTO customers(account_no,name,balance) VALUES(?,?,?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setLong(1, customer.getAccountNo());
            ps.setString(2, customer.getName());
            ps.setDouble(3, customer.getBalance());

            ps.executeUpdate();

            System.out.println("Account Created Successfully");

        } catch (Exception e) {
            System.out.println(e.getMessage());
}
	  }


public void viewAccount(long accountNo) {

    String sql =
            "SELECT * FROM customers WHERE account_no=?";

    try (Connection con = DBConnection.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setLong(1, accountNo);

        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            System.out.println("Account No : "
                    + rs.getLong("account_no"));
            System.out.println("Name : "
                    + rs.getString("name"));
            System.out.println("Balance : "
                    + rs.getDouble("balance"));
        } else {
            System.out.println("Account Not Found");
        }

    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
}

public void updateCustomer(long accountNo, String newName) {

    String sql =
            "UPDATE customers SET name=? WHERE account_no=?";

    try (Connection con = DBConnection.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setString(1, newName);
        
        ps.setLong(2, accountNo);

        int rows = ps.executeUpdate();

        System.out.println(rows > 0
                ? "Updated Successfully"
                : "Account Not Found");

    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
}

public void deleteCustomer(long accountNo) {

    String sql =
            "DELETE FROM customers WHERE account_no=?";

    try (Connection con = DBConnection.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setLong(1, accountNo);

        int rows = ps.executeUpdate();

        System.out.println(rows > 0
                ? "Deleted Successfully"
                : "Account Not Found");

    } 
    catch (Exception e) {
        System.out.println(e.getMessage());
    }
}
}

