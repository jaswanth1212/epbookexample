package com.booksearch;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("BookServlet: doGet method called");
        
        String keyword = request.getParameter("keyword");
        System.out.println("Search keyword: " + keyword);
        
        List<Book> bookList = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookdb", "root", "Kishore2005+");
            System.out.println("Database connected successfully");
            
            PreparedStatement ps = con.prepareStatement("SELECT * FROM book WHERE bname LIKE ?");
            ps.setString(1, "%" + keyword + "%");
            System.out.println("Executing query: " + ps.toString());
            
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Book book = new Book();
                book.setBid(rs.getInt("bid"));
                book.setBname(rs.getString("bname"));
                book.setBprice(rs.getDouble("bprice"));
                bookList.add(book);
                System.out.println("Added book: " + book);
            }

            rs.close();
            ps.close();
            con.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Number of books retrieved: " + bookList.size());
        request.setAttribute("bookList", bookList);
        RequestDispatcher rd = request.getRequestDispatcher("bookSearch.jsp");
        rd.forward(request, response);
    }
}