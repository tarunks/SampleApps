package com.tarun.common;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created with IntelliJ IDEA.
 * User: tarun
 * Date: 11/27/13
 * Time: 11:56 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name="EMPLOYEE")
public class Employee {

    @Id
    @GeneratedValue
    @Column(name="EMP_ID")
    private long empId;
    @Column(name="FIRST_NAME")
    private String firstName;
    @Column(name="LAST_NAME")
    private String lastName;
    @Column(name="ADDRESS")
    private String address;
    @Column(name="DOB")
    private Date dob;


    public Employee(){

    }
    public Employee(String firstName,String lastName,String address,Date dob) {

        this.firstName=firstName;
        this.lastName=lastName;
        this.address=address;
        this.dob=dob;

    }
    public long getEmpId() {
        return empId;
    }

    public void setEmpId(long empId) {
        this.empId = empId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
}
