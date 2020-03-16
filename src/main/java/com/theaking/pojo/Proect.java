package com.theaking.pojo;

public class Proect {
    private Integer id;

    private String name;

    private Float porjcetBudget;

    public Proect(Integer id, String name, Float porjcetBudget) {
        this.id = id;
        this.name = name;
        this.porjcetBudget = porjcetBudget;
    }

    public Proect() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Float getPorjcetBudget() {
        return porjcetBudget;
    }

    public void setPorjcetBudget(Float porjcetBudget) {
        this.porjcetBudget = porjcetBudget;
    }
}