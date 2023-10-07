package ru.itis;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class NameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter printWriter = resp.getWriter();
        printWriter.println("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Beautiful Page</title>\n" +
                "    <style>\n" +
                "        body {\n" +
                "            font-family: Arial, sans-serif;\n" +
                "            background-color: #f0f0f0;\n" +
                "            margin: 0;\n" +
                "            padding: 0;\n" +
                "            display: flex;\n" +
                "            justify-content: center;\n" +
                "            align-items: center;\n" +
                "            height: 100vh;\n" +
                "        }\n" +
                "        \n" +
                "        form {\n" +
                "            background-color: #ffffff;\n" +
                "            padding: 20px;\n" +
                "            border-radius: 10px;\n" +
                "            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.2);\n" +
                "        }\n" +
                "\n" +
                "        label {\n" +
                "            font-weight: bold;\n" +
                "        }\n" +
                "\n" +
                "        input[type=\"text\"] {\n" +
                "            width: 100%;\n" +
                "            padding: 10px;\n" +
                "            margin-bottom: 10px;\n" +
                "            border: 1px solid #ccc;\n" +
                "            border-radius: 5px;\n" +
                "        }\n" +
                "\n" +
                "        input[type=\"text\"]:focus {\n" +
                "            outline: none;\n" +
                "            border-color: #007BFF;\n" +
                "        }\n" +
                "\n" +
                "        input[type=\"submit\"] {\n" +
                "            background-color: #007BFF;\n" +
                "            color: #fff;\n" +
                "            border: none;\n" +
                "            padding: 10px 20px;\n" +
                "            border-radius: 5px;\n" +
                "            cursor: pointer;\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <form method=\"post\" action=\"/untitled/name\">\n" +
                "        <label for=\"username\">Input your name:</label>\n" +
                "        <input type=\"text\" id=\"username\" name=\"username\" placeholder=\"Enter name\">\n" +
                "        <input type=\"submit\" value=\"Submit\">\n" +
                "    </form>\n" +
                "</body>\n" +
                "</html>\n");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        BufferedReader reader = req.getReader();
        String name = reader.readLine().split("=")[1];
        httpSession.setAttribute("name", name);
        User user = User.builder().name(name).messages(new ArrayList<>()).build();
        Users.users.add(user);
        resp.sendRedirect("http://localhost:8080/untitled/sendMessage");
    }
}
