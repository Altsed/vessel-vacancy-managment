package com.altsed.testdb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

@WebServlet(name = "/TestDbPostgreSqlServlet", urlPatterns =  "/TestDbPostgreSqlServlet")
public class TestDbPostgreSqlServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //setup variables
        String user = "springstudent";
        String password = "springstudent";
        String jdbcUrl = "jdbc:postgresql://localhost:5432/web_vessels_vacancies?useSSL=false&serverTimezone=UTC";
        String driver = "com.mysql.cj.jdbc.Driver";
       //get connection to DB

        try{
            PrintWriter out = response.getWriter();
            out.println("Connecting to database...");
            /*
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(jdbcUrl, user, password);
            out.println("Connection success!");
            connection.close();
*/
            String url = "jdbc:postgresql://localhost:5432/web_vessels_vacancies";
            Properties props = new Properties();
            props.setProperty("user","springstudent");
            props.setProperty("password","springstudent");
            props.setProperty("ssl","false");
            Connection connection = DriverManager.getConnection(url, props);
            out.println("Connection success!");
            connection.close();

        }catch (Exception exc){
            exc.printStackTrace();
            throw new ServletException();
        }
    }
}
