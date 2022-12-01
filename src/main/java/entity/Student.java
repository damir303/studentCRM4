package entity;

import java.util.Date;

public class Student {
    private int id;
    private String surname;
    private String name;
    private String group;
    private byte status;
    private Date date_enter;

    public Student() {
    }

    public Student(int id, String surName, String name, String group, byte status, Date date_enter) {
        this.id = id;
        this.surname = surName;
        this.name = name;
        this.group = group;
        this.status = status;
        this.date_enter = date_enter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surName) {
        this.surname = surName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    public Date getDate_enter() {
        return date_enter;
    }

    public void setDate_enter(Date date_enter) {
        this.date_enter = date_enter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (id != student.id) return false;
        if (status != student.status) return false;
        if (surname != null ? !surname.equals(student.surname) : student.surname != null) return false;
        if (name != null ? !name.equals(student.name) : student.name != null) return false;
        if (group != null ? !group.equals(student.group) : student.group != null) return false;
        return date_enter != null ? date_enter.equals(student.date_enter) : student.date_enter == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (group != null ? group.hashCode() : 0);
        result = 31 * result + (int) status;
        result = 31 * result + (date_enter != null ? date_enter.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", surName='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", group='" + group + '\'' +
                ", status=" + status +
                ", date_enter=" + date_enter +
                '}';
    }
}
