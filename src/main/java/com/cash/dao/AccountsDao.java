package com.cash.dao;

import com.cash.model.Accounts;

import java.sql.SQLException;
import java.util.List;

public interface AccountsDao {

    List<Accounts> getAll() throws SQLException, ClassNotFoundException;
    Accounts getAccounts(int id) throws SQLException, ClassNotFoundException;

    void setLocked(int id, int locked) throws SQLException, ClassNotFoundException;
    void deleteAccount(int id) throws SQLException, ClassNotFoundException;

    void edit(Accounts accounts) throws SQLException, ClassNotFoundException;

}
