package com.yknotplanning.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by justinb on 1/11/2017.
 */
@Controller
public class ReportController {


    @RequestMapping("/report")
    public String getReport(){

        return "report";
    }

}
