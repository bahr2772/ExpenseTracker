package com.yknotplanning.Controller;

import com.yknotplanning.Model.Expense;
import com.yknotplanning.Model.Record;
import com.yknotplanning.Repo.CRUD;
import com.yknotplanning.Util.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.ArrayList;

@SessionAttributes("month")
@Controller
public class ExpenseController {

    @Autowired
    private CRUD crud;


    @RequestMapping(value = "expenses", method = RequestMethod.GET)
    public String getExpensesList(final Model model, HttpServletRequest request) {

        String month = Helper.rNull(request.getParameter("month"));

        Record record;
        if (month.equals(""))
            record = getRecordContent(model);
        else
            record = getRecordContentByMonth(month, model);

        getContent(model);
        model.addAttribute("month", month);
        model.addAttribute("monthLabel", Helper.getMonthName(month));
        model.addAttribute("record", record);
        return "record";
    }

    @RequestMapping(value = "expenses", params = {"addExpense"})
    public String addProduct(@ModelAttribute Record record, final Model model, HttpServletRequest request) {
        record.getExpenses().add(new Expense());

        getContent(model);
        model.addAttribute("record", record);
        model.addAttribute("added", "added");
        crud.save(record.getExpenses());
        //save(request,record);
        return "record";
    }

    @RequestMapping(value = "expenses", params = {"deleteExpense"})
    public String deleteProduct(@ModelAttribute Record record, final Model model, final HttpServletRequest request) {

        final Integer expenseId = Integer.valueOf(request.getParameter("deleteExpense"));
        Expense expense = record.getExpenses().get(expenseId);
        System.out.println("Deleted: " + expense.toString());

        crud.delete(expense.getId());
        record.getExpenses().clear();
        record = getRecordContent(model);
        model.addAttribute("record", record);
        model.addAttribute("deleted", "deleted");

        return "record";
    }

    @RequestMapping(value = "expenses", params = {"saveList"})
    public String saveList(@ModelAttribute Record record, final Model model, final HttpServletRequest request) {
        String month = Helper.rNull(request.getParameter("month"));
        crud.save(record.getExpenses());
        model.addAttribute("save", "save");
        model.addAttribute("record", record);

        System.out.println(month);
        model.addAttribute("month", month);
        return "redirect:/expenses?month=" + month;
    }

    public Record getRecordContent(Model model) {
        Record record = new Record();
        BigDecimal total = new BigDecimal(0.00);

        for (Expense expense : crud.findAll()) {
            record.getExpenses().add(expense);
            total = total.add(expense.getAmount());

        }
        model.addAttribute("total", total);

        return record;
    }

    public void getContent(Model model) {
        ArrayList<String> mechNames = new ArrayList<String>();
        ArrayList<String> items = new ArrayList<String>();
        ArrayList<String> cats = new ArrayList<String>();

        for (Expense expense : crud.findAll()) {
            mechNames.add(expense.getMerchantName());
            items.add(expense.getItem());
            cats.add(expense.getCategory());
        }

        model.addAttribute("mechNames", mechNames);
        model.addAttribute("itemList", items);
        model.addAttribute("cats", cats);
    }


    public Record getRecordContentByMonth(String month, Model model) {
        Record record = new Record();
        BigDecimal total = new BigDecimal(0.00);
        for (Expense expense : crud.findByDateStartingWith(month)) {
            record.getExpenses().add(expense);
            total = total.add(expense.getAmount());
        }
        model.addAttribute("total", total);
        return record;
    }


}