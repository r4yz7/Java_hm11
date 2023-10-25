package com.example.java_lr11;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "carsServlet", value = "/carsServlet")
public class CarsServlet extends HttpServlet {

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
            String sql = "SELECT * FROM `Car`";
            ResultSet res = statement.executeQuery(sql);
            List<Car>cars = new ArrayList<>();
            while (res.next()){
                int id = res.getInt("id");
                String model = res.getString("model");
                String manufacturer = res.getString("manufacturer");
                double engineVolume = res.getDouble("engineVolume");
                int yearProduction = res.getInt("yearProduction");
                String color = res.getString("color");
                String carType = res.getString("carType");
                Car car = new Car(id,model,manufacturer,engineVolume,yearProduction,color,carType);
                cars.add(car);
            }
            request.setAttribute("cars",cars);
            request.getRequestDispatcher("/cars.jsp").forward(request,response);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }

    }

    public void destroy() {
    }
}