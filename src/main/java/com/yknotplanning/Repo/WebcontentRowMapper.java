package com.yknotplanning.Repo;

import com.yknotplanning.Model.Webcontent;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by justinb on 1/10/2017.
 */
public class WebcontentRowMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int i) throws SQLException {
        Webcontent webcontent = new Webcontent();
        webcontent.setProperty(rs.getString("property"));
        webcontent.setValue(rs.getString("value"));
        return webcontent;




    }
}
