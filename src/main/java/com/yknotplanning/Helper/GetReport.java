package com.yknotplanning.Helper;

import com.yknotplanning.Model.CONSTANTS;
import com.yknotplanning.Model.Expense;
import com.yknotplanning.Model.Report;
import com.yknotplanning.Model.Webcontent;
import com.yknotplanning.Repo.ExpenseRepo;
import com.yknotplanning.Repo.WebsiteContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bahr2772 on 1/11/17.
 */

@Component
public class GetReport {


    @Autowired
    private ExpenseRepo expenseRepo;

    @Autowired
    private WebsiteContent websiteContent;


    public void getReport(Model model) {

        Report report;

        List<Object> reportList = new ArrayList<>();

        List<Expense> expenseList = expenseRepo.findAll();
        List<Webcontent> catList = websiteContent.getContentByProp(CONSTANTS.CATEGORY);

        ArrayList<Object> category = new ArrayList<>();

        /*for (Webcontent webcontent : catList) {
            category.add(webcontent.getValue());
            category.add(category);
        }
*/
        BigDecimal yearTotal = new BigDecimal(0.00);

        for (int i = 0; i < catList.size(); i++) {
            report = new Report();

            if (!catList.get(i).getValue().equals("")) {
                BigDecimal total = BigDecimal.ZERO;
                for (int j = 0; j < expenseList.size(); j++) {
                    if (catList.get(i).getValue().equals(expenseList.get(j).getCategory()))
                        total = total.add(expenseList.get(j).getAmount());
                }

                yearTotal = yearTotal.add(total);
                report.setHeader(catList.get(i).getValue());
                report.setTotal(total);
                reportList.add(report);
            }
        }

        model.addAttribute("report", reportList);
        model.addAttribute("yearTotal", yearTotal);

    }


}
