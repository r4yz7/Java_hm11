package com.example.java_lr11;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "carCountServlet", value = "/carCountServlet")
public class CarCountServlet extends HttpServlet {

    Connection conn;
    Statement statement;
    public void init() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/carsDb","root","");
            statement = conn.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            String sql = "SELECT Manufacturer, COUNT(*) AS CarCount FROM Car GROUP BY Manufacturer;";
            ResultSet res = statement.executeQuery(sql);
            HashMap<String,Integer> manCount = new HashMap<>();
            while (res.next()){
                String manufacturer = res.getString("manufacturer");
                int carCount = res.getInt("CarCount");
                manCount.put(manufacturer,carCount);
            }
            request.setAttribute("manCount",manCount);
            request.getRequestDispatcher("/manufacturersCount.jsp").forward(request,response);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }

    }

    public void destroy() {
    }
}