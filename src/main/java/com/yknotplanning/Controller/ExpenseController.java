package com.yknotplanning.Controller;

import com.yknotplanning.Model.Expense;
import com.yknotplanning.Model.Record;
import com.yknotplanning.Model.Webcontent;
import com.yknotplanning.Repo.ExpenseRepo;
import com.yknotplanning.Repo.WebsiteContent;
import com.yknotplanning.Util.Helper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.*;

@SessionAttributes("month")
@Controller
public class ExpenseController {

    @Autowired
    private ExpenseRepo expenseRepo;

    @Autowired
    private WebsiteContent websiteContent;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "expenses", method = RequestMethod.GET)
    public String getExpensesList(final Model model, HttpServletRequest request, String month, String orderBy) {
        logger.debug("This is a debug message");
        logger.info("This is an info message");
        logger.warn("This is a warn message");
        logger.error("This is an error message");


        if (month == null)
            month = "0";
        if (orderBy == null)
            orderBy = "id DESC";

        String[] args = {month,orderBy};
        Record record = getContent(model,args);


        model.addAttribute("month", Helper.rNull(month));
        model.addAttribute("monthLabel", Helper.getMonthName(Helper.rNull((month))));
        model.addAttribute("record", record);
        return "record";
    }

    @RequestMapping(value = "expenses", params = {"addExpense"})
    public String addProduct(@ModelAttribute Record record, final Model model, HttpServletRequest request, String month, String year, String orderBy) {
        month = Helper.rNull(month);
        orderBy = Helper.rNull(orderBy);
        year = Helper.rNull(year);

        String[] args = {month,orderBy};
        expenseRepo.create();
        Expense expense = new Expense();
            expense.setDate(month + "/01/" + year);
            expense.setAmount(new BigDecimal(0.00));

        record.getExpenses().add(expense);
        expenseRepo.save(record.getExpenses());
        record = getContent(model, args);
        model.addAttribute("record", record);
        model.addAttribute("added", "added");
        return "redirect:/expenses?month="+month+"&orderBy="+orderBy;
    }

    @RequestMapping(value = "expenses", params = {"deleteExpense"})
    public String deleteProduct(@ModelAttribute Record record, final Model model, final HttpServletRequest request, String month, String orderBy) {
        month = Helper.rNull(month);
        orderBy = Helper.rNull(orderBy);

        String[] args = {month,orderBy};

        final Integer expenseId = Integer.valueOf(request.getParameter("deleteExpense"));
        Expense expense = record.getExpenses().get(expenseId);
        System.out.println("Deleted: " + expense.toString());

        expenseRepo.delete(expense.getId());
        record.getExpenses().clear();
        record = getContent(model,args);
        model.addAttribute("record", record);
        model.addAttribute("deleted", "deleted");

        return "record";
    }

    @RequestMapping(value = "expenses", params = {"saveList"})
    public String saveList(@ModelAttribute Record record, final Model model, final HttpServletRequest request) {
        String month = Helper.rNull(request.getParameter("month"));
        expenseRepo.save(record.getExpenses());
        model.addAttribute("save", "save");
        model.addAttribute("record", record);

        System.out.println(month);
        model.addAttribute("month", month);
        model.addAttribute("save", "save");
        return "redirect:/expenses?month=" + month;
    }


    public Record getContent(Model model, String[] args) {
        Record record = new Record();

        ArrayList<String> merchNames = new ArrayList<String>();
        ArrayList<String> items = new ArrayList<String>();
        BigDecimal total = new BigDecimal(0.00);

        List<Expense> expenseList = expenseRepo.findByDateStartingWith(args[0], args[1]);
        List<Webcontent> cats = websiteContent.getContentByProp("category");


        for (Expense expense : expenseList ) {
            record.getExpenses().add(expense);
            merchNames.add(expense.getMerchantName());
            items.add(expense.getItem());
            total = total.add(expense.getAmount());
        }

        model.addAttribute("total", total);
        model.addAttribute("merchNames", merchNames);
        model.addAttribute("itemList", items);
        model.addAttribute("cats", cats);

        return record;
    }



}