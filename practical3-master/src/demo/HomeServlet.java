package demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "HomeServlet", urlPatterns = "/bookstore")
public class HomeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            PrintWriter out = response.getWriter();
            out.println(getContent());
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
    }

    private String getContent() throws Exception {
        BookDBAO db = new BookDBAO();
        BookDetails bd = db.getBookDetails("203");
        StringBuilder buffer = new StringBuilder();
        buffer.append("<html>" + "<head><title>Duke's Bookstore</title></head>");
        buffer.append("<body  bgcolor=\"#ffffff\">" + "<center>" +
                "<hr> <br> &nbsp;" + "<h1>" +
                "<font size=\"+3\" color=\"#CC0066\">Duke's </font> <img src=\"" +
                "./duke.books.gif\" alt=\"Duke holding books\"\">" +
                "<font size=\"+3\" color=\"black\">Bookstore</font>" + "</h1>" +
                "</center>" + "<br> &nbsp; <hr> <br> ");

        buffer.append("<b>What we are reading</b>" + "<p>" +
                "<blockquote><em><a href=\"" +
                "bookdetails?bookId=203" + "\">" + bd.getTitle() +
                "</a></em>" + bd.getDescription() + "</blockquote>");

        buffer.append("<p><a href=\"" +
                "bookcatalog" +
                "\"><b>Start Shopping</b></a></font><br>" +
                "<br> &nbsp;<br> &nbsp;<br> &nbsp;</body></html>");

        return buffer.toString();
    }
}

