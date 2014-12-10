package com.qd.news.dto;

import com.qd.news.model.User;

public class UserDto {
    private User user;
    private String repassword;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getRepassword() {
        return repassword;
    }

    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }
}
