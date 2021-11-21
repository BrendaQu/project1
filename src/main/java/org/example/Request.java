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
    @JoinColumn(name="empId")
    private Employee employee;
    private float expense;
    private String incStartDate;
    private String incEndDate;
    private String submitDate;
    private String status;
}
