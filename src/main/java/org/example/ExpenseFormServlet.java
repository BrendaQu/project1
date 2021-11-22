package org.example;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ExpenseFormServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        Cookie[] cookies = request.getCookies();
        Integer empId = Integer.valueOf(cookies[0].getValue());

        Employee employee = HibernateUtil.getEmployeeById(empId);

        out.println("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                "    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\"\n" +
                "        integrity=\"sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3\" crossorigin=\"anonymous\">\n" +
                "    <link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">\n" +
                "    <link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>\n" +
                "    <link href=\"https://fonts.googleapis.com/css2?family=Roboto&display=swap\" rel=\"stylesheet\">\n" +
                "    <link rel=\"stylesheet\" href=\"style.css\">\n" +
                "    <title>Employee Page</title>\n" +
                "</head>\n" +
                "\n" +
                "<body>\n" +
                "    <nav class=\"navbar navbar-expand-lg navbar-dark\">\n" +
                "        <div class=\"container-fluid\">\n" +
                "            <a class=\"navbar-brand\" href=\"#\">One Inc.</a>\n" +
                "            <button class=\"navbar-toggler\" type=\"button\" data-bs-toggle=\"collapse\"\n" +
                "                data-bs-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\"\n" +
                "                aria-label=\"Toggle navigation\">\n" +
                "                <span class=\"navbar-toggler-icon\"></span>\n" +
                "            </button>\n" +
                "            <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\n" +
                "                <ul class=\"navbar-nav ms-auto mb-2 mb-lg-0\">\n" +
                "                    <li class=\"nav-item\">\n" +
                "                        <a class=\"nav-link\" href=\"EmployeeLoginServlet\">Report</a>\n" +
                "                    </li>\n" +
                "                    <li class=\"nav-item\">\n" +
                "                        <a class=\"nav-link\" href=\"LogoutServlet\">Logout</a>\n" +
                "                    </li>\n" +
                "                </ul>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "    </nav>\n" +
                "    <div class=\"profile-wrapper\">\n" +
                "        <div class=\"row\">\n" +
                "            <div class=\"profile-img col-2\">\n" +
                "                <img src=\"img/profile.jpg\">\n" +
                "                <h3>"+employee.getName()+"</h3>\n" +
                "            </div>\n" +
                "            <div class=\"profile-info-item1 col-2\">\n" +
                "                <p>Title: "+employee.getTitle()+"</p>\n" +
                "                <p>Start Date: " + employee.getEmpStartDate()+ "</p>\n" +
                "                <p>Country: "+employee.getCountry()+"</p>\n" +
                "            </div>\n" +
                "            <div class=\"profile-info-item2 col-8\">\n" +
                "                <p>ID: "+employee.getId()+"</p>\n" +
                "                <p>Email: "+employee.getEmail()+"</p>\n" +
                "                <p>Phone: "+employee.getPhone()+"</p>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "    <div class=\"expense-wrapper\">\n" +
                "        <form method=\"post\" action=\"AddExpenseRequestServlet\">\n" +
                "            <div class=\"form-group\">\n" +
                "                <label for=\"incStartDate\">Incurred Start Date</label>\n" +
                "                <input class=\"form-control\" type=\"date\" id=\"incStartDate\" name=\"incStartDate\">\n" +
                "            </div>\n" +
                "            <div class=\"form-group\">\n" +
                "                <label for=\"incEndDate\">Incurred End Date</label>\n" +
                "                <input class=\"form-control\" type=\"date\" id=\"incEndDate\" name=\"incEndDate\">\n" +
                "            </div>\n" +
                "            <div class=\"form-group\">\n" +
                "                <label for=\"purpose\">Purpose</label>\n" +
                "                <input class=\"form-control\" type=\"text\" id=\"purpose\" name=\"purpose\">\n" +
                "            </div>\n" +
                "            <div class=\"form-group\">\n" +
                "                <label for=\"expense\">Expense</label>\n" +
                "                <input class=\"form-control\" type=\"text\" id=\"expense\" name=\"expense\">\n" +
                "            </div>\n" +
                "            <div class=\"form-group\">\n" +
                "                <label for=\"todayDate\">Today's Date</label>\n" +
                "                <input class=\"form-control\" type=\"date\" id=\"todayDate\" name=\"todayDate\">\n" +
                "            </div>\n" +
                "            <button type=\"submit\" class=\"btn btn-primary col-12\">submit</button>\n" +
                "        </form>\n" +
                "    </div>\n" +
                "    <footer>\n" +
                "        <h6>© Copyright 2021, One Inc.</h6>\n" +
                "    </footer>\n" +
                "    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js\"\n" +
                "        integrity=\"sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p\"\n" +
                "        crossorigin=\"anonymous\"></script>\n" +
                "</body>\n" +
                "\n" +
                "</html>");

        out.close();
    }
}
