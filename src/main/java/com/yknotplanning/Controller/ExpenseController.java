package com.yknotplanning.Controller;

import com.yknotplanning.Model.Expense;
import com.yknotplanning.Model.Record;
import com.yknotplanning.Repo.CRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;


@Controller
public class ExpenseController {

    @Autowired
    private CRUD crud;

    @RequestMapping(value = "expenses", method = RequestMethod.GET)
    public String getExpensesList(final Model model) {
        Record record = getRecordContent();
        model.addAttribute("record", record);
        return "record";
    }

    @RequestMapping(value = "expenses", params = {"addExpense"})
    public String addProduct(@ModelAttribute Record record, final Model model, HttpServletRequest request) {
        record.getExpenses().add(new Expense());
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
        record = getRecordContent();
        model.addAttribute("record", record);
        model.addAttribute("deleted", "deleted");

        return "record";
    }

    @RequestMapping(value = "expenses", params = {"saveList"})
    public String saveList(@ModelAttribute Record record, final Model model, final HttpServletRequest request) {
        save(request, record);
        record.getExpenses().clear();
        record = getRecordContent();
        model.addAttribute("record", record);
        return "record";
    }

    public Record getRecordContent() {
        Record record = new Record();

        for (Expense expense : crud.findAll()) {
            record.getExpenses().add(expense);
        }
        return record;
    }


    public void save(HttpServletRequest request, Record record) {

        try {
            int i = 0;
            while (request.getParameterValues("expenses[" + i + "].merchantName") != null) {
                Expense expense = new Expense();

               // expense.setId(Integer.parseInt(request.getParameter("expenses[" + i + "].id")));
                expense.setMerchantName(request.getParameter("expenses[" + i + "].merchantName"));
                expense.setItem(request.getParameter("expenses[" + i + "].item"));
                expense.setDescription(request.getParameter("expenses[" + i + "].description"));
                String value = request.getParameter("expenses[" + i + "].amount");
                expense.setDate(request.getParameter("expenses[" + i + "].date"));

                BigDecimal money = new BigDecimal(value.replaceAll(",", ""));

                expense.setAmount(money);

                record.getExpenses().add(expense);
                i++;
            }
            crud.save(record.getExpenses());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}