package org.eniso.oussama.models;

public class User {
    private long id;
    private String name;
    private String email;
    private String tel;
    private String department;
    private String role;

    public User() {
    }

    public User(long id, String name, String email, String tel, String department, String role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.tel = tel;
        this.department = department;
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
