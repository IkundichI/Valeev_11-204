package ru.itis;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class GetMessagesServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String name = (String) session.getAttribute("name");
        if (name == null) {
            resp.sendRedirect("/name");
            return;
        }
        // Отображение сообщений на странице
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html><html><head><meta charset=\"UTF-8\"><title>Messages</title>");
        out.println("<style>body{font-family:Arial,sans-serif;margin:20px;}h1{color:#333;}ul{list-style-type:none;padding:0;}li{margin:10px 0;}a{text-decoration:none;background-color:#333;color:#fff;padding:5px 10px;border-radius:3px;}a:hover{background-color:#555;}</style>");
        out.println("</head><body><h1>Messages for " + name + "</h1><ul>");
        for (User user1: Users.users) {
            if (user1.getName().equals(name)) {
                for (String message: user1.getMessages()) {
                    out.println("<li>" + user1.getName() + " write your message: " + message +"</li>");
                }
            }
        }
        out.println("</ul><a href=\"http://localhost:8080/untitled/sendMessage\">Send a Message</a></body></html>");
        log(Users.users.toString());

    }
}