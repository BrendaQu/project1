package org.example;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class SearchEmployeeResultServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String s_id = request.getParameter("search");
        Integer search_id = Integer.valueOf(s_id);

        Cookie[] cookies = request.getCookies();
        Integer empId = Integer.valueOf(cookies[0].getValue());

        Employee employee_manager = HibernateUtil.getEmployeeById(empId);
        Employee employee_search = HibernateUtil.getEmployeeById(search_id);
        List<Request> requests = HibernateUtil.getRequestsByEmployeeId(search_id);

        request.getRequestDispatcher("SearchEmployeeServlet").include(request, response);

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
                "    <title>Search Employee Page</title>\n" +
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
                "                        <a class=\"nav-link\" href=\"ProfileServlet\">Menu</a>\n" +
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
                "                <h3>"+ employee_manager.getName() +"</h3>\n" +
                "            </div>\n" +
                "            <div class=\"profile-info-item1 col-2\">\n" +
                "                <p><strong> Title </strong>: &nbsp;"+ employee_manager.getTitle() +"</p>\n" +
                "                <p><strong> Start Date </strong>: &nbsp;" + employee_manager.getEmpStartDate() + "</p>\n" +
                "                <p><strong> Country </strong>: &nbsp;"+ employee_manager.getCountry() +"</p>\n" +
                "            </div>\n" +
                "            <div class=\"profile-info-item2 col-8\">\n" +
                "                <p><strong> Employee ID </strong>: &nbsp;"+ employee_manager.getId() +"</p>" +
                "                <p><strong> Email </strong>: &nbsp;"+ employee_manager.getEmail() +"</p>\n" +
                "                <p><strong> Phone </strong>: &nbsp;"+ employee_manager.getPhone() +"</p>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "    <br />\n" +
                "    <div class=\"employee-info\">\n" +
                "        <h4>Employee Information</h4>\n" +
                "        <table class=\"table table-borderless\">\n" +
                "            <tr>\n" +
                "                <td><strong>Name: </strong>"+ employee_search.getName() +"</td>\n" +
                "                <td><strong>Employee ID: </strong>"+ employee_search.getId() +"</td>\n" +
                "                <td><strong>Title: </strong>"+ employee_search.getTitle() +"</td>\n" +
                "                <td><strong>Email: </strong>"+ employee_search.getEmail() +"</td>\n" +
                "                <td><strong>Phone: </strong>"+ employee_search.getPhone() +"</td>\n" +
                "            </tr>\n" +
                "        </table>\n" +
                "    </div>");

        out.println("<div class='expense-table'>" +
                "             <h2>Employee's Expense Reimbursement</h2>" +
                "                       <table class='table table-hover'>" +
                "                       <thead> " +
                "                            <tr>" +
                "                              <th>Request ID</th>" +
                "                              <th>Employee ID</th>" +
                "                               <th>Incurred Start Date</th>" +
                "                               <th>Incurred End Date</th>" +
                "                               <th>Purpose</th>" +
                "                               <th>Reported Expense</th>" +
                "                               <th>Submit Date</th>" +
                "                               <th>Status</th>" +
                "                               <th></th>" +
                "                            </tr>" +
                "                          </thead>" +
                "                        <tbody>");
                for(Request r: requests){
                                out.println("<tr>" +
                "                        <td>" + r.getRequestId() + "</td>" +
                "                        <td>" + r.getEmployee().getId() + "</td>" +
                "                        <td>" + r.getIncStartDate() + "</td>" +
                "                        <td>" + r.getIncEndDate() + "</td>" +
                "                        <td>" + r.getPurpose() + "</td>" +
                "                        <td> $" + r.getExpense() + "</td>" +
                "                        <td>" + r.getSubmitDate() + "</td>" +
                "                        <td>" + r.getStatus() + "</td>");
                            }
                               out.println("</tbody>" +
                "                          </table>" +
                "                    </div>" +
                                       "    <div class=\"back-button\">\n" +
                                               "        <a href=\"SearchEmployeeServlet\"><button type=\"submit\" class=\"btn btn-primary\">Back</button></a>\n" +
                                       "    </div>" +
                                       "    <footer>\n" +
                                       "        <h6>© Copyright 2021, One Inc.</h6>\n" +
                                       "    </footer>\n" +
                                       "    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js\"\n" +
                                       "        integrity=\"sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p\"\n" +
                                       "        crossorigin=\"anonymous\"></script>\n" +
                                       "</body>\n" +
                                       "</html>");

        out.close();
    }
}
