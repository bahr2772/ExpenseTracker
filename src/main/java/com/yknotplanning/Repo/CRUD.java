package com.yknotplanning.Repo;

import com.yknotplanning.Model.Expense;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by bahr2772 on 1/3/17.
 */

@Transactional
public interface CRUD extends CrudRepository<Expense, Integer> {

    public List<Expense> findAll();

    public List<Expense> findByDateStartingWith(String date);



}
