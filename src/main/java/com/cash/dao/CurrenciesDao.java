package com.cash.dao;

import com.cash.model.Currencies;

import java.sql.SQLException;
import java.util.List;

public interface CurrenciesDao {

    List<Currencies> getAll() throws SQLException, ClassNotFoundException;

    Currencies getByCode(String code) throws SQLException, ClassNotFoundException;
    Currencies getById(int id) throws SQLException, ClassNotFoundException;

    void add(Currencies currencies) throws SQLException, ClassNotFoundException;
    void edit(Currencies currencies) throws SQLException, ClassNotFoundException;
    void remove(int id) throws SQLException, ClassNotFoundException;

    boolean existByCode(String code) throws SQLException, ClassNotFoundException;


}
