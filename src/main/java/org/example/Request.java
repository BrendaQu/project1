package org.example;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "requests")
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "requestId")
    private int requestId;
    @ManyToOne
    @JoinColumn(name="empId", nullable = false)
    private Employee employee;
    private float expense;
    private String incStartDate;
    private String incEndDate;
    private String purpose;
    private String submitDate;

    public Request() {

    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public float getExpense() {
        return expense;
    }

    public void setExpense(float expense) {
        this.expense = expense;
    }

    public String getIncStartDate() {
        return incStartDate;
    }

    public void setIncStartDate(String incStartDate) {
        this.incStartDate = incStartDate;
    }

    public String getIncEndDate() {
        return incEndDate;
    }

    public void setIncEndDate(String incEndDate) {
        this.incEndDate = incEndDate;
    }

    public String getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(String submitDate) {
        this.submitDate = submitDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private String status;
}
