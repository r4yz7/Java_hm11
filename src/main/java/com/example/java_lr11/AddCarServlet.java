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

@WebServlet(name = "addCarServlet", value = "/addCarServlet")
public class AddCarServlet extends HttpServlet {

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

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        getServletContext().getRequestDispatcher("/addCarForm.jsp").forward(request,response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        response.setContentType("text/html");
        try {
            String mod = request.getParameter("model");
            String manuf = request.getParameter("manufacturer");
            String engine = request.getParameter("engine");
            String year = request.getParameter("year");
            String col = request.getParameter("color");
            String type = request.getParameter("type");
            String sql = "INSERT INTO `Car`(`model`, `manufacturer`, `engineVolume`, `yearProduction`, `color`, `carType`) VALUES (?,?,?,?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,mod);
            preparedStatement.setString(2,manuf);
            preparedStatement.setString(3, String.valueOf(Double.parseDouble(engine)));
            preparedStatement.setString(4, String.valueOf(Integer.parseInt(year)));
            preparedStatement.setString(5,col);
            preparedStatement.setString(6,type);
            int rowsInserted = preparedStatement.executeUpdate();
            if(rowsInserted>0){
                response.sendRedirect("/index.jsp");
            }
            else{
                response.sendRedirect("/addCarForm.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void destroy() {
    }
}