package com.jlw.task4;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class BankingService {

    public void transferMoney(
            long sender,
            long receiver,
            double amount) {

        String debit =
                "UPDATE customers SET balance = balance - ? WHERE account_no=?";

        String credit =
                "UPDATE customers SET balance = balance + ? WHERE account_no=?";

        try (Connection con = DBConnection.getConnection()) {

            con.setAutoCommit(false);

            PreparedStatement ps1 =
                    con.prepareStatement(debit);

            ps1.setDouble(1, amount);
            ps1.setLong(2, sender);

            ps1.executeUpdate();

            PreparedStatement ps2 =
                    con.prepareStatement(credit);

            ps2.setDouble(1, amount);
            ps2.setLong(2, receiver);

            ps2.executeUpdate();

            con.commit();

            System.out.println("Transfer Successful");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}