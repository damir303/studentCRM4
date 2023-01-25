package model;

import java.util.Objects;

public class Discipline {
    private String name;
    private int id;

    public Discipline() {
    }

    public Discipline(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        Discipline that = (Discipline) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    @Override
    public String toString() {
        return "Discipline{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }


}
