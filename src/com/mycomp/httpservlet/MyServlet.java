package com.mycomp.httpservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/myservlet") // 需要将web.xml中的metadata-complete="true"改为"false"
public class MyServlet extends HttpServlet {

    /**
     * 每次请求的时候都会调用service方法
     * 
     * 一旦你写了service方法, 就不会再去找doGet或doPost方法了
     */
//    protected void service(HttpServletRequest request,
//            HttpServletResponse response)
//            throws ServletException, IOException {
//        System.out.println("service...");
//    }

    /**
     * 当get请求时会调用doGet方法
     */
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("doGet...");
    }

    /**
     * 当post请求时会调用doPost方法
     */
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("doPost...");
    }

}
