package com.theaking.pojo;

public class Work {
    private Integer id;

    private Integer projectId;

    private String name;

    private Float price;

    private String unit;

    public Work(Integer id, Integer projectId, String name, Float price, String unit) {
        this.id = id;
        this.projectId = projectId;
        this.name = name;
        this.price = price;
        this.unit = unit;
    }

    public Work() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }
}