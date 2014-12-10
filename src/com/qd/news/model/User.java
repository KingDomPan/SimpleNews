package com.qd.news.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.qd.news.template.ItemTemplate;

@Document(collection = "user")
public class User implements ItemTemplate {
    @Id
    private String id;
    @Indexed(unique = true)
    private String username;
    private String password;
    private String sex;
    private String email;
    private String realname;

    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", password="
                + password + ", sex=" + sex + ", email=" + email
                + ", realname=" + realname + ", job=" + job + "]";
    }

    private String job;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

}
