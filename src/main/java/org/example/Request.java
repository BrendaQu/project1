package org.example;

import javax.persistence.*;

@Entity
@Table(name = "Requests")
public class Request {
    @Id
    @GeneratedValue
    @Column(name = "requestId")
    @ManyToOne
    private int empId;
    private int requestId;
    private float expense;
    private String incStartDate;
    private String incEndDate;
    private String submitDate;
    private String status;
}
