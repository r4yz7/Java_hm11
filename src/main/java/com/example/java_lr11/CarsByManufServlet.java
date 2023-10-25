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

@WebServlet(name = "carsByManufServlet", value = "/carsByManufServlet")
public class CarsByManufServlet extends HttpServlet {

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
        getServletContext().getRequestDispatcher("/carManufacturer.jsp").forward(request,response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        response.setContentType("text/html");
        try {
            String manuf = request.getParameter("manufacturer");
            String sql = "SELECT * FROM Car Where Car.manufacturer = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,manuf);
            ResultSet res = preparedStatement.executeQuery();
            List<Car> cars = new ArrayList<>();
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
            e.printStackTrace();
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
    }

    public void destroy() {
    }
}