package com.bootcoding.restaurant.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class VendorDAO {

    public static final String TABLE_NAME = "app_vendor";

    public void createTable(){
        try{

            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","postgres");
            Statement stmt = con.createStatement();
            String query = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME
                    + " ( id bigint NOT NULL, "
                    + " name text ,"
                    + " address text, "
                    + " phone_number bigint, "
                    + " city text , "
                    + " state text, "
                    + " email_id text, "
                    + " category text, "
                    + " CONSTRAINT app_vendor_pk PRIMARY KEY (id))";

            System.out.println("Create Table Query : " + query);
            stmt.executeUpdate(query);
            con.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
