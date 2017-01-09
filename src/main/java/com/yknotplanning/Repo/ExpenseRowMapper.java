package com.yknotplanning.Repo;

import com.yknotplanning.Model.Expense;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by justinb on 1/9/2017.
 */
public class ExpenseRowMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int i) throws SQLException {
        Expense expense = new Expense();
        expense.setId(rs.getInt("id"));
        expense.setItem(rs.getString("item"));
        expense.setAmount(rs.getBigDecimal("amount"));
        expense.setCategory(rs.getString("category"));
        expense.setDate(rs.getString("purchaseDate"));
        expense.setDescription(rs.getString("description"));
        expense.setMerchantName(rs.getString("merchant_name"));
        System.out.println(expense);
        return expense;

    }
}
