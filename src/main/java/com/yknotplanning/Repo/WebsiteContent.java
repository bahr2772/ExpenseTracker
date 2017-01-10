package com.yknotplanning.Repo;

import com.yknotplanning.Model.Webcontent;

import java.util.List;

/**
 * Created by justinb on 1/10/2017.
 */
public interface WebsiteContent {

    List<Webcontent> getAllContent();
    List<Webcontent> getContentByProp(String prop);
    void saveContent(String prop, String value);


}
