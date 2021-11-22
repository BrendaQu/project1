package org.example;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
//update request status from pending to rejected
public class RejectRequestServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String s_id = request.getParameter("reject");
        Integer requestId = Integer.valueOf(s_id);

        HibernateUtil.updateRequestStatus(requestId,"rejected");

        RequestDispatcher rd = request.getRequestDispatcher("PendingRequestApprovals");
        rd.include(request,response);

        response.sendRedirect("PendingRequestApprovals");

        out.close();
    }
}
