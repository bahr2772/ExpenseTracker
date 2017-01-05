package com.yknotplanning.Model;

import java.util.ArrayList;
import java.util.List;


public class Record {

    private List<Expense> expenses = new ArrayList<Expense>();

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }

}