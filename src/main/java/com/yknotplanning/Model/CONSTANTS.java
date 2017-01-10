package com.yknotplanning.Model;

/**
 * Created by justinb on 1/9/2017.
 */
public class CONSTANTS {

    public static final String FIND_ALL = "SELECT * FROM expense";
    public static final String FIND_ALL_BY_MONTH = "SELECT * FROM expense WHERE purchaseDate like :purchaseDate ORDER BY :orderBy";
    public static final String CREATE_EXPENSE = "INSERT INTO expense VALUES ()";
    public static final String UPDATE_EXPENSE = "UPDATE expense SET merchant_name=?, description=?, category=?, amount=?, purchaseDate=?, item=? WHERE id=?";
    public static final String INSERT_EXPENSE = "INSERT INTO expense (merchant_name, description, category, amount, purchaseDate, item) VALUES (?,?,?,?,?,?)";
    public static final String REMOVE_EXPENSE = "DELETE FROM expense WHERE id=?";
}
