package com.cash.servlet.registerdb;

import com.cash.core.SqliteConnection;
import com.cash.service.UserService;
import com.cash.service.UserServiceImpl;
import com.cash.core.DbController;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*

    for creating empty database on the start

 */

@Log4j
@WebServlet("/generate-template-database")
public class CreateTemplateDBServlet extends HttpServlet {

    private static UserService userService;

    @Override
    public void init() throws ServletException {
        userService = new UserServiceImpl();
        super.init();
    }

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        req.setCharacterEncoding("UTF-8");

        DbController dbController = DbController.getInstance();
        dbController.setDefault();
        dbController.remove();
        dbController.create();

        // set connection with database
        SqliteConnection sq = SqliteConnection.getInstance();
        sq.setUrl(dbController.getDbFileAbsolutePath());

        resp.sendRedirect(req.getContextPath() + "/account");
    }
}
