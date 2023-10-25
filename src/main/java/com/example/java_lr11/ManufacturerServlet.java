package com.example.java_lr11;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "manufacturersServlet", value = "/manufacturersServlet")
public class ManufacturerServlet extends HttpServlet {

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
            String sql = "SELECT DISTINCT Manufacturer FROM `Car`";
            ResultSet res = statement.executeQuery(sql);
            List<String>manufacturers = new ArrayList<>();
            while (res.next()){
                String manufacturer = res.getString("manufacturer");
                manufacturers.add(manufacturer);
            }
            request.setAttribute("manufacturers",manufacturers);
            request.getRequestDispatcher("/manufacturers.jsp").forward(request,response);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }

    }

    public void destroy() {
    }
}