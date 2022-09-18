package com.example.aulamobile2.model;

import java.util.List;

public class DepartamentoRes {

    private int id;
    private String name;
    private List<ProfessorRes> professors;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ProfessorRes> getProfessors() {
        return professors;
    }

    public void setProfessors(List<ProfessorRes> professors) {
        this.professors = professors;
    }
}
