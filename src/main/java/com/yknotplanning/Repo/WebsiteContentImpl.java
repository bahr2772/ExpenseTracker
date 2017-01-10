package com.yknotplanning.Repo;

import com.yknotplanning.Model.CONSTANTS;
import com.yknotplanning.Model.Webcontent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by justinb on 1/10/2017.
 */
@Repository
public class WebsiteContentImpl implements WebsiteContent {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Webcontent> getAllContent() {
        return jdbcTemplate.query(CONSTANTS.GET_ALL_WEBCONTENT, new WebcontentRowMapper());
    }

    @Override
    public List<Webcontent> getContentByProp(String prop) {
        return jdbcTemplate.query(CONSTANTS.GET_ALL_BY_PROP, new WebcontentRowMapper(), prop);
    }

    @Override
    public void saveContent(String prop, String value) {
            jdbcTemplate.update(CONSTANTS.UPDATE_WEBCONTENT,prop, value);
    }
}
