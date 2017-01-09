package com.yknotplanning.Model;

/**
 * Created by justinb on 1/9/2017.
 */
public class CONSTANTS {

    public static final String CREATE_EXPENSE = "INSERT INTO expense VALUES ()";
    public static String UPDATE_EXPENSE = "UPDATE expense SET merchant_name=?, description=?, category=?, amount=?, purchaseDate=?, item=? WHERE id=?";
    public static String INSERT_EXPENSE = "INSERT INTO expense (merchant_name, description, category, amount, purchaseDate, item) VALUES (?,?,?,?,?,?)";
}
