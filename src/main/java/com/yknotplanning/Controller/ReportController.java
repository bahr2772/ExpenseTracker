package com.yknotplanning.Controller;

import com.yknotplanning.Helper.GetReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by justinb on 1/11/2017.
 */
@Controller
public class ReportController {

    @Autowired
    private GetReport getReport;

    @RequestMapping("/report")
    public String getReport(final Model model){
        getReport.getReport(model);
        return "report";
    }





}
