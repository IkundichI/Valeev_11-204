package ru.itis;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class SendMessageServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String name = (String) session.getAttribute("name");
        if (name == null) {
            resp.sendRedirect("http://localhost:8080/untitled/name");
            return;
        }
        PrintWriter printWriter = resp.getWriter();
        printWriter.println("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Message Form</title>\n" +
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
                "\n" +
                "        form {\n" +
                "            background-color: #ffffff;\n" +
                "            padding: 20px;\n" +
                "            border-radius: 10px;\n" +
                "            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.2);\n" +
                "            width: 400px;\n" +
                "            margin: 0 auto;\n" +
                "        }\n" +
                "\n" +
                "        label {\n" +
                "            font-weight: bold;\n" +
                "            display: block; \n" +
                "            margin-bottom: 5px;\n" +
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
                "        .button-container {\n" +
                "            display: flex;\n" +
                "            justify-content: space-between;\n" +
                "            margin-top: 10px; \n" +
                "        }\n" +
                "\n" +
                "        input[type=\"submit\"], a.button {\n" +
                "            text-decoration: none;\n" +
                "            background-color: #007BFF;\n" +
                "            color: #fff;\n" +
                "            border: none;\n" +
                "            padding: 10px 20px;\n" +
                "            border-radius: 5px;\n" +
                "            cursor: pointer;\n" +
                "            width: 48%;\n" +
                "            display: flex;\n" +
                "            justify-content: center;\n" +
                "            align-items: center;\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <form method=\"post\" action=\"/untitled/sendMessage\">\n" +
                "        <label for=\"name\">Name:</label>\n" +
                "        <input type=\"text\" id=\"name\" name=\"username\" placeholder=\"Enter name\"><br>\n" +
                "        <label for=\"message\">Message:</label>\n" +
                "        <input type=\"text\" id=\"message\" name=\"message\" placeholder=\"Enter message\"><br>\n" +
                "        <div class=\"button-container\">\n" +
                "            <input type=\"submit\" value=\"Send\">\n" +
                "            <a href=\"http://localhost:8080/untitled/getMessages\" class=\"button\">Get</a>\n" +
                "        </div>\n" +
                "    </form>\n" +
                "</body>\n" +
                "</html>\n");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String senderName = (String) session.getAttribute("name");
        if (senderName == null) {
            resp.sendRedirect("http://localhost:8080/untitled/name");
            return;
        }
        if (!Users.findUser(senderName)) {
            Users.users.add(new User(senderName, new ArrayList<>()));
        }
        String recipientName = req.getParameter("username");
        log( recipientName);
        String message = req.getParameter("message");
        log( message);
        for (User user : Users.users) {
            if (user.getName().equals(recipientName)) {
                log("1" + Users.users.toString());
                user.addMessage(message);
            }
        }
        resp.sendRedirect("http://localhost:8080/untitled/sendMessage");
    }

}