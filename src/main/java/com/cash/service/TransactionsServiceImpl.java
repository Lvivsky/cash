package com.cash.service;

import com.cash.dao.*;
import com.cash.model.*;
import lombok.extern.log4j.Log4j;
import java.sql.SQLException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Log4j
public class TransactionsServiceImpl implements TransactionsService {

    private static TransactionsDao transactionsDao;
    private static AccountsDao accountsDao;
    private static CategoriesDao categoriesDao;
    private static TransactionGroupsDao transactionGroupsDao;
    private static TransactionCategoriesDao transactionCategoriesDao;

    public TransactionsServiceImpl() {
        transactionsDao = new TransactionsDaoImpl();
        transactionGroupsDao = new TransactionGroupsDaoImpl();
        accountsDao = new AccountsDaoImpl();
        categoriesDao = new CategoriesDaoImpl();
        transactionCategoriesDao = new TransactionCategoriesDaoImpl();
    }

    @Override
    public List<Transactions> getAll() {
        try {
            log.info("getting all transaction");
            return transactionsDao.getAll();
        } catch (SQLException e) {
            log.error("SQLException | " + e.getMessage());
            return new ArrayList<>();
        } catch (ClassNotFoundException e) {
            log.error("ClassNotFoundException | " + e.getMessage());
            return new ArrayList<>();
        }
    }

    @Override
    public void addIncomeTransaction(String accountId, String operationState, String date, String categoryId, String balance, String comment) {
        try {
            Accounts accounts = accountsDao.getAccounts(Integer.parseInt(accountId));
            accounts.setChanged(String.valueOf(Instant.now().getEpochSecond()));

            TransactionGroups tg = new TransactionGroups();
            transactionGroupsDao.add(tg);
            int transactionGroups = transactionGroupsDao.getIdByGuid(tg.getGuid());

            Transactions transactions = new Transactions();

            transactions.setGroup(String.valueOf(transactionGroups));
            transactions.setComment(comment);

            transactions.setBudgetDate(String.valueOf(Instant.now().getEpochSecond()));
            transactions.setBudgetPeriodEnd(String.valueOf(Instant.now().getEpochSecond()));

            // Get info about balance
            int quantity = 10000;
            long fixedBalance = Long.parseLong(balance) * quantity;
            long fixedAccountBalance = Long.parseLong(accounts.getStartingBalance()) * quantity;
            long resultBalance = fixedAccountBalance + fixedBalance;
            accounts.setStartingBalance(String.valueOf(Math.round(resultBalance/quantity)));

            // Balance
            transactions.setIncomeAccount(accountId);
            transactions.setIncomeAmount(String.valueOf(fixedBalance));
            transactions.setIncomeBalance(String.valueOf(resultBalance));

            if (operationState.equals("1")) {
                transactions.setExecuted("1");
                transactions.setExecuted("0");
            } else if (operationState.equals("2")) {
                transactions.setExecuted("1");
                transactions.setLocked("1");
            } else if (operationState.equals("3")) {
                transactions.setExecuted("0");
                transactions.setLocked("0");
            }

            transactionsDao.add(transactions);
            accountsDao.edit(accounts);

            TransactionCategories tr = new TransactionCategories(
                    String.valueOf(categoryId),
                    String.valueOf(transactionsDao.getIdByGuid(transactions.getGuid())));
            tr.setCategory(String.valueOf(categoryId));
            transactionCategoriesDao.add(tr);

        } catch (SQLException e) {
            log.error("SQLException | " + e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            log.error("ClassNotFoundException | " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void addOutcomeTransaction(String accountId, String operationState, String date, String categoryId, String balance, String comment) {
        try {
            Accounts accounts = accountsDao.getAccounts(Integer.parseInt(accountId));
            accounts.setChanged(String.valueOf(Instant.now().getEpochSecond()));

            TransactionGroups tg = new TransactionGroups();
            transactionGroupsDao.add(tg);
            int transactionGroups = transactionGroupsDao.getIdByGuid(tg.getGuid());

            Transactions transactions = new Transactions();

            transactions.setGroup(String.valueOf(transactionGroups));
            transactions.setComment(comment);

            transactions.setBudgetDate(String.valueOf(Instant.now().getEpochSecond()));
            transactions.setBudgetPeriodEnd(String.valueOf(Instant.now().getEpochSecond()));

            // Get info about balance
            int quantity = 10000;
            long fixedBalance = Long.parseLong(balance) * quantity;
            long fixedAccountBalance = Long.parseLong(accounts.getStartingBalance()) * quantity;
            long resultBalance = fixedAccountBalance - fixedBalance;
            accounts.setStartingBalance(String.valueOf(Math.round(resultBalance/quantity)));

            // Balance
            transactions.setExpenseAccount(accountId);
            if (fixedBalance < 0)
                transactions.setExpenseAmount(String.valueOf(fixedBalance));
            else transactions.setExpenseAmount("-".concat(String.valueOf(fixedBalance)));
            transactions.setExpenseBalance(String.valueOf(resultBalance));

            if (operationState.equals("1")) {
                transactions.setExecuted("1");
                transactions.setExecuted("0");
            } else if (operationState.equals("2")) {
                transactions.setExecuted("1");
                transactions.setLocked("1");
            } else if (operationState.equals("3")) {
                transactions.setExecuted("0");
                transactions.setLocked("0");
            }

            transactionsDao.add(transactions);
            accountsDao.edit(accounts);

            TransactionCategories tr = new TransactionCategories(
                    String.valueOf(categoryId),
                    String.valueOf(transactionsDao.getIdByGuid(transactions.getGuid())));
            tr.setCategory(String.valueOf(categoryId));
            transactionCategoriesDao.add(tr);

        } catch (SQLException e) {
            log.error("SQLException | " + e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            log.error("ClassNotFoundException | " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public List<Transactions> getTransactionsIncomeAccount(int id) {
        try {
            List<Transactions> transactions = transactionsDao.getByIncomeAccount(id);
            for (Transactions t: transactions) {
                Accounts accounts = accountsDao.getAccounts(Integer.parseInt(t.getIncomeAccount()));
                if (accounts.getDeleted().equals("1")) {
                    transactions.remove(t);
                } else {
                    t.setIncomeAccount(accounts.getName());
                }
            }
            return transactions;
        } catch (SQLException e) {
            log.error("SQLException | " + e.getMessage());
            e.printStackTrace();
            return new ArrayList<>();
        } catch (ClassNotFoundException e) {
            log.error("ClassNotFoundException | " + e.getMessage());
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public List<Transactions> getTransactionsExpanseAccount(int id) {
        try {
            List<Transactions> transactions = transactionsDao.getByExpenseAccount(id);
            for (Transactions t: transactions) {
                Accounts accounts = accountsDao.getAccounts(Integer.parseInt(t.getIncomeAccount()));
                if (accounts.getDeleted().equals("1")) {
                    transactions.remove(t);
                } else {
                    t.setIncomeAccount(accounts.getName());
                }
            }
            return transactions;
        } catch (SQLException e) {
            log.error("SQLException | " + e.getMessage());
            e.printStackTrace();
            return new ArrayList<>();
        } catch (ClassNotFoundException e) {
            log.error("ClassNotFoundException | " + e.getMessage());
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public List<Transactions> getByIncomeAccount(String accId) {
        try {
            List<Transactions> transactions = transactionsDao.getByIncomeAccount(Integer.parseInt(accId));
            for (Transactions t: transactions) {
                TransactionCategories tc = transactionCategoriesDao.getByTransactionId(String.valueOf(t.getId()));
                Categories categories = categoriesDao.getCategoryById(Integer.parseInt(tc.getCategory()));
                t.setIncomeAmount(String.valueOf(
                        Math.round(Float.parseFloat(t.getIncomeAmount())/Float.parseFloat(t.getQuantity()))
                ));

                t.setIncomeBalance(String.valueOf(
                        Math.round(Float.parseFloat(t.getIncomeBalance())/ Float.parseFloat(t.getQuantity()))
                ));
                t.setExtraComment1(categories.getName());
            }
            return transactions;
        } catch (SQLException e) {
            log.error("SQLException | " + e.getMessage());
            e.printStackTrace();
            return new ArrayList<>();
        } catch (ClassNotFoundException e) {
            log.error("ClassNotFoundException | " + e.getMessage());
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public List<Transactions> getByExpanseAccount(String accId) {
        try {
            List<Transactions> transactions = transactionsDao.getByExpenseAccount(Integer.parseInt(accId));
            for (Transactions t: transactions) {
                TransactionCategories tc = transactionCategoriesDao.getByTransactionId(String.valueOf(t.getId()));
                Categories categories = categoriesDao.getCategoryById(Integer.parseInt(tc.getCategory()));

                t.setExpenseAmount(
                        String.valueOf(
                            Math.round(
                                Float.parseFloat(t.getExpenseAmount())/Float.parseFloat(t.getQuantity()))
                ));

                t.setExpenseBalance(String.valueOf(
                        Math.round(Float.parseFloat(t.getExpenseBalance())/ Float.parseFloat(t.getQuantity()))
                ));
                t.setExtraComment1(categories.getName());
            }
            return transactions;
        } catch (SQLException e) {
            log.error("SQLException | " + e.getMessage());
            e.printStackTrace();
            return new ArrayList<>();
        } catch (ClassNotFoundException e) {
            log.error("ClassNotFoundException | " + e.getMessage());
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public List<Transactions> getByIncomeAccountAndStateRecursive(String accId, String stateId) {
        return null;
    }

    @Override
    public List<Transactions> getByExpenseAccountAndStateRecursive(String accId, String stateId) {
        return null;
    }

}
