package org.example;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//change request status from pending to approved
public class ApproveRequestServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String s_id = request.getParameter("approve");
        Integer requestId = Integer.valueOf(s_id);

        HibernateUtil.updateRequestStatus(requestId,"approved");

        //redirect back to pending approvals list
        response.sendRedirect("PendingRequestApprovals");

        out.close();
    }
}
