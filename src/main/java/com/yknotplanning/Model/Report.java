package com.yknotplanning.Model;

import java.math.BigDecimal;

/**
 * Created by bahr2772 on 1/15/17.
 */


public class Report {
    private String header;

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    private BigDecimal total = new BigDecimal(0.00);


}
