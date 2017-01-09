package com.yknotplanning.Util;

import com.yknotplanning.Model.Expense;
import com.yknotplanning.Model.Record;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by justinb on 1/9/2017.
 */
@Component
public class Content {
/*
    public Record getRecordContent(Model model, ExpenseRepo expenseRepo) {
        Record record = new Record();
        BigDecimal total = new BigDecimal(0.00);
        List<Expense> expenseList = expenseRepo.findAllExpenseslExpenses();

        for (Expense expense : expenseList) {
            record.getExpenses().add(expense);
            total = total.add(expense.getAmount());

        }
        model.addAttribute("total", total);
        model.addAttribute("record", expenseList);
        return record;
    }

    public void getContent(Model model, String month, ExpenseRepo expenseRepo, orderBy) {
        ArrayList<String> mechNames = new ArrayList<String>();
        ArrayList<String> items = new ArrayList<String>();
        ArrayList<String> cats = new ArrayList<String>();
        BigDecimal total = new BigDecimal(0.00);

        for (Expense expense : expenseRepo.findByDateStartingWith(month, orderBy)) {

            mechNames.add(expense.getMerchantName());
            items.add(expense.getItem());
            cats.add(expense.getCategory());
            total = total.add(expense.getAmount());
        }

        model.addAttribute("total", total);
        model.addAttribute("mechNames", mechNames);
        model.addAttribute("itemList", items);
        model.addAttribute("cats", cats);
    }


    public Record getRecordContentByMonth(String month, Model model, ExpenseRepo expenseRepo) {
        Record record = new Record();
        BigDecimal total = new BigDecimal(0.00);
        List<Expense> expenseList = expenseRepo.findByDateStartingWith(month);
        for (Expense expense : expenseList) {
            record.getExpenses().add(expense);
            total = total.add(expense.getAmount());
        }

        model.addAttribute("record", expenseList);
        model.addAttribute("total", total);
        return record;
    }



*/

}
