package org.example;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="employees")
public class Employee {
    @Id
    @Column(name = "empId")
    private int empId;
    private String name;
    @Column(unique=true, name="email")
    private String email;
    private String password;
    private String empStartDate;
    private String phone;
    private String country;
    private String title;
    private String type;
    @OneToMany(mappedBy="employee")
    private List<Request> request = new ArrayList<Request>();

    public Employee() {}

    public Employee(int empId, String name, String email, String password, String empStartDate, String phone, String country, String title, String type){
        this.empId = empId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.empStartDate = empStartDate;
        this.phone = phone;
        this.country = country;
        this.title = title;
        this.type = type;
    }

    public int getId() {
        return empId;
    }
    public void setId(int empId){
        this.empId = empId;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }

    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }

    public String getEmpStartDate(){
        return empStartDate;
    }
    public void setEmpStartDate(String empStartDate){
        this.empStartDate = empStartDate;
    }

    public String getPhone(){
        return phone;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }

    public String getCountry(){
        return country;
    }
    public void setCountry(String country){
        this.country = country;
    }

    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }

    public String getType(){
        return type;
    }
    public void setType(String type){
        this.type = type;
    }

    public List<Request> getRequest() {
        return request;
    }

    public void setRequests(List<Request> request) {
        this.request = request;
    }
}
