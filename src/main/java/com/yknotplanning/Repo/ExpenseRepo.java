package com.yknotplanning.Repo;

import com.yknotplanning.Model.Expense;

import java.util.List;

/**
 * Created by bahr2772 on 1/3/17.
 */


public interface ExpenseRepo {

    public List<Expense> findAll();

    public List<Expense> findByDateStartingWith(String date, String orderBy);

    void save(List<Expense> expenses);

    void delete(int id);

    void create();
}
