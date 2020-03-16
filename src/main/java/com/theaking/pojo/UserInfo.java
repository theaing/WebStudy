package com.theaking.pojo;

public class UserInfo {
    private Integer id;

    private String name;

    private String pwd;

    private String phone;

    private String role;

    public UserInfo(Integer id, String name, String pwd, String phone, String role) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
        this.phone = phone;
        this.role = role;
    }

    public UserInfo() {
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

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }
}