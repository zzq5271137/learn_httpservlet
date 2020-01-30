package com.mycomp.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.mycomp.domain.User;
import com.mycomp.utils.JDBCUtil;

@WebServlet("/login")
public class Login extends HttpServlet {

    protected void service(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("login...");
        PrintWriter writer = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        JDBCUtil.getDataSource();
        QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "select * from user where username = ? and password = ?";
        User user = null;
        try {
            user = runner.query(sql, new BeanHandler<User>(User.class),
                    username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (user != null) {
            writer.write("<h1>Login Success. User: " + username + ".</h1>");
        } else {
            writer.write("<h1>Login Fail.</h1>");
        }
    }

}
