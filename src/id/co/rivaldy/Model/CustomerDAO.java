/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.rivaldy.Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author RomyRivaldy
 */
public class CustomerDAO {
    public static List<Customer> getCustomers() throws SQLException{
        Connection conn = CustomerDB.connectToDatabase();
        
        Statement stat = conn.createStatement();
        ResultSet result = stat.executeQuery("SELECT * FROM CUSTOMER");
        List<Customer> customers = new ArrayList<>();
        while(result.next()){
            Customer c = new Customer();
            c.setName(result.getString("name"));
            c.setAddressline1(result.getString("addressline1"));
            c.setAddressline2(result.getString("addressline2"));
            c.setCity(result.getString("city"));
            c.setCustomerId(result.getInt("customer_id"));
            c.setDiscountCode(result.getString("discount_code"));
            c.setCreditLimit(result.getDouble("credit_limit"));
            c.setEmail(result.getString("email"));
            c.setFax(result.getString("fax"));
            c.setPhone(result.getString("phone"));
            c.setState(result.getString("state"));
            c.setZip(result.getString("zip"));
            customers.add(c);
        }
        return customers;
    }
}
