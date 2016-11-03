package demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet(name = "BookCatalogServlet", urlPatterns="/bookcatalog")

public class BookCatalogServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {
            BookDBAO db = new BookDBAO();
            List<BookDetails> list = db.getAllBook();
            out.println("<html>" + "<head><title>Duke's Bookstore</title></head>" +
                    "<body  bgcolor=\"#ffffff\">" + "<center>" +
                    "<hr> <br> &nbsp;" + "<h1>" +
                    "<font size=\"+3\" color=\"#CC0066\">Duke's </font> <img src=\"" +
                    "./duke.books.gif\" alt=\"Duke holding books\"\">" +
                    "<font size=\"+3\" color=\"black\">Bookstore</font>" + "</h1>" +
                    "</center>" + "<br> &nbsp; <hr> <br> ");

            out.println("<br> &nbsp;" + "<h3>Please Choose from our selection" +
                    "</h3>" + "<center> <table summary=\"layout\">");

            for (BookDetails book : list) {
                String bookId = book.getBookId();
                out.println("<tr>" + "<td bgcolor=\"#ffffaa\">" + "<a href=\"" +
                        response.encodeURL(request.getContextPath() +
                                "/bookdetails?bookId=" + bookId) + "\"> <strong>" +
                        book.getTitle() + "&nbsp; </strong></a></td>" +
                        "<td bgcolor=\"#ffffaa\" rowspan=2>" + book.getPrice() +
                        "&nbsp; </td>" + "<td bgcolor=\"#ffffaa\" rowspan=2>" +
                        "<a href=\"" +
                        response.encodeURL(request.getContextPath() +
                                "/bookcatalog?bookId=" + bookId) + "\"> &nbsp;" +
                        "Add to Cart&nbsp;</a></td></tr>" +
                        "<tr>" + "<td bgcolor=\"#ffffff\">" + "&nbsp; &nbsp;" +
                        "by<em> " + book.getFirstName() +
                        " " + book.getSurname() + "</em></td></tr>");
            }

            out.println("</table></center></body></html>");
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
        /*try {
            BookDBAO db = new BookDBAO();
            List<BookDetails> list = db.getAllBook();
            request.setAttribute("books", list);
            getServletContext().getRequestDispatcher("/bookcatalog.jsp").forward(request, response);
            } catch (Exception e) {
                e.printStackTrace();
                throw new ServletException(e);
            }
        PrintWriter out = response.getWriter();

        BookDBAO db = new BookDBAO();
        List<BookDetails> list = db.getAllBook();
        out.println("<html>" + "<head><title>Duke's Bookstore</title></head>" +
                "<body  bgcolor=\"#ffffff\">" + "<center>" +
                "<hr> <br> &nbsp;" + "<h1>" +
                "<font size=\"+3\" color=\"#CC0066\">Duke's </font> <img src=\"" +
                "./duke.books.gif\" alt=\"Duke holding books\"\">" +
                "<font size=\"+3\" color=\"black\">Bookstore</font>" + "</h1>" +
                "</center>" + "<br> &nbsp; <hr> <br> ");

        out.println("<br> &nbsp;" + "<h3>Please Choose from our selection" +
                "</h3>" + "<center> <table summary=\"layout\">");

        for (BookDetails book : list) {
            String bookId = book.getBookId();
            out.println("<tr>" + "<td bgcolor=\"#ffffaa\">" + "<a href=\"" +
                    response.encodeURL(request.getContextPath() +
                            "/bookdetails?bookId=" + bookId) + "\"> <strong>" +
                    book.getTitle() + "&nbsp; </strong></a></td>" +
                    "<td bgcolor=\"#ffffaa\" rowspan=2>" + book.getPrice() +
                    "&nbsp; </td>" + "<td bgcolor=\"#ffffaa\" rowspan=2>" +
                    "<a href=\"" +
                    response.encodeURL(request.getContextPath() +
                            "/bookcatalog?bookId=" + bookId) + "\"> &nbsp;" +
                    "Add to Cart&nbsp;</a></td></tr>" +
                    "<tr>" + "<td bgcolor=\"#ffffff\">" + "&nbsp; &nbsp;" +
                    "by<em> " + book.getFirstName() +
                    " " + book.getSurname() + "</em></td></tr>");
        }

        out.println("</table></center></body></html>");*/
    }
}
