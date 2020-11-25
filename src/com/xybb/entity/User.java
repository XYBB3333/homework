package com.xybb.entity;

public class User {

    //id
    private Integer user_id;
    //用户名
    private String username;
    //密码
    private String password;
    //姓名
    private String name;
    //电话
    private String telephone;
    //性别
    private String sex;
    //年龄
    private Integer age;
    //角色
    private String role;

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", telephone='" + telephone + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", role='" + role + '\'' +
                '}';
    }

    public User(Integer user_id, String username, String password, String name, String telephone, String sex, Integer age, String role) {
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.telephone = telephone;
        this.sex = sex;
        this.age = age;
        this.role = role;
    }

    public User() {
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
