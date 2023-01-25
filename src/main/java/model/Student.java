package model;

import java.sql.Blob;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class Student {
    private int id;
    private String lastname;
    private String firstname;
    private String middlename;
    private int groupid;
    private String groupName;
    private String phoneNumber;
    private String email;
    private LocalDate recieptDate;

    private Blob avatar;

    private boolean status;

    public Student() {
    }

    public Student(String lastname, String firstname, String middlename, int groupid, String phoneNumber, String email, LocalDate recieptDate) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.middlename = middlename;
        this.groupid = groupid;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.recieptDate = recieptDate;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public int getGroupid() {
        return groupid;
    }

    public void setGroupid(int groupid) {
        this.groupid = groupid;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getRecieptDate() {
        return recieptDate;
    }

    public void setRecieptDate(LocalDate recieptDate) {
        this.recieptDate = recieptDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        Student student = (Student) o;
        return id == student.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lastname, firstname, middlename, groupid, phoneNumber, email, recieptDate);
    }

    public Blob getAvatar() {
        return avatar;
    }

    public void setAvatar(Blob avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", middlename='" + middlename + '\'' +
                ", groupid=" + groupid +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", recieptDate=" + recieptDate +
                '}';
    }
}
