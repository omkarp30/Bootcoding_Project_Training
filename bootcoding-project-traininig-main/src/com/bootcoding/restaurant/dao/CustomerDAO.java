package com.bootcoding.restaurant.dao;

import com.bootcoding.restaurant.Customer;

import java.sql.*;

public class CustomerDAO {

    public static final String TABLE_NAME = "app_customer";

    private DAOService daoService;

    public CustomerDAO() {
        daoService = new DAOService();
    }

    public void insertCustomer(Customer customer) {
        try {
            Connection con = daoService.getConnection();
            String sql = "INSERT INTO " + TABLE_NAME
                    + " VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setLong(1, customer.getCustomerId());
            pst.setString(2, customer.getName());
            pst.setString(3, customer.getCity());
            pst.setLong(4,customer.getCustomerId());
            pst.setString(5, customer.getAddress());
            pst.setString(6, customer.getState());
            pst.setString(7, customer.getEmailId());
            pst.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createTable() {
        try {

            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");

            Statement stmt = con.createStatement();
            String query = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME
                    + " ( id bigint NOT NULL, "
                    + " name text ,"
                    + " address text, "
                    + " phone_number bigint, "
                    + " city text , "
                    + " state text, "
                    + " email_id text, "
                    + " CONSTRAINT app_customer_pk PRIMARY KEY (id))";

            System.out.println("Create Table Query : " + query);
            stmt.executeUpdate(query);
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
