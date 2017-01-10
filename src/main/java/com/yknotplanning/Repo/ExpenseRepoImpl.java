package com.yknotplanning.Repo;

import com.yknotplanning.Model.CONSTANTS;
import com.yknotplanning.Model.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by justinb on 1/10/2017.
 */

@Repository
public class ExpenseRepoImpl implements ExpenseRepo {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<Expense> findAll() {
        return jdbcTemplate.query(CONSTANTS.FIND_ALL, new ExpenseRowMapper());
    }

    @Override
    public List<Expense> findByDateStartingWith(String purchaseDate, String orderBy) {
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("purchaseDate", purchaseDate+"%");
        params.put("orderBy", orderBy);

        return namedParameterJdbcTemplate.query(CONSTANTS.FIND_ALL_BY_MONTH,params,new ExpenseRowMapper());
    }

    @Override
    public void save(List<Expense> expenses) {

            for(Expense expense : expenses){

                if(expense.getId() > 0)
                    jdbcTemplate.update(CONSTANTS.UPDATE_EXPENSE,expense.getMerchantName(),expense.getDescription(),
                            expense.getCategory(),expense.getAmount(),expense.getDate(),expense.getItem(),expense.getId());
                else
                    jdbcTemplate.update(CONSTANTS.INSERT_EXPENSE,expense.getMerchantName(),expense.getDescription(),
                            expense.getCategory(),expense.getAmount(),expense.getDate(),expense.getItem());
            }
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update(CONSTANTS.REMOVE_EXPENSE,id);
    }

    @Override
    public void create(){
        jdbcTemplate.update(CONSTANTS.CREATE_EXPENSE);
    }
}
