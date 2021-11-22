package org.example;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//Add expense form information into database
public class AddExpenseRequestServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        Cookie[] cookies = request.getCookies();
        Integer empId = Integer.valueOf(cookies[0].getValue());

        String incStartDate = request.getParameter("incStartDate");
        String incEndDate = request.getParameter("incEndDate");
        String purpose = request.getParameter("purpose");
        String expense = request.getParameter("expense");
        String todayDate = request.getParameter("todayDate");

        String status = "pending";

        Float f_expense = Float.valueOf(expense);

        Request r = new Request();

        r.setIncStartDate(incStartDate);
        r.setIncEndDate(incEndDate);
        r.setPurpose(purpose);
        r.setExpense(f_expense);
        r.setSubmitDate(todayDate);
        r.setStatus(status);

        HibernateUtil.addRequest(empId, r);

        //redirect back to expense form servlet to submit another response
        response.sendRedirect("ExpenseFormServlet");

        out.close();

    }
}
