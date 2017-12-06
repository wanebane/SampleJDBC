/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.rivaldy.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author RomyRivaldy
 */
public class CustomerFind {

    public static Customer findCustomer(int customerId) {

        Connection conn = CustomerDB.connectToDatabase();
        Customer c = new Customer();
        try {
            PreparedStatement pstm = conn.prepareStatement("SELECT * FROM CUSTOMER WHERE CUSTOMER_ID=?");
            pstm.setInt(1, customerId);
            ResultSet results = pstm.executeQuery();

            while (results.next()) {
                c.setName(results.getString("name"));
                c.setAddressline1(results.getString("addressline1"));
                c.setAddressline2(results.getString("addressline2"));
                c.setCity(results.getString("city"));
                c.setCustomerId(results.getInt("customer_id"));
                c.setDiscountCode(results.getString("discount_code"));
                c.setCreditLimit(results.getDouble("credit_limit"));
                c.setEmail(results.getString("email"));
                c.setFax(results.getString("fax"));
                c.setPhone(results.getString("phone"));
                c.setState(results.getString("state"));
                c.setZip(results.getString("zip"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerFind.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }
}
