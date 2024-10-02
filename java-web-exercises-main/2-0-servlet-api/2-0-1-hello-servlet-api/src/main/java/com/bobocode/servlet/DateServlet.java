package com.bobocode.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

@WebServlet("/date") // Мапуємо сервлет на шлях "/date"
public class DateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/plain"); // Встановлюємо тип контенту

        PrintWriter out = response.getWriter();
        out.println(LocalDate.now().toString()); // Повертаємо поточну дату
    }
}
